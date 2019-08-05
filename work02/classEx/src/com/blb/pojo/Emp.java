package com.blb.pojo;

public class Emp {
	private Integer empno;
	private String empname;
	private String empjob;
	private Double empsal;
	private Dept dept;
	
	public Emp(){
		
	}
	
	public Emp(Integer empno, String empname, String empjob, Double empsal, Dept dept) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.empjob = empjob;
		this.empsal = empsal;
		this.dept = dept;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpjob() {
		return empjob;
	}

	public void setEmpjob(String empjob) {
		this.empjob = empjob;
	}

	public Double getEmpsal() {
		return empsal;
	}

	public void setEmpsal(Double empsal) {
		this.empsal = empsal;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	
}
