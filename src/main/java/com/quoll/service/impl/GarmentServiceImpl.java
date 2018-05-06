package com.quoll.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quoll.mapper.GarmentMapper;
import com.quoll.model.Garment;
import com.quoll.model.GarmentExample;
import com.quoll.service.GarmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("garmentService")
public class GarmentServiceImpl implements GarmentService{

    @Autowired
    private GarmentMapper garmentMapper;

    @Override
    public PageInfo<Garment> selectByPage(int start, int length) {
        int page = start/length+1;
        GarmentExample example = new GarmentExample();
        //Paging query
        PageHelper.startPage(page, length);
        List<Garment> list = garmentMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    public Garment selectByID(Integer id) {
        Garment garment = garmentMapper.selectByPrimaryKey(id);
        return garment;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int delByID(Integer id) {
        return garmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int update(Garment obj){
       return garmentMapper.updateByPrimaryKeySelective(obj);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int insert(Garment obj) {
        return garmentMapper.insertSelective(obj);
    }

    @Override
    public List<Garment> getGarmentsByCompanyID(int companyid){
        GarmentExample example = new GarmentExample();
        GarmentExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyidEqualTo(companyid);
        List<Garment> list = garmentMapper.selectByExample(example);
        return list;
    }

    @Override
    public int delByCompanyID(Integer id) {
        GarmentExample example = new GarmentExample();
        GarmentExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyidEqualTo(id);
        return garmentMapper.deleteByExample(example);
    }

    @Override
    public int inactiveByCompanyID(int companyID){
        return garmentMapper.inactiveByCompanyID(companyID);
    }
}
