## database 

```sql
create table member_table(
	id bigint auto_increment primary key,
	memberEmail varchar(50) unique,
    memberPassword varchar(20) not null,
    memberName varchar(20) not null,
    memberBirth date not null,
    memberMobile varchar(30) not null
);
```