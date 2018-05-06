package com.quoll.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quoll.mapper.RecurringorderMapper;
import com.quoll.model.Laundryorder;
import com.quoll.model.Recurringorder;
import com.quoll.model.RecurringorderExample;
import com.quoll.service.RecurringorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("recurringorderService")
public class RecurringorderServiceImpl implements RecurringorderService {

    @Autowired
    private RecurringorderMapper recurringorderMapper;

    @Override
    public PageInfo<Recurringorder> selectByPage(int start, int length) {
        int page = start/length+1;
        //Paging query
        PageHelper.startPage(page, length);
        List<Recurringorder> list = recurringorderMapper.selectAllRef();
        return new PageInfo<>(list);
    }

    @Override
    public Recurringorder selectByID(Integer id) {
        Recurringorder o = recurringorderMapper.selectByIDRef(id);
        return o;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int delByID(Integer id) {
        return recurringorderMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int update(Recurringorder obj){
       return recurringorderMapper.updateByPrimaryKeySelective(obj);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int insert(Recurringorder obj) {
        return recurringorderMapper.insertSelective(obj);
    }

    @Override
    public List<Recurringorder> selectRefSelective(Recurringorder order){
        return recurringorderMapper.selectRefSelective(order);
    }

    @Override
    public PageInfo<Recurringorder> selectRefSelectiveByPage(Recurringorder order, int start, int length){
        int page = start/length+1;
        //Paging query
        PageHelper.startPage(page, length);
        List<Recurringorder> list = recurringorderMapper.selectRefSelective(order);
        return new PageInfo<>(list);
    }
}
