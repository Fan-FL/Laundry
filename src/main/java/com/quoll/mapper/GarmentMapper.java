package com.quoll.mapper;

import com.quoll.model.Garment;
import com.quoll.model.GarmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GarmentMapper {
    long countByExample(GarmentExample example);

    int deleteByExample(GarmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Garment record);

    int insertSelective(Garment record);

    List<Garment> selectByExample(GarmentExample example);

    Garment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Garment record, @Param("example") GarmentExample example);

    int updateByExample(@Param("record") Garment record, @Param("example") GarmentExample example);

    int updateByPrimaryKeySelective(Garment record);

    int updateByPrimaryKey(Garment record);

    int inactiveByCompanyID(Integer companyid);
}