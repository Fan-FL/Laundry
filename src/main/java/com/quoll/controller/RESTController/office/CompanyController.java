package com.quoll.controller.RESTController.office;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Company;
import com.quoll.model.Garment;
import com.quoll.service.CompanyService;
import com.quoll.service.GarmentService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/office/company")
public class CompanyController {
    @Resource
    private CompanyService companyService;
    @Resource
    private GarmentService garmentService;

    @RequestMapping("/getOne")
    @RequiresRoles("office")
    public Company getOne(Integer id) {
        try {
            return companyService.selectCompanyGarments(id,null);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

    @RequestMapping("/getAll")
    @RequiresRoles("office")
    public Map<String,Object> getAll(@RequestParam(required = false, defaultValue = "") String active,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10000") int length){
        try{
            Map<String,Object> map = new HashMap<>();
            PageInfo<Company> pageInfo = companyService.selectByPage(start, length, active);
            map.put("recordsTotal",pageInfo.getTotal());
            map.put("recordsFiltered",pageInfo.getTotal());
            map.put("data", pageInfo.getList());
            return map;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/updateCompany")
    @RequiresRoles("office")
    @Transactional
    public String updateCompany(@RequestBody Company company) {
        try {
            companyService.update(company);
            garmentService.inactiveByCompanyID(company.getId());
            for (Garment g: company.getGarmentsList()) {
                g.setCompanyid(company.getId());
                garmentService.insert(g);
            }
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/add")
    @RequiresRoles("office")
    public String add(@RequestBody Company company) {
        try {
            companyService.insert(company);
            int cid = company.getId();
            for (Garment g: company.getGarmentsList()) {
                g.setCompanyid(cid);
                garmentService.insert(g);
            }
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/getAllGarment")
    @RequiresRoles("office")
    public String getAllGarment(int companyid) {
        try {
            companyService.selectCompanyGarments(companyid,null);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/delete")
    @RequiresRoles("office")
    public String delete(int id) {
        try {
            Company company = new Company();
            company.setId(id);
            company.setActive("0");
            companyService.update(company);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/activate")
    @RequiresRoles("office")
    public String activate(int id) {
        try {
            Company company = new Company();
            company.setId(id);
            company.setActive("1");
            companyService.update(company);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

}
