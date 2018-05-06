package com.quoll.service;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Garment;

import java.util.List;


public interface GarmentService {

    Garment selectByID(Integer id);

    int delByID(Integer id);

    PageInfo<Garment> selectByPage(int start, int length);

    int update(Garment obj);

    int insert(Garment obj);

    List<Garment> getGarmentsByCompanyID(int companyid);

    int delByCompanyID(Integer id);

    int inactiveByCompanyID(int companyID);

}
