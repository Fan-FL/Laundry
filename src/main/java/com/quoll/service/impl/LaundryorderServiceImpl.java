package com.quoll.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quoll.mapper.LaundryorderMapper;
import com.quoll.model.Laundryorder;
import com.quoll.model.Orderitems;
import com.quoll.service.GarmentService;
import com.quoll.service.LaundryorderService;
import com.quoll.service.OrderitemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service("laundryorderService")
public class LaundryorderServiceImpl implements LaundryorderService {

    @Autowired
    private LaundryorderMapper oderMapper;

    @Resource
    private OrderitemsService orderitemsService;

    @Resource
    private GarmentService garmentService;

    @Override
    public PageInfo<Laundryorder> selectByPage(int start, int length) {
        int page = start/length+1;
        //Paging query
        PageHelper.startPage(page, length);
        List<Laundryorder> list = oderMapper.selectAllRef();
        return new PageInfo<>(list);
    }

    @Override
    public Laundryorder selectByID(Integer id) {
        Laundryorder o = oderMapper.selectByIDRef(id);
        return o;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int delByID(Integer id) {
        return oderMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int update(Laundryorder obj){
       return oderMapper.updateByPrimaryKeySelective(obj);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int insert(Laundryorder obj) {
        return oderMapper.insertSelective(obj);
    }

    @Override
    public List<Laundryorder> selectRefSelective(Laundryorder order){
        return oderMapper.selectRefSelective(order);
    }

    @Override
    public List<Laundryorder> selectRefStatusBetweenSelective(Laundryorder record){
        return oderMapper.selectRefStatusBetweenSelective(record);
    }

    @Override
    public PageInfo<Laundryorder> selectRefStatusBetweenSelectiveByPage(Laundryorder record, int start, int length){
        int page = start/length+1;
        //Paging query
        PageHelper.startPage(page, length);
        List<Laundryorder> list = oderMapper.selectRefStatusBetweenSelective(record);
        return new PageInfo<>(list);
    }


    @Override
    public PageInfo<Laundryorder> selectRefSelectiveByPage(Laundryorder order, int start, int length){
        int page = start/length+1;
        //Paging query
        PageHelper.startPage(page, length);
        List<Laundryorder> list = oderMapper.selectRefSelective(order);
        return new PageInfo<>(list);
    }

    @Override
    public String getItemsDescriptionByID(Integer id){
        List<Orderitems> orderitemsList = orderitemsService.selectGarmentItemByOrderID(id);
        StringBuilder stringBuilder = new StringBuilder();
        for (Orderitems item :orderitemsList) {
            stringBuilder.append(item.getGarment().getFullname()).append(":").append(item.getPickupnumber()).append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public List<Map<String, Object>> reportByCompanyIDBetweenDate(Integer companyid, Date startDate, Date endDate){
//        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
//        List<Map<String, Object>> dataList = oderMapper.reportByCompanyIDBetweenDate(companyid, startDate, endDate);
//        if (!dataList.isEmpty()){
//            for (Map<String, Object> map:dataList) {
//                Map<String, Object> resultMap = new HashMap();
//                resultMap.put("number", map.get("countNumber"));
//                Long aLong = (Long)map.get("garmentID");
//                Integer garmentID = new Integer(String.valueOf(aLong));
//                resultMap.put("garment", garmentService.selectByID(garmentID));
//                result.add(resultMap);
//            }
//            return result;
//        }else{
//            return null;
//        }
        return oderMapper.reportByCompanyIDBetweenDate(companyid, startDate, endDate);
    }


}
