package com.fang.home.mapperDAO;

import com.fang.home.model.OperationRight;
import com.fang.home.model.OperationRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationRightMapper {
    long countByExample(OperationRightExample example);

    int deleteByExample(OperationRightExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperationRight record);

    int insertSelective(OperationRight record);

    List<OperationRight> selectByExample(OperationRightExample example);

    OperationRight selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperationRight record, @Param("example") OperationRightExample example);

    int updateByExample(@Param("record") OperationRight record, @Param("example") OperationRightExample example);

    int updateByPrimaryKeySelective(OperationRight record);

    int updateByPrimaryKey(OperationRight record);
}