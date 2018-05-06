package com.quoll.mapper;

import com.quoll.model.Laundryorder;
import com.quoll.model.Recurringorder;
import com.quoll.model.RecurringorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecurringorderMapper {
    long countByExample(RecurringorderExample example);

    int deleteByExample(RecurringorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recurringorder record);

    int insertSelective(Recurringorder record);

    List<Recurringorder> selectByExample(RecurringorderExample example);

    Recurringorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recurringorder record, @Param("example") RecurringorderExample example);

    int updateByExample(@Param("record") Recurringorder record, @Param("example") RecurringorderExample example);

    int updateByPrimaryKeySelective(Recurringorder record);

    int updateByPrimaryKey(Recurringorder record);

    Recurringorder selectByIDRef(Integer id);

    List<Recurringorder> selectAllRef();

    List<Recurringorder> selectRefSelective(@Param("record") Recurringorder record);
}