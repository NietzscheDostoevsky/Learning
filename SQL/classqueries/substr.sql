select ('$' || substr(ename, 2, (length(ename) - 1) ) || '$') from emp;


select substr(ename, 1, (length(ename)/2)-1 ) || '$' || '$' || substr(ename, (((length(ename)/2)) + 2))
from emp 
where (mod(length(ename),2) = 0) 
UNION
select substr(ename, 1, ((length(ename) -1)/2)) || '$' || substr(ename, ((((length(ename)+1)/2)+1)))
from emp 
where (mod(length(ename),2) = 1)



