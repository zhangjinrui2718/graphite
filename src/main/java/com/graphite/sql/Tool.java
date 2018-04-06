package com.graphite.sql;

import java.sql.*;

public class Tool {
    public void insert(){
        Connection c = null;
        Statement state = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            String insert = "INSERT INTO TEST2(ID,NAME,AGE,ADDRESS,SALARY) "  +
                            "VALUES (2, 'Bxp', 18, 'HangZhou', 30000.00 );";
            state = c.createStatement();
            state.executeUpdate(insert);
            System.out.println("Insert successfully");
            show();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           close(state,c);

        }

    }
    public void show(){
        System.out.println("Latest Table");
        Connection c = null;
        Statement state = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            state = c.createStatement();
            String show = "select * from TEST2;";
            ResultSet rs = state.executeQuery(show);
            printResult(rs);
            state.executeUpdate(show);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(state,c);

        }

    }
    public void printResult(ResultSet rs) throws SQLException {
        while (rs.next()){
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            int age = rs.getInt("AGE");
            String address = rs.getString("ADDRESS");
            int salary = rs.getInt("SALARY");
            System.out.println("ID: "+ id + " NAME: " + name + " AGE: " + age + " ADDRESS: " + address + " SALARY: " + salary);
        }
    }
    public void deleteById(int id){
        Connection c = null;
        Statement state = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            state = c.createStatement();
            String delete = "delete from test2 where id = " + id + ";";
            state.executeUpdate(delete);
            System.out.println("Delete successfully");
            show();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(state, c);
        }

    }
    public void queryById(int id){
        Connection c = null;
        Statement state = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            state = c.createStatement();
            String select = "SELECT * from test2 where id = "+id+";";
            ResultSet rs = state.executeQuery(select);
            System.out.println("Query result");
            printResult(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close(state,c);
        }


    }
    public void updateSalary(int salary,int id){
        Connection c = null;
        Statement state = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            state = c.createStatement();
            String select = "UPDATE  test2 set salary = " + salary + " where id = "+id+";";
            state.executeUpdate(select);
            System.out.println("Update result");
            show();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close(state,c);
        }
    }
    public void close(Statement state,Connection c){
        try{
            if (state!=null){
                state.close();
            }
            if(c != null){
                c.close();
            }
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
