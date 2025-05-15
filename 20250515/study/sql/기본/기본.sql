use sqldb;

--사용자 별로 구매 이력을 출력함
--구매 이력이 없는 정보는 출력하지 않음
--모든컬럼을 출력함
select u.*, group_concat(b.prodName SEPARATOR ',') AS `상품목록`
from usertbl u
inner join
buytbl b on u.userID = b.userID
group by
u.userID
order by
u.userID;

--앞의 결과에서 userID가 'JYP'인 데이터만 출력하세요
select u.*, group_concat(b.prodName SEPARATOR ',') AS `상품목록`
from usertbl u
inner join
buytbl b on u.userID = b.userID
where u.userID = 'JYP'
group by
u.userID
order by
u.userID;

--각 사용자 별로 구매 이력을 출력하세요.
--연결 컬럼은 userID로 함
--결과를 userID를 기준으로 오름차순으로 정렬함
--구매 이력이 없는 사용자도 출력하세요.
--userID, name, prodName, addr, 연락처를 다음과 같이 출력함
select u.userID, u.name, b.prodName, u.addr, CONCAT(u.mobile1, u.mobile2) AS 연락처
from usertbl u
left join
buytbl b on u.userID = b.userID
order by u.userID;

--sqldb의 사용자를 모두 조회하되 전화가 없는 사람은 제외하고 출력하세요.
select *
from usertbl
where mobile1 IS NOT NULL AND mobile1 != ''
   OR mobile2 IS NOT NULL AND mobile2 != '';

--sqldb의 사용자를 모두 조회하되 전화가 없는 사람만 출력하세요.
select *
from usertbl
where (mobile1 IS NULL OR mobile1 = '')
   AND (mobile2 IS NULL OR mobile2 = '');
