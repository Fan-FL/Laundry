package com.quoll.service;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Orderitems;
import com.quoll.model.OrderitemsKey;

import java.util.List;


public interface OrderitemsService {

    Orderitems selectByPrimaryKey(OrderitemsKey key);

    List<Orderitems> selectGarmentItemByOrderID(int orderid);

    int delByOrderID(Integer id);

    int delByGarmentID(Integer id);

    PageInfo<Orderitems> selectByPage(int start, int length);

    int update(Orderitems obj);

    int insert(Orderitems obj);
}
