
create table commodityInfo(
	commodityId int primary key,
	commodityMan int not null,
	commodityName varchar(20) not null,
	commodityPrice int not null,
	commodityStockId int not null,
	commodityVaildDate varchar(20)
)

select * from commodity_info
select * from commodityinfo where commodityId=902083

insert commodityInfo values(902083,201,'脉动',5,6,'一年'),
(902084,201,'纯牛奶',3,4,'六个月'),
(902085,203,'面包',2,3,'两个月'),
(902086,202,'毛巾',12,8,'无')

set identity_insert commodity_info off

insert commodityInfo values(201,'脉动',5,6,'一年')

delete  from commodityInfo

drop table commodityInfo

select * into commodityInfo from commodity_info where 1 =2

update commodityInfo set 
	commodityMan = 202,
	commodityName = 'asd',
	commodityPrice =123,
	commodityStockId = 12,
	commodityVaildDate = 'w'