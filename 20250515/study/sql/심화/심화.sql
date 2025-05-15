use sqldb;
--학생 테이블,동아리 테이블,학생 동아리 테이블을 이용해서 학생을 기준으로 학생 이름/지역/가입한 동아리/동아리 방을 출력하세요.
SELECT
    s.stdName AS 학생이름,
    s.addr AS 지역,
    sc.clubName AS 가입한동아리,
    c.roomNo AS 동아리방
FROM
    stdtbl s
JOIN
    stdclubtbl sc ON s.stdName = sc.stdName
JOIN
    clubtbl c ON sc.clubName = c.clubName;

--동아리를 기준으로 가입한 학생의 목록을 출력하세요.
--출력정보: clubName, roomNo, stdName, addr
SELECT
    c.clubName,
    c.roomNo,
    s.stdName,
    s.addr
FROM
    clubtbl c
JOIN
    stdclubtbl sc ON c.clubName = sc.clubName
JOIN
    stdtbl s ON sc.stdName = s.stdName;

--앞에서 추가한 테이블에서 '우대리'의상관연락처정보를 확인하세요.
--출력할 정보: 부하직원,직속상관,직속상관연락처
SELECT
    emp AS 부하직원,
    manager AS 직속상관,
    empTel AS 직속상관연락처
FROM
    emptbl e
WHERE
    emp = '우대리';

--현재 재직중인 직원의 정보를 출력하세요
--출력 항목:emp_no,first_name,last_name,title
SELECT
    e.emp_no,
    e.first_name,
    e.last_name,
    t.title
FROM
    employees e
JOIN
    titles t ON e.emp_no = t.emp_no
WHERE
    t.to_date IS NULL;

--현재 재직 중인 직원 정보를 출력하세요
--출력 항목: 직원의 기본 정보 모두, title, salary
SELECT
    e.emp_no,
    e.birth_date,
    e.first_name,
    e.last_name,
    e.gender,
    e.hire_date,
    t.title,
    s.salary
FROM
    employees e
JOIN
    titles t ON e.emp_no = t.emp_no
JOIN
    salaries s ON e.emp_no = s.emp_no
WHERE
    t.to_date IS NULL
    AND s.to_date IS NULL;


--현재 재직중인 직원의 정보를 출력하세요.
--출력항목: emp_no,first_name,last_name,department
--정렬:emp_no오름차순
SELECT
    e.emp_no,
    e.first_name,
    e.last_name,
    d.dept_name AS department
FROM
    employees e
JOIN
    dept_emp de ON e.emp_no = de.emp_no
JOIN
    departments d ON de.dept_no = d.dept_no
WHERE
    de.to_date IS NULL
ORDER BY
    e.emp_no ASC;

--부서별 재직중인 직원의 수를 출력하세요.
--출력항목:부서번호,부서명,인원수
--정렬:부서 번호 오름차순
SELECT
    d.dept_no AS 부서번호,
    d.dept_name AS 부서명,
    COUNT(de.emp_no) AS 인원수
FROM
    dept_emp de
JOIN
    departments d ON de.dept_no = d.dept_no
WHERE
    de.to_date IS NULL
GROUP BY
    d.dept_no, d.dept_name
ORDER BY
    d.dept_no ASC;

--직원 번호가 10209인직원의 부서 이동히스토리를 출력하세요.
--출력항목:emp_no,first_name,last_name,dept_name,from_date,to_date
SELECT
    e.emp_no,
    e.first_name,
    e.last_name,
    d.dept_name,
    de.from_date,
    de.to_date
FROM
    dept_emp de
JOIN
    employees e ON de.emp_no = e.emp_no
JOIN
    departments d ON de.dept_no = d.dept_no
WHERE
    e.emp_no = 10209
ORDER BY
    de.from_date ASC;
