package com.mybatis.SpringBootWithComplexMybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mybatis.SpringBootWithComplexMybatis.model.Customer;

@Mapper
public interface CustomerMapper {

    @Insert("INSERT INTO Customer (first_name, last_name, email, city, state) " +
    "VALUES (#{firstName}, #{lastName}, #{email}, #{city}, #{state})")
    void insertCustomer(Customer customer);

    @Select("<script>" +
    "SELECT id, first_name AS firstName, last_name AS lastName, email, city, state FROM Customer" +
    " WHERE 1=1" +
    "<if test='firstName != null and firstName !=\"\"'>" +
    " AND first_name = #{firstName}" +
    "</if>" +
    "<if test='lastName != null and lastName !=\"\"'>" +
    " AND last_name = #{lastName}" +
    "</if>" +
    "<if test='city != null and city != \"\"'>" +
    " AND city = #{city}" +
    "</if>" +
    "<if test='state != null and state != \"\"'>" +
    " AND state = #{state}" +
    "</if>" +
    "</script>")
    
    List<Customer> findCustomersByCriteria(@Param("firstName") String firstName,
    @Param("lastName") String lastName,
    @Param("city") String city,
    @Param("state") String state);
}
