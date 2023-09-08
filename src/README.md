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

## naming rules
id, class, function, name

id, class, url : 두 단어 이상 연결시 "-"로 연결 (member-email)
    url의 네이밍시 언더바는  브라우저의 주소창에 창 보이지 않으니 사용 지양

function : 두 단어 이상 연결시 "_"로 연결(member_email)

name : 두 단어 이상 연결시 camel case로 작성 (memberEmail)
