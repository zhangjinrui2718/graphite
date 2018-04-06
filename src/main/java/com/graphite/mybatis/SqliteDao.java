package com.graphite.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component("SQLITE-DAO")
public interface SqliteDao {
    @Insert("INSERT INTO TEST2(ID,NAME,AGE,ADDRESS,SALARY) VALUES (#{id}, #{name}, ${age}, #{address}, #{salary})")
    void insert(@Param("id") int id
            , @Param("name") String name
            , @Param("age") int age
            , @Param("address") String address
            , @Param("salary") double salary);
}
