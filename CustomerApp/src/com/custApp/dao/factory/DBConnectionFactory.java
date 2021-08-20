package com.custApp.dao.factory;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;



public class DBConnectionFactory {
  private static Connection connection=null;
   public static String filepath="C:\\Users\\ve00ym268\\Documents\\workspace-spring-tool-suite-4-4.4.2.RELEASE\\CustomerApp\\db.properties";
    private DBConnectionFactory() {}
   
    public static Connection getConnection()  {
       
      // BufferedReader is=new BufferedReader(new FileReader(new File(filepath)));
    	 InputStream is=DBConnectionFactory.class.getClassLoader().getResourceAsStream(filepath);
       
               
        Properties properties=new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        String url=properties.getProperty("jdbc.url");
        String driverName=properties.getProperty("jdbc.drivername");
        String username=properties.getProperty("jdbc.username");
        String password=properties.getProperty("jdbc.password");
       
        //load the driver
        try {
            Class.forName(driverName);
        }catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            connection=DriverManager.getConnection(url, username, password);
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        //conn object
        return connection;
       
    }
}