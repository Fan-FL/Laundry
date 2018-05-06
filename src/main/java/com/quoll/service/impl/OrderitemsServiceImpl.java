package com.quoll.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quoll.mapper.OrderitemsMapper;
import com.quoll.model.Orderitems;
import com.quoll.model.OrderitemsExample;
import com.quoll.model.OrderitemsKey;
import com.quoll.service.OrderitemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderitemsService")
public class OrderitemsServiceImpl implements OrderitemsService {

    @Autowired
    private OrderitemsMapper orderitemsMapper;

    @Override
    public Orderitems selectByPrimaryKey(OrderitemsKey key){
        return orderitemsMapper.selectByPrimaryKey(key);
    }

    @Override
    public PageInfo<Orderitems> selectByPage(int start, int length) {
        int page = start/length+1;
        OrderitemsExample example = new OrderitemsExample();
        //Paging query
        PageHelper.startPage(page, length);
        List<Orderitems> list = orderitemsMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public List<Orderitems> selectGarmentItemByOrderID(int orderid){
        return orderitemsMapper.selectGarmentItemByOrderID(orderid);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int delByOrderID(Integer id) {
        OrderitemsExample example = new OrderitemsExample();
        OrderitemsExample.Criteria criteria = example.createCriteria();
        criteria.andOrderidEqualTo(id);
        return orderitemsMapper.deleteByExample(example);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int delByGarmentID(Integer id) {
        OrderitemsExample example = new OrderitemsExample();
        OrderitemsExample.Criteria criteria = example.createCriteria();
        criteria.andGarmentidEqualTo(id);
        return orderitemsMapper.deleteByExample(example);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int update(Orderitems obj){
       return orderitemsMapper.updateByPrimaryKeySelective(obj);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public int insert(Orderitems obj) {
        return orderitemsMapper.insertSelective(obj);
    }
}
