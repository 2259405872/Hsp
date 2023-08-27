SELECT * FROM account;

CREATE TABLE Account (
	id INT,
	`name` VARCHAR(20),
	money INT
);

INSERT INTO Account 
VALUES
(100,'罗阳',3000),
(101,'向进',4000),
(100,'魏玉鑫',5000);

UPDATE Account 
SET id=102
WHERE money=5000;