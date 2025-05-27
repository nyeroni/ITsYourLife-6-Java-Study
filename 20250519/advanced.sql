-- 다음 컬럼을 가지는 userTBL과 buyTBL을 정의하세요
drop table if exists usertbl;
drop table if exists buytbl;

create table userTBL (
    userID char(8) not null primary key ,
    name varchar(10) not null,
    birthyear int not null
);

create table buyTBL (
    num int auto_increment not null primary key,
    userID char(8) not null,
    prodName char(6) not null,
    foreign key (userID) references usertbl(userID)
);

-- 다음 조건을 만족하는 userTBL 테이블을 정의하세요
drop table if exists buytbl;
drop table if exists usertbl;

create table userTBL (
    userID char(8) not null primary key ,
    name varchar(10) not null,
    birthyear int not null,
    email char(30) null unique
);

-- 다음 조건을 만족하는 userTBL 테이블을 정의하세요
drop table if exists usertbl;
create table userTBL (
    userID char(8) not null primary key ,
    name varchar(10) null,
    birthYear int null check (birthYear >= 1900 AND birthyear <= 2023),
    mobile char(3) not null
);

-- 다음 조건을 만족하는 userTBL 테이블을 정의하세요
drop table if exists usertbl;
create table userTBL (
    userID char(8) not null primary key ,
    name varchar(10) not null,
    birthYear int not null default -1,
    addr char(2) not null default '서울',
    mobile1 char(3) null,
    mobile2 char(8) null,
    height smallint null default 170,
    mDate date null
);

-- 기본값 추가를 확인할 수 있는 데이터를 추가하세요.
insert into usertbl values ('LHL', '이혜리', default, default,'011', '1234567', default, '2023.12.12');

-- 앞에서 만든 userTBL에 대해서 다음 조건을 처리하도록 수정하세요.
-- mobile1 컬럼을 삭제함
alter table usertbl drop column mobile1;
-- name 컬럼명을 uName으로 변경함
alter table usertbl change column name uName varchar(10) not null;
-- 기본키를 제거함
alter table usertbl drop primary key ;

-- 모든 문제는 employees 데이터베이스에서 수행
use employees;

-- 다음 정보를 가지는 직원 정보를 출력하는 EMPLOYEES_INFO 뷰를 작성하세요
create view EMPLOYEES_INFO as
select A.emp_no, A.birth_date, A.first_name, A.last_name, A.gender, A.hire_date,
    B.title, B.from_date AS t_from, B.to_date AS t_to,
    C.salary, C.from_date AS s_from, C.to_date AS s_to
from employees A
         join titles B on A.emp_no = B.emp_no
         join salaries C on B.emp_no = C.emp_no;

-- employees_info 뷰에서 재직자의 현재 정보만 출력하세요.
drop view if exists employees_info;
create view employees_info as
select a.emp_no, a.birth_date, a.first_name, a.last_name, a.gender, a.hire_date,
    b.title, b.from_date as t_from, b.to_date as t_to,
    c.salary, c.from_date as s_from, c.to_date as s_to
from employees a
         join titles b on a.emp_no = b.emp_no
         join salaries c on b.emp_no = c.emp_no
where c.to_date >= current_date();

select *
from employees_info;

-- 다음 정보를 가지는 부서 정보를 출력하는 emp_dept_info 뷰를 작성하세요
drop view if exists emp_dept_info;
create view emp_dept_info as
select a.emp_no, b.dept_no, c.dept_name, b.from_date, b.to_date
from employees a
         join dept_emp b on a.emp_no = b.emp_no
         join departments c on b.dept_no = c.dept_no
order by a.emp_no;

select *
from emp_dept_info;

-- emp_dept_info로 현재 재직자의 부서 정보를 출력하세요.
drop view if exists emp_dept_info;
create view emp_dept_info as
select a.emp_no, b.dept_no, c.dept_name, b.from_date, b.to_date
from employees a
         join dept_emp b on a.emp_no = b.emp_no
         join departments c on b.dept_no = c.dept_no
where b.to_date >= current_date()
order by a.emp_no;

select *
from emp_dept_info;
