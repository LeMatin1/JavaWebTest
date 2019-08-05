--½¨¿â
USE master
GO
IF EXISTS(SELECT * FROM SYSDATABASES WHERE NAME = 'emp_db')
DROP DATABASE emp_db
GO                                                            
CREATE DATABASE emp_db
ON PRIMARY
(
	NAME = 'emp_db',
	FILENAME = 'D:\SQL\db\emp_db.mdf',
	SIZE = 5MB,
	FILEGROWTH = 1MB
)                                                             
LOG ON
(
	NAME = 'emp_db_log',
	FILENAME = 'D:\SQL\db\emp_db_log.ldf',
	SIZE = 1MB,
	FILEGROWTH = 10%
)
GO                                                            

USE emp_db
GO
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE NAME = 't_user')
DROP TABLE t_user
GO                                                             
CREATE TABLE t_user
(
	id int identity(1,1) primary key,
	NAME varchar(20) not null,
	password varchar(20) not null,
	age int  not null
)
GO 


IF EXISTS(SELECT * FROM SYSOBJECTS WHERE NAME = 'dept')
DROP TABLE dept
GO                                                             
CREATE TABLE dept
(
	DEPTNO INT PRIMARY KEY not null,
	DNAME varchar(20) not null
)
GO  


IF EXISTS(SELECT * FROM SYSOBJECTS WHERE NAME = 'emp')
DROP TABLE emp
GO                                                             
CREATE TABLE emp
(
	EMPNO INT identity(1001,1) PRIMARY KEY ,
	ENAME VARCHAR(20) not null,
	JOB VARCHAR(20) not null,
	SAL decimal(7,2) not null,
	DEPTNO INT REFERENCES dept(DEPTNO)
)                                                              
GO

insert emp values('Andy','manage',8000,10);
insert emp values('Andy1','manage1',7000,10);
insert emp values('Andy2','manage2',6000,10);
insert emp values('Andy3','manage3',9000,10);


insert t_user values('admin','123456',18);
insert t_user values('test','123456',17);
insert t_user values('web','123456',28);

insert dept values(10,'account');
insert dept values(20,'reserch');
insert dept values(30,'sale');

insert emp values('Andy','manage',8000,10);
insert emp values('Andy1','manage1',7000,10);
insert emp values('Andy2','manage2',6000,10);
insert emp values('Andy3','manage3',9000,10);

insert emp values('steve','clerk',6000,20);
insert emp values('steve1','clerk1',7000,20);
insert emp values('steve2','clerk2',8000,20);
insert emp values('steve3','clerk3',9000,20);

insert emp values('rose','sale',6000,30);
insert emp values('rose1','sale1',5000,30);
insert emp values('rose2','sale2',1000,30);
insert emp values('rose3','sale3',2000,30);

go

select * from t_user
select * from dept
select * from emp

select ROW_NUMBER() over(order by sal) rn,e.EMPNO,e.ENAME,e.JOB,e.SAL,d.DEPTNO,d.DNAME from emp e,dept d where e.DEPTNO = d.DEPTNO

select t.EMPNO,t.ENAME,t.JOB,t.SAL,t.DEPTNO,t.DNAME from (select ROW_NUMBER() over(order by sal) rn,e.EMPNO,e.ENAME,e.JOB,e.SAL,d.DEPTNO,d.DNAME from emp e,dept d where e.DEPTNO = d.DEPTNO) t
where t.rn between 1 and 5

select count(*) from emp

