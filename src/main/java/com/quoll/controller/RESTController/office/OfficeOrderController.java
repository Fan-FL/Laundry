package com.quoll.controller.RESTController.office;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Company;
import com.quoll.model.Laundryorder;
import com.quoll.model.User;
import com.quoll.service.*;
import com.quoll.util.Tools;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/office/order")
public class OfficeOrderController {
    @Resource
    private LaundryorderService orderService;

    @Resource
    private UserService userService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private OrderitemsService orderitemsService;

    @Resource
    private CompanyService companyService;

    @Autowired
    private Environment env;

    @RequestMapping("/getOne")
    @RequiresRoles("office")
    public Map<String, Object> getOne(Integer id) {
        try {
            Map<String, Object> map = new HashMap<>();
            Laundryorder laundryorder = orderService.selectByID(id);

            User pickupDriver = userService.selectByKey(laundryorder.getDriverid());
            if (pickupDriver != null) {
                pickupDriver.setPassword("");
                laundryorder.setPickupDriver(pickupDriver);
            }

            User deliveryDriver = userService.selectByKey(laundryorder.getDeliverydriverid());
            if (deliveryDriver != null) {
                deliveryDriver.setPassword("");
                laundryorder.setDeliveryDriver(deliveryDriver);
            }

            User packingPerson = userService.selectByKey(laundryorder.getPackingpersonid());
            if (packingPerson != null) {
                packingPerson.setPassword("");
                laundryorder.setPackingPerson(packingPerson);
            }

            map.put("order", laundryorder);
            map.put("items", orderitemsService.selectGarmentItemByOrderID(id));
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/getAll")
    @RequiresRoles("office")
    public Map<String, Object> getAll(@RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10000") int length) {
        try {
            Map<String, Object> map = new HashMap<>();
            PageInfo<Laundryorder> pageInfo = orderService.selectByPage(start, length);
            map.put("recordsTotal", pageInfo.getTotal());
            map.put("recordsFiltered", pageInfo.getTotal());
            map.put("data", pageInfo.getList());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/update")
    @RequiresRoles("office")
    public String update(Laundryorder o) {
        try {
            orderService.update(o);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/add")
    @RequiresRoles("office")
    public String add(Laundryorder o) {
        try {
            o.setCreateddate(Tools.getCurrentYMD());
            o.setStatus(Integer.parseInt(env.getProperty("order.status.created")));
            o.setStatushistory(env.getProperty("order.status.created") + ";");
            orderService.insert(o);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/getAllDrivers")
    @RequiresRoles("office")
    public List<User> getAllDrivers() {
        return userRoleService.findAllUsersByRoleDesc(env.getProperty("roleDesc.driver"));
    }

    @RequestMapping("/getAllPackingPerson")
    @RequiresRoles("office")
    public List<User> getAllPackingPerson() {
        return userRoleService.findAllUsersByRoleDesc(env.getProperty("roleDesc.packing"));
    }

    @RequestMapping("/deleteOrder")
    @RequiresRoles("office")
    public String deleteByID(int id) {
        try {
            Laundryorder laundryorder = new Laundryorder();
            laundryorder.setId(id);
            laundryorder.setActive("0");
            orderService.update(laundryorder);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/report")
    @RequiresRoles("office")
    public List<Map<String, Object>> getReport(Integer companyID, String startdate, String enddate,
                                               @RequestParam(required = false, defaultValue = "1") int start,
                                               @RequestParam(required = false, defaultValue = "10000") int length) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date startDate = sdf.parse(startdate);
            Date endDate = sdf.parse(enddate);
            return orderService.reportByCompanyIDBetweenDate(companyID, startDate, endDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/excel")
    @RequiresRoles("office")
    public String download(String startdate, String enddate, HttpServletResponse response){
        String fileName = " report from " + startdate + " to " + enddate;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            String columnNames[] = {"Short name", "Full name", "Quantity"};//column name
            String keyName[] = {"shortname","fullname","countNumber"};
            //Create Excel Workbook
            Workbook wb = new HSSFWorkbook();
            List<Company> companyList = companyService.selectByPage(1,1000,"1").getList();
            if(!companyList.isEmpty()){
                for (Company company:companyList) {
                    int rowNum = 0;
                    Sheet sheet = wb.createSheet(company.getName());
                    //Set column width。the first parameter is for which column,，the second parameter is column width in pixel
                    for (int i = 0; i < columnNames.length; i++) {
                        sheet.setColumnWidth((short) i, (short) (35.7 * 150));
                    }
                    //create first row (title)
                    Row row0 = sheet.createRow(rowNum++);
                    //设置列名
                    for (int i = 0; i < columnNames.length; i++) {
                        Cell cell = row0.createCell(i);
                        cell.setCellValue(columnNames[i]);
                    }
                    //data rows
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    Date startDate = sdf.parse(startdate);
                    Date endDate = sdf.parse(enddate);
                    List<Map<String, Object>> dataList = orderService.reportByCompanyIDBetweenDate(company.getId(), startDate, endDate);
                    if(!dataList.isEmpty()){
                        for (Map<String, Object> map : dataList) {
                            // create a row
                            Row row = sheet.createRow(rowNum++);
                            // set row data
                            for (int i = 0; i < keyName.length; i++) {
                                Cell cell = row.createCell(i);
                                cell.setCellValue(map.get(keyName[i]).toString());
                            }
                        }
                    }
                }
            }
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try {
                wb.write(os);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // set response parameter in order to open download page
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
            ServletOutputStream out = response.getOutputStream();
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bos != null)
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
}
