#事务是MySQL运行的最小单位，是一组dml语句的的集合

CREATE TABLE t01(
	id INT,
	`name` VARCHAR(10)
)

START TRANSACTION;-- 开启一个事务

INSERT INTO t01 VALUES(100,'ys');

SAVEPOINT a;-- 设置保存点a

INSERT INTO t01 VALUES(200,'lh');

ROLLBACK TO a; -- 返回保存点a

ROLLBACK;-- 返回开始事务时，重新开始

COMMIT;-- 提交事务

SELECT * FROM t01; 