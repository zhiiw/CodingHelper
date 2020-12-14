package com.github.zhiiw.codinghelper.core;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DataBaseUse {
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://*.*.*.*:3306/test?useSSL=false&serverTimezone=UTC";

  // 数据库的用户名与密码，需要根据自己的设置
  static final String USER = "root";
  static final String PASS = "111111";
  SimpleDateFormat dataFormat = new SimpleDateFormat("YYYY-MM-dd");

  public static void updateTime(String lang,double time) {
    java.util.Date date=new java.util.Date();//此时date为当前的时间
    SimpleDateFormat dataFormat = new SimpleDateFormat("YYYY-MM-dd");

    String sql ="UPDATE pluginServer_time SET "+lang+"="+time+"+ "+lang+",total=total+"+time+" WHERE date=\""+dataFormat.format(date)+"\"";

    Connection conn = null;
    Statement stmt = null;
    try{
      // 注册 JDBC 驱动
      Class.forName(JDBC_DRIVER);

      // 打开链接
      System.out.println("连接数据库...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      // 执行查询
      System.out.println(" 实例化Statement对象...");
      stmt = conn.createStatement();

      stmt.executeUpdate(sql);


      // 完成后关闭

      stmt.close();
      conn.close();
    }catch(SQLException se){
      // 处理 JDBC 错误
      se.printStackTrace();
    }catch(Exception e){
      // 处理 Class.forName 错误
      e.printStackTrace();
    }finally{
      // 关闭资源
      try{
        if(stmt!=null) stmt.close();
      }catch(SQLException se2){
      }// 什么都不做
      try{
        if(conn!=null) conn.close();
      }catch(SQLException se){
        se.printStackTrace();
      }
    }

  }

  public static void addNewDay() {
    java.util.Date date=new java.util.Date();//此时date为当前的时间
    SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
    String sqlForUpdate = "INSERT INTO pluginServer_time (c,cpp,java,js,go,hs,total,kt,other,py,rs,date) VALUES(0,0,0,0,0,0,0,0,0,0,0,\""+df.format(date)
            +"\")";

    Connection conn = null;
    Statement stmt = null;
    try{
      // 注册 JDBC 驱动
      Class.forName(JDBC_DRIVER);

      // 打开链接
      System.out.println("连接数据库...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      // 执行查询
      System.out.println(" 实例化Statement对象...");
      stmt = conn.createStatement();
      String sql="SELECT * FROM pluginServer_time where date = \""+df.format(date)+"\"";
      System.out.println(df.format(date));
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()==false){
        System.out.println("The database don't have the data.");
        stmt.executeUpdate(sqlForUpdate);
        System.out.println("added");
      }
      // 完成后关闭
      rs.close();
      stmt.close();
      conn.close();
    }catch(SQLException se){
      // 处理 JDBC 错误
      se.printStackTrace();
    }catch(Exception e){
      // 处理 Class.forName 错误
      e.printStackTrace();
    }finally{
      // 关闭资源
      try{
        if(stmt!=null) stmt.close();
      }catch(SQLException se2){
      }// 什么都不做
      try{
        if(conn!=null) conn.close();
      }catch(SQLException se){
        se.printStackTrace();
      }
    }

  }

}
