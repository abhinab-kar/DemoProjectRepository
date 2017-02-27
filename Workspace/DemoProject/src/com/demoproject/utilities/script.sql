DROP TABLE oracle_schema.PERSON

select * from oracle_schema.PERSON;
select count(*) from ORACLE_SCHEMA.PERSON


create table oracle_schema.PERSON(
	ID NUMBER(3,0) PRIMARY KEY,
	NAME VARCHAR2(20),
	ADDRESS VARCHAR2(40)
)

insert into oracle_schema.PERSON
values(1, 'Abhinab Kar', 'Dumka');

insert into oracle_schema.PERSON
values(2, 'Ankit Agarwal', 'Kankinara');

insert into oracle_schema.PERSON
values(3, 'Vishal Gupta', 'Girish Park');

insert into oracle_schema.PERSON
values(4, 'Sukanta Dey', 'Chandrapura');

insert into oracle_schema.PERSON
values(5, 'Deep Banerjee', 'Pune');

insert into oracle_schema.PERSON
values(6, 'Abhishek Dhar', 'Mumbai');

insert into oracle_schema.PERSON
values(7, 'Ankit Mishra', 'Dumka');

insert into oracle_schema.PERSON
values(8, 'Anish Ghosh', 'Jamshedpur');

commit