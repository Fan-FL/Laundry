package com.quoll.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quoll.mapper.CompanyMapper;
import com.quoll.model.Company;
import com.quoll.model.CompanyExample;
import com.quoll.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    /**
     *
     * @param start
     * @param length
     * @param active "0":inactive "1":active
     * @return
     */
    @Override
    public PageInfo<Company> selectByPage(int start, int length, String active) {
        int page = start/length+1;
        CompanyExample example = new CompanyExample();
        if(!active.isEmpty()){
            CompanyExample.Criteria criteria = example.createCriteria();
            criteria.andActiveEqualTo(active);
        }
        //Paging query
        PageHelper.startPage(page, length);
        List<Company> list = companyMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    public Company selectByID(Integer id) {
        Company o = companyMapper.selectByPrimaryKey(id);
        return o;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int delByID(Integer id) {
        return companyMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int update(Company obj){
       return companyMapper.updateByPrimaryKeySelective(obj);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int insert(Company obj) {
        return companyMapper.insertSelective(obj);
    }

    @Override
    public Company selectCompanyGarments(int companyid, String active){
        return companyMapper.selectCompanyGarments(companyid, active);
    }
}
