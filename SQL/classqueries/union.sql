select * 
from emp right outer join dept
	on emp.deptno = dept.deptno
where ename is null 


SELECT DISTINCT(E1.SAL)
FROM EMP E1
WHERE ( 
	SELECT COUNT(DISTINCT(E2.SAL))
	FROM EMP E2
	WHERE E1.SAL < E2.SAL
) = 4
UNION
SELECT DISTINCT(E1.SAL)
FROM EMP E1
WHERE ( 
	SELECT COUNT(DISTINCT(E2.SAL))
	FROM EMP E2
	WHERE E1.SAL > E2.SAL
) = 5