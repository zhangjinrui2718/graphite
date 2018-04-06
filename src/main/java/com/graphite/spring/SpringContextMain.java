package com.graphite.spring;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class SpringContextMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");

        Object obj = context.getBean("dataSource");
        if(obj instanceof  ComboPooledDataSource){
            System.out.println("拿到了数据库连接池对象...");
        }

        ComboPooledDataSource ds = (ComboPooledDataSource) obj;
        try {
            Connection conn = ds.getConnection();
            conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
