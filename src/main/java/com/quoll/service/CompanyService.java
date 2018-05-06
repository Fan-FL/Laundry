package com.quoll.service;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Company;


public interface CompanyService {

    Company selectByID(Integer id);

    int delByID(Integer id);

    PageInfo<Company> selectByPage(int start, int length, String active);

    int update(Company obj);

    int insert(Company obj);

    Company selectCompanyGarments(int companyid, String active);
}
