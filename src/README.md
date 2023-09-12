## board-table

```sql
create table board_table(
	id bigint auto_increment primary key,
    boardWriter varchar(50),
    boardPass varchar(20),
    boardTitle varchar(50),
    boardContents varchar(500),
    createdAt datetime default now(),
    boardHits int default 0,
    fileAttached int default 0
);

drop table board_table;
select * from board_table;

create table board_file_table (
    id bigint primary key auto_increment,
    originalFileName varchar(100),
    storedFileName varchar(100),
    boardId bigint,
    constraint foreign key (boardId) references board_table (id) on delete cascade
                              //set null
);

```