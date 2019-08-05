package com.blb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.blb.dao.UserDao;
import com.blb.pojo.User;
import com.blb.utils.*;

public class UserDaoImpl implements UserDao {
	public User login(User user){
		User loginUser = null;
		DBUtils.openConnection();
		String sql = "select id,name,password,age from t_user where name=? and password=?";
		ResultSet rs = DBUtils.executeQuery(sql, user.getUsername(),user.getPassword());
		try{
			if(rs.next()){
				loginUser=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection();
		}
		return loginUser;
	}
}
