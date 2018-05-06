package com.quoll.mapper;

import com.quoll.model.Laundryorder;
import com.quoll.model.LaundryorderExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LaundryorderMapper {
    long countByExample(LaundryorderExample example);

    int deleteByExample(LaundryorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Laundryorder record);

    int insertSelective(Laundryorder record);

    List<Laundryorder> selectByExample(LaundryorderExample example);

    Laundryorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Laundryorder record, @Param("example") LaundryorderExample example);

    int updateByExample(@Param("record") Laundryorder record, @Param("example") LaundryorderExample example);

    int updateByPrimaryKeySelective(Laundryorder record);

    int updateByPrimaryKey(Laundryorder record);
    
    Laundryorder selectByIDRef(Integer orderid);

    List<Laundryorder> selectAllRef();

    List<Laundryorder> selectRefSelective(@Param("record") Laundryorder record);

    List<Laundryorder> selectRefStatusBetweenSelective(@Param("record") Laundryorder record);

    List<Map<String, Object>> reportByCompanyIDBetweenDate(@Param("companyid") Integer companyid, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}