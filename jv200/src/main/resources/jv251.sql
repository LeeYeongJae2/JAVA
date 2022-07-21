CREATE TABLE Customer ( -- 테이블생성
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	name		VARCHAR(10)		NOT NULL,
	ssn 		VARCHAR(14)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1001;

SELECT * FROM Customer;
INSERT INTO Customer (name,ssn) VALUES ('James Bond',900101-1234567); -- 테이블안에 값을넣음
UPDATE Customer SET name='Jason Bourne' WHERE cid=1002; -- 테이블안에 name 이름을 바꿈
DELETE FROM Customer WHERE cid=1002; -- cid=1002인 열을 삭제한다


CREATE TABLE Account ( -- 테이블생성
	aid				BIGINT		PRIMARY KEY AUTO_INCREMENT,
	accType			CHAR(1)		NOT NULL,
	balance			DOUBLE		NOT NULL,
	interestRate	DOUBLE		NOT NULL,
	customerld		BIGINT		NOT NULL,
	regDate			TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 3001;

SELECT * FROM Account;
SELECT accType,balance FROM Account; -- 계좌타입과 잔고를 확인하는 쿼리
INSERT INTO Account (accType,balance,interestRate,customerld) VALUES ('A',2000.0,0.03,0.0,1001); -- 값을넣음
SELECT * FROM Account a INNER JOIN Customer c on a.customerId = c.cid WHERE c.ssn = '840104-1234567';

SELECT DATABASE();
use jv250; --  데이터베이스를 jv250으로 설정한다
SHOW TABLES; -- 여기에 포함된 테이블목록 확인
desc Customer -- 테이블 구조를 확인한다

CREATE INDEX CustomerIndex ON Customer(ssn); -- 인덱스를 생성한다

