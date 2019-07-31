package com.blb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	private static final String DRIVERCLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL ="jdbc:sqlserver://localhost:1433;database=User_DB";
	private static final String USERNAME ="sa";
	private static final String PASSWORD ="123456";
	
	private static Connection conn = null;
	
	
	public static void openConnection(){
		try{
			Class.forName(DRIVERCLASS);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public static void executeUpdate(String sql,Object... params){
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i = 0;i<params.length;i++){
				ps.setObject(i+1,params[i]);
			}
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public static ResultSet executeQuery(String sql,Object... params){
		ResultSet rs = null;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i = 0;i<params.length;i++){
				ps.setObject(i+1,params[i]);
			}
			rs=ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;	}
	
	
	public static void closeConnection(){
		if(conn != null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
