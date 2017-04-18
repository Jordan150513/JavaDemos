package com.fang.home.mapperDAO;

import com.fang.home.model.RelationCOR;
import com.fang.home.model.RelationCORExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelationCORMapper {
    long countByExample(RelationCORExample example);

    int deleteByExample(RelationCORExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RelationCOR record);

    int insertSelective(RelationCOR record);

    List<RelationCOR> selectByExample(RelationCORExample example);

    RelationCOR selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RelationCOR record, @Param("example") RelationCORExample example);

    int updateByExample(@Param("record") RelationCOR record, @Param("example") RelationCORExample example);

    int updateByPrimaryKeySelective(RelationCOR record);

    int updateByPrimaryKey(RelationCOR record);
}