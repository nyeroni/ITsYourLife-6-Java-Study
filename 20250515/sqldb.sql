use sqldb;

-- [기본]
-- 사용자 별로 구매 이력 출력
select *
from usertbl as a join buytbl as b on a.userID = b.userID
where b.prodName is not null;

-- userID가 'JYP'인 데이터 출력
select *
from usertbl as a join buytbl as b on a.userID = b.userID
where a.userID = 'JYP';

/**
  - 각 사용자별로 구매 이력 출력
  - 연결 컬럼은 useID
  - useID를 기준으로 오름차순 정렬
  - 구매이력이 없는 사용자도 출력
  - useID, name, prodName, addr, 연락처 출력
 */
 select a.userID, a.name, b.prodName, a.addr, concat(a.mobile1,a.mobile2) as 연락처
 from usertbl as a join buytbl as b on a.userID = b.userID
 order by a.userID;

-- [심화]
-- 테이블 및 데이터 생성
CREATE TABLE stdtbl (
    stdName   VARCHAR(10) NOT NULL PRIMARY KEY,
    addr      CHAR(4) NOT NULL
);

CREATE TABLE clubtbl (
     clubName  VARCHAR(10) NOT NULL PRIMARY KEY,
     roomNo    CHAR(4) NOT NULL
);

CREATE TABLE stdclubtbl (
    num       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    stdName   VARCHAR(10) NOT NULL,
    clubName  VARCHAR(10) NOT NULL,
    FOREIGN KEY(stdName) REFERENCES stdtbl(stdName),
    FOREIGN KEY(clubName) REFERENCES clubtbl(clubName)
);

INSERT INTO stdtbl VALUES
           ('김범수', '경남'),
           ('성시경', '서울'),
           ('조용필', '경기'),
           ('은지원', '경북'),
           ('바비킴', '서울');

INSERT INTO clubtbl VALUES
            ('수영', '101호'),
            ('바둑', '102호'),
            ('축구', '103호'),
            ('봉사', '104호');

INSERT INTO stdclubtbl VALUES
           (NULL, '김범수', '바둑'),
           (NULL, '김범수', '축구'),
           (NULL, '조용필', '축구'),
           (NULL, '은지원', '축구'),
           (NULL, '은지원', '봉사'),
           (NULL, '바비킴', '봉사');

-- 학생 테이블, 동아리 테이블, 학생 동아리 테이블을 이용해 학생을 기준으로 학생 이름/지역/가입한 동아리/동아리방 출력
select a.stdName, a.addr, b.clubName, c.roomNo
from stdtbl a
         join stdclubtbl b on a.stdName = b.stdName
         join clubtbl c on b.clubName = c.clubName;

-- 동아리를 기준으로 가입한 학생의 목록 출력
select  a.clubName,c.roomNo,b.stdName, b.addr
from stdclubtbl a
         join stdtbl b on a.stdName = b.stdName
         join clubtbl c on a.clubName = c.clubName
ORDER BY c.clubName, b.stdName;

-- 테이블 및 데이터 추가
CREATE TABLE empTbl(emp CHAR(3), manager CHAR(3), empTel VARCHAR(8));

INSERT INTO empTbl VALUES('나사장', NULL, '0000');
INSERT INTO empTbl VALUES('김재무', '나사장', '2222');
INSERT INTO empTbl VALUES('김부장', '김재무', '2222-1');
INSERT INTO empTbl VALUES('이부장', '김재무', '2222-2');
INSERT INTO empTbl VALUES('우대리', '이부장', '2222-2-1');
INSERT INTO empTbl VALUES('지사원', '이부장', '2222-2-2');
INSERT INTO empTbl VALUES('이영업', '나사장', '1111');
INSERT INTO empTbl VALUES('한과장', '이영업', '1111-1');
INSERT INTO empTbl VALUES('최정보', '나사장', '3333');
INSERT INTO empTbl VALUES('윤차장', '최정보', '3333-1');
INSERT INTO empTbl VALUES('이주임', '윤차장', '3333-1-1');

-- '우대리'의 상관 연락처 정보를 확인
select b.emp, b.manager, a.empTel
from emptbl a join emptbl b on a.emp = b.manager
WHERE b.emp = '우대리';

use employees;
-- 현재 재직 중인 직원의 정보를 출력하세요
use employees;
select a.emp_no, a.first_name, a.last_name, b.title
from employees a join titles b on A.emp_no = b.emp_no
WHERE B.to_date > current_date