package com.blb.dao;

import java.util.List;

import com.blb.pojo.Emp;

public interface EmpDao {

	public int getEmpCount();

	public List<Emp> getEmpPageList(int currentPage, int pageSize);

}
