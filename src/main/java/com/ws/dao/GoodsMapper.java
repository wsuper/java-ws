package com.ws.dao;

import com.ws.model.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface GoodsMapper {
    @Delete({
        "delete from goods",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into goods (id, name, ",
        "code)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR})"
    })
    int insert(Goods record);

    @InsertProvider(type=GoodsSqlProvider.class, method="insertSelective")
    int insertSelective(Goods record);

    @Select({
        "select",
        "id, name, code",
        "from goods",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR)
    })
    Goods selectByPrimaryKey(Integer id);

    @UpdateProvider(type=GoodsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Goods record);

    @Update({
        "update goods",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Goods record);
}