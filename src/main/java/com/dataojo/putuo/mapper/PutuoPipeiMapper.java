package com.dataojo.putuo.mapper;

import com.dataojo.putuo.entity.PutuoPipei;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * (PutuoPipei)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-29 16:33:13
 */
@Mapper
public interface PutuoPipeiMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    @Select("select * from putuo_pipei where id = #{id}")
    PutuoPipei select(@Param("id") int id);

    /**
     * 修改数据
     *
     * @param id 实例对象
     * @return 影响行数
     */
    @Update("update putuo_pipei set matchCount = #{matchCount} where id = #{id}")
    int update(@Param("id") int id,@Param("matchCount") int matchCount);

}