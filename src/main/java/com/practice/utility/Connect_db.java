package com.practice.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect_db {        
    static Connection con=null;
    public static Connection getConnection()
    {
        if (con != null) return con;
        // get db, user, pass from settings file
        return getConnection("java_db", "root", "root");
    }

    private static Connection getConnection(String db_name,String user_name,String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db?useSSL=false", "root", "root");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return con;        
    }}