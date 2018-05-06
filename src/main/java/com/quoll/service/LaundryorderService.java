package com.quoll.service;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Garment;
import com.quoll.model.Laundryorder;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface LaundryorderService {

    Laundryorder selectByID(Integer id);

    int delByID(Integer id);

    PageInfo<Laundryorder> selectByPage(int start, int length);

    int update(Laundryorder obj);

    int insert(Laundryorder obj);

    List<Laundryorder> selectRefSelective(Laundryorder order);

    PageInfo<Laundryorder> selectRefSelectiveByPage(Laundryorder order, int start, int length);

    List<Laundryorder> selectRefStatusBetweenSelective(Laundryorder record);

    PageInfo<Laundryorder> selectRefStatusBetweenSelectiveByPage(Laundryorder record, int start, int length);

    String getItemsDescriptionByID(Integer id);

    List<Map<String, Object>> reportByCompanyIDBetweenDate(Integer companyid, Date startDate, Date endDate);
}
