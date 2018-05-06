package com.quoll.service;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Laundryorder;
import com.quoll.model.Recurringorder;

import java.util.List;


public interface RecurringorderService {

    Recurringorder selectByID(Integer id);

    int delByID(Integer id);

    PageInfo<Recurringorder> selectByPage(int start, int length);

    int update(Recurringorder obj);

    int insert(Recurringorder obj);

    List<Recurringorder> selectRefSelective(Recurringorder order);

    PageInfo<Recurringorder> selectRefSelectiveByPage(Recurringorder order, int start, int length);
}
