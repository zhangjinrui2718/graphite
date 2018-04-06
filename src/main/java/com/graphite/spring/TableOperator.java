package com.graphite.spring;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component(value = "baobaodecaozuolei")
public class TableOperator {

    private final ComboPooledDataSource dataSource;

    @Autowired
    public TableOperator(ComboPooledDataSource dataSource) {
        this.dataSource = dataSource;
    }

    private void insert(int id, String name, int age, String address, double salary) {
        String sql = SqlMaker.getInsertSQL(id, name, age, address, salary);
        try {
            Connection connection = dataSource.getConnection();
            Statement stat = connection.createStatement();
            stat.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void  delete(int id){

    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");

        TableOperator operator = context.getBean("baobaodecaozuolei", TableOperator.class);
        operator.insert(10, "xiaobao", 22, "dengxin", 2.0);
    }
}
