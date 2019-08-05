package com.blb.service;

import java.util.List;

import com.blb.pojo.Emp;

public interface EmpService {
	public int getEmpCount();

	public List<Emp> getEmpPageList(int currentPage, int pageSize);
	
}
