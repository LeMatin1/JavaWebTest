
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

insert commodityInfo values(902083,201,'����',5,6,'һ��'),
(902084,201,'��ţ��',3,4,'������'),
(902085,203,'���',2,3,'������'),
(902086,202,'ë��',12,8,'��')

set identity_insert commodity_info off

insert commodityInfo values(201,'����',5,6,'һ��')

delete  from commodityInfo

drop table commodityInfo

select * into commodityInfo from commodity_info where 1 =2

update commodityInfo set 
	commodityMan = 202,
	commodityName = 'asd',
	commodityPrice =123,
	commodityStockId = 12,
	commodityVaildDate = 'w'