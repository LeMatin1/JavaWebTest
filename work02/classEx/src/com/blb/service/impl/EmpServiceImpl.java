package com.blb.service.impl;

import java.util.List;

import com.blb.dao.EmpDao;
import com.blb.dao.impl.EmpDaoImpl;
import com.blb.pojo.Emp;
import com.blb.service.EmpService;

public class EmpServiceImpl implements EmpService {
	private EmpDao empdao = new EmpDaoImpl();
	@Override
	public int getEmpCount() {
		return empdao.getEmpCount() ;
	}

	@Override
	public List<Emp> getEmpPageList(int currentPage, int pageSize) {
		return empdao.getEmpPageList(currentPage, pageSize);
	}

}
