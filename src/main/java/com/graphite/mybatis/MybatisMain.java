package com.graphite.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        SqliteDao dao = context.getBean("SQLITE-DAO", SqliteDao.class);

        dao.insert(11, "xiaorui", 22, "dengxin", 2.0);
    }
}
