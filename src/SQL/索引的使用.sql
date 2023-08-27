#索引
-- 不使用索引时，遍历字段哪怕已经找完了满足条件的值，它仍然会遍历完字段
-- 使用索引，能将字段中的所有值构建一个二叉树，存入内存中，极大的提高了查询效率

-- 01索引分为：
-- 主键索引(primary key)，主键本身就是一种索引
-- 唯一索引(unique index)，要求字段必须唯一
-- 普通索引(index)，允许出现重复的值
-- 全文索引(fulltext)，适用于MyISAM引擎

-- 02创建索引，三种方式

-- 创建表时创建
CREATE TABLE index_test(
	id INT PRIMARY KEY,
	`name` VARCHAR(10),
	skill VARCHAR(10),
	email VARCHAR(32),
	phone VARCHAR(32),
	INDEX index_name(`name`)-- 这里添加了普通索引
)

-- create关键字创建索引
CREATE UNIQUE INDEX index_skill
ON index_test(skill);-- 创建了唯一索引

-- alter add 创建索引
ALTER TABLE index_test
ADD INDEX index_email(email);

-- 03删除索引

-- 使用 drop index 删除索引
DROP INDEX index_email ON index_test;

-- 使用alter drop删除索引
ALTER TABLE index_test 
DROP INDEX index_email;

-- 删除主键也可以算作删除索引
ALTER TABLE index_test 
DROP PRIMARY KEY;

-- 06更改索引只需要，先删除索引再添加索引即可

-- 05查询索引

-- 1
SHOW INDEX FROM index_test;

-- 2
SHOW INDEXES FROM index_test;

-- 3
SHOW KEYS FROM index_test;

-- 4
DESC index_test;