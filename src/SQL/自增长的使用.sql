# 自增长
-- 实现了，每增加一行字段自动按顺序填充，但字段必须有唯一约束或者是主键,且一般只能修饰整形字段

-- 案例
CREATE TABLE atuo_increment_(
	id INT PRIMARY KEY AUTO_INCREMENT,-- 设置了自增长约束
	email VARCHAR(32) NOT NULL DEFAULT '',
	`name` VARCHAR(32) NOT NULL DEFAULT ''
);

ALTER TABLE atuo_increment_ AUTO_INCREMENT=100;-- 设置自增长起始值(也可以不设置)

INSERT INTO atuo_increment_ VALUES(NULL,'ys','2259405872@qq.com');-- 可以传入Null

INSERT INTO atuo_increment_(`name`,email) VALUES('lh','2345678910@qq.com');-- 也可以不传入值

INSERT INTO atuo_increment_ VALUES(200,'ly','237895428910@qq.com');
INSERT INTO atuo_increment_(`name`,email) VALUES('xj','2345610@qq.com');-- 传入了一个值会以这个值为新起点

SELECT * FROM `atuo_increment_`; 