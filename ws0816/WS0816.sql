use employee;

CREATE TABLE EMP
(EMPNO int(4) PRIMARY KEY,
ENAME VARCHAR(10),
JOB VARCHAR(9),
MGR int(4),
HIREDATE DATE,
SAL decimal(7,2),
COMM decimal(7,2),
DEPTNO int(2));
INSERT INTO EMP VALUES (7369,'SMITH','CLERK',7902,cast('2010-10-19' as date),800,NULL,20);
INSERT INTO EMP VALUES (7499,'ALLEN','SALESMAN',7698,cast('2000-10-19' as date),1600,300,30);
INSERT INTO EMP VALUES (7521,'WARD','SALESMAN',7698,cast('20emp13-05-19' as date),1250,500,30);
INSERT INTO EMP VALUES (7566,'JONES','MANAGER',7839,cast('2018-10-19' as date),2975,NULL,20);
INSERT INTO EMP VALUES (7654,'MARTIN','SALESMAN',7698,cast('2008-04-19' as date),1250,1400,30);
INSERT INTO EMP VALUES (7698,'BLAKE','MANAGER',7839,cast('2016-11-19' as date),2850,NULL,30);
INSERT INTO EMP VALUES (7782,'CLARK','MANAGER',7839,cast('2017-10-19' as date),2450,NULL,10);
INSERT INTO EMP VALUES (7788,'SCOTT','ANALYST',7566,cast('2013-10-11' as date),3000,NULL,20);
INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,cast('2014-08-19' as date),5000,NULL,10);
INSERT INTO EMP VALUES (7844,'TURNER','SALESMAN',7698,cast('2010-10-19' as date),1500,0,30);
INSERT INTO EMP VALUES (7876,'ADAMS','CLERK',7788,cast('2000-09-19' as date),1100,NULL,20);
INSERT INTO EMP VALUES (7900,'JAMES','CLERK',7698,cast('2018-10-19' as date),950,NULL,30);
INSERT INTO EMP VALUES (7902,'FORD','ANALYST',7566,cast('2003-10-19' as date),3000,NULL,20);
INSERT INTO EMP VALUES (7934,'MILLER','CLERK',7782,cast('2002-10-19' as date),1300,NULL,10);

-- 1
desc emp;
-- 2
select ename, empno, hiredate, sal from emp where ename like 'A%';
-- 3
select * from emp where hiredate like '2000%'; 
-- 4
select  *from emp where comm is null; 
-- 5
select ename, deptno , sal from emp where deptno ='30' and sal >=1500;
-- 6
select * from emp where deptno ='30' order by sal ASC;
-- 7
select * from emp order by sal DESC;
-- 8
select * from emp order by deptno DESC, ENAME, sal DESC;
-- 9
select * from emp order by deptno DESC, ename,sal DESC ; 
-- 10
 select ename, sal, sal*comm/100 comm, sal+sal*comm/100 total
from emp where comm is not null order by total desc;
-- 11 
 select ename, sal, sal*.13 bonus from emp where deptno=10;
-- 12 
 select ename, sal, round(sal/12/5) from emp where deptno=20;
-- 13 
select ename, sal, round(sal*.15,2) '회비' from emp where sal<=3000 and sal>=1500;
-- 14
select ename, sal*.9 '실 수령액' from emp order by sal desc;
-- 15 
 select lower(substr(ename,1,3)) from emp where length(ename)>=6;
-- 16
 select avg(sal), max(sal), min(sal), count(sal) from emp where deptno=10;
-- 17
select deptno, job, count(empno) from emp group by deptno, job order by deptno, job;
-- 18
select job, count(job) from emp group by job having count( job)>=4; 
-- 19
 select ename, hiredate, datediff(curdate(),hiredate) '근무 일수' from emp;
-- 20 
select ename, year(curdate())-year(hiredate) from emp;
-- 21 
select ename, empno, hiredate, sal, job  from EMP where job like 'analyst' ;
-- 22 
select distinct deptno from emp;
-- 23 
select deptno, avg(sal) from emp group by deptno; 
-- 24
select deptno, sum(sal) from emp group by deptno having sum(sal)>=1000;
-- 25
select count(*) from emp;