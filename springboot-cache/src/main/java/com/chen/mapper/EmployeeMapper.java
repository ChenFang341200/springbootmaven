package com.chen.mapper;

import com.chen.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/8 14:54
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id,jdbcType=INTEGER}")
//    @Results({
//            @Result(column = "id",property = "id",jdbcType = JdbcType.INTEGER),
//            @Result(column = "lastName",property = "lastName",jdbcType = JdbcType.VARCHAR),
//            @Result(column = "email",property = "email",jdbcType = JdbcType.VARCHAR),
//            @Result(column = "gender",property = "gender",jdbcType = JdbcType.INTEGER),
//            @Result(column = "d_id",property = "dId",jdbcType = JdbcType.INTEGER)
//    })
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName = #{lastName},email = #{email},gender=#{gender},d_id=#{dId} where id = #{id,jdbcType=INTEGER}")
    public void updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public void deletEmpById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);

}
