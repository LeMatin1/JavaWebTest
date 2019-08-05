package com.blb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blb.dao.EmpDao;
import com.blb.pojo.Dept;
import com.blb.pojo.Emp;
import com.blb.utils.DBUtils;

public class EmpDaoImpl implements EmpDao {

	@Override
	public int getEmpCount() {
		int count = 0;
		DBUtils.openConnection();
		String sql = "select count(*) from emp";
		ResultSet rs = DBUtils.executeQuery(sql);
		try{
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection();
		}
		return count;
	}

	@Override
	public List<Emp> getEmpPageList(int currentPage, int pageSize) {
		//System.out.println("currentPage="+currentPage +" pageSize="+pageSize);
		List<Emp> empList = new ArrayList<Emp>();
		DBUtils.openConnection();
		String sql = "select t.EMPNO,t.ENAME,t.JOB,t.SAL,t.DEPTNO,t.DNAME from " 
				+ " (select ROW_NUMBER() over(order by sal) rn,e.EMPNO,e.ENAME,e.JOB,e.SAL,d.DEPTNO,d.DNAME from emp e,dept d where e.DEPTNO = d.DEPTNO) t "
				+ " where t.rn between ? and ?";
		ResultSet rs =DBUtils.executeQuery(sql, (currentPage-1)*pageSize+1,currentPage*pageSize);
		try{
			while(rs.next()){
				int i = 0;
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt(++i));
				emp.setEmpname(rs.getString(++i));
				emp.setEmpjob(rs.getString(++i));
				emp.setEmpsal(rs.getDouble(++i));
				emp.setDept(new Dept(rs.getInt(++i),rs.getString(++i)));
				empList.add(emp);
				//System.out.println(empList.size());
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection();
		}
		return empList;
	}

}
