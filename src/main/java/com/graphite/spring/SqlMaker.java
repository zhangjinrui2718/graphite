package com.graphite.spring;

public class SqlMaker {
    public static String getInsertSQL(int id, String name, int age, String address, double salary) {
        return String.format("INSERT INTO TEST2(ID,NAME,AGE,ADDRESS,SALARY) VALUES (%d, '%s', %d, '%s', %f)"
                , id, name, age, address, salary);
    }
}
