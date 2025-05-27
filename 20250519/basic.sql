-- 테이블이 존재하면 삭제
DROP TABLE IF EXISTS tabledb;

-- 다음 컬럼을 가지는 usertbl 테이블을 만드세요
DROP TABLE IF EXISTS usertbl;
create table usertbl (
    userId char(8) not null primary key,
    name varchar(10) not null,
    birthYear int not null,
    addr char(2) not null,
    mobile1 char(3) null,
    mobile2 char(8) null,
    height smallint null,
    mDate DATE null
);

-- 다음 컬럼을 가지는 buytbl 테이블을 만드세요
DROP TABLE IF EXISTS buyTBL;

create table buytbl (
    num int auto_increment not null primary key,
    userId char(8) not null,
    prodName char(6) not null,
    groupName char(4) null,
    price int not null,
    amount smallint not null,
    foreign key(userId) references usertbl(userId)
);

-- 회원 테이블에 다음 데이터를 입력하세요.
insert into usertbl values('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
insert into usertbl values('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
insert into usertbl values('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

-- 구매 테이블에 다음 데이터를 입력하세요.
insert into buytbl values(1,'KBS','운동화',NULL,30,2);
insert into buytbl values(2,'KBS','노트북','전자',1000,1);
# insert into buytbl values(3,'JYP','모니터','전자',200,1); -> 회원 테이블에 'JYP'가 존재하지 않음

-- 다음 컬럼을 가지는 usertbl을 정의하세요
drop table if exists buytbl;
drop table if exists usertbl;

-- 기본키는 테이블 레벨에서 정의하고 제약조건명을 함께 지정함
create table usertbl (
  userID char(8) not null,
  name varchar(10) not null,
  birthYear int not null,
  constraint primary key pk_usertbl_userID(userID)
);

-- 다음 컬럼을 가지는 prodTbl을 정의하세요
drop table if exists prodTbl;
create table prodTbl (
    prodCode char(3) not null,
    prodId char(4) not null,
    prodDate date not null,
    proCur varchar(10) null,
    constraint pk_prodtbl_prdCode_prodId primary key(prodCode,prodId)
);

-- usertbl 과 buytbl을 바탕으로 다음 결과가 나오는 뷰를 정의하세요
create view v_userBuyTbl as
    select u.userid, u.name, prodName, u.addr, concat(u.mobile1,u.mobile2) as '연락처'
    from usertbl u join buytbl b on u.userId = b.userId;

-- 위에서 정의한 뷰에서 userId가 '김범수'인 데이터만 출력하세요.
select *
from v_userBuyTbl
where name = '김범수';
