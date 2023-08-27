#01分页查询


SELECT * 
FROM employees
LIMIT 0,3;-- 开始行号,查询行数
-- 第一页

SELECT * 
FROM employees
LIMIT 3,3;
-- 第二页


SELECT * 
FROM employees
LIMIT 6,3;
-- 第三页


#02All和Any的使用
-- 理解：ALL就是比全部满足比较条件才行，Any就是要集合中有一个满足比较条件就行了

SELECT first_name,salary 
FROM employees
WHERE salary > ALL(
	SELECT salary
	FROM employees
	WHERE job_id='IT_PROG'

);-- 工资比所有IT_PROG工作者高的人


SELECT first_name,salary 
FROM employees
WHERE salary > ANY(
	SELECT salary
	FROM employees
	WHERE job_id='IT_PROG'

);-- 工资能比任意一个IT_PROG工作者高的人

#03多列比较
-- 语法(字段1，字段2...)=(值1，值2...)，第二个括号里可以是子查询但是必须子查询，只能有一行

SELECT *
FROM employees
WHERE (job_id,salary)=('IT_PROG',9000);


#04 union合并查询
-- 将两个查询的查询结果合起来(两个查询的查询字段必须相)

-- union all 不去重
SELECT first_name,last_name,salary,department_id
FROM employees
WHERE salary>5000
UNION ALL
SELECT first_name,last_name,salary,department_id
FROM employees
WHERE department_id=148

-- union 去重

SELECT first_name,last_name,salary,department_id
FROM employees
WHERE salary>5000
UNION
SELECT first_name,last_name,salary,department_id
FROM employees
WHERE department_id=148



