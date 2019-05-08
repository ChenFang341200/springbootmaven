package com.chen.mapper;

import com.chen.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/7 13:48
 */
@Mapper
@Repository(value = "studentMapper")
public interface StudentMapper {

    @Select({
            "select number,name,age from student where" +
                    " number = #{number,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="number",property="number",jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="age", property="age", jdbcType=JdbcType.INTEGER)
    })
    Student seletByNumber(int number);


    @Select({
            "select number,name,age from student where" +
                    " age = #{age,jdbcType=INTEGER}"
    })
    Student seletByAge(int age);




}
