DROP TABLE Sample10; 

CREATE TABLE Sample10 (
	no 			INT(11)			DEFAULT NULL,
	name 		VARCHAR(20) 	DEFAULT NULL,
	birthday 	DATE 			DEFAULT NULL,
	address 	VARCHAR(40) 	DEFAULT NULL
);

SELECT * FROM Sample10; 

INSERT INTO Sample10 VALUES (1,"유비","1996-01-25","대구 중구 반월당");
INSERT INTO Sample10 VALUES (2,"관우","1997-05-14","대구 남구 ");
INSERT INTO Sample10 VALUES (3,"장비","1999-09-02","대구 북구 ");


CREATE TABLE Customer (
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT, -- 넘버 키이다
	name 		VARCHAR(20)		NOT NULL, 
	ssn			VARCHAR(14)		NOT NULL,
	phone 		VARCHAR(14)		NOT NULL,
	customerId 	VARCHAR(16)		NOT NULL,
	passwd 		VARCHAR(16)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001;


ALTER TABLE Customer CHANGE customerId userId VARCHAR(16) NOT NULL; -- customerId를 userId로 변경한다

SELECT * FROM Customer;
INSERT INTO Customer (name,ssn,phone,customerId,passwd) VALUES ('유비','901213-1234567','010-2323-2323','java','1111');
INSERT INTO Customer (name,ssn,phone,customerId,passwd) VALUES ('관우','945693-1234567','010-8657-1111','var123','2222');
INSERT INTO Customer (name,ssn,phone,customerId,passwd) VALUES ('장비','970110-1234567','010-1257-2222','hmoe1','3333');
UPDATE Customer SET ssn='920524-1234567' WHERE cid=1001;   -- 안에 내용을 고치고 싶을때 WHERE 로 대상을 지정해줘야한다 안그러면 전체 ssn이 바뀐다 바로 해고된다 ㄷㄷ
DELETE FROM Customer WHERE cid=1002; -- 삭제하고 싶은 것을 삭제한다 마찬가지로 지정해주지 않으면 전부 삭제되서 해고당한다


--NOT NULL 은 무조건 값을 할당해줘야하고
--DEFAULT NULL 은 선택사항이다


DROP TABLE Customer;
DROP TABLE Account;


CREATE TABLE Account(
	aid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	accountNum		VARCHAR(11)		NOT NULL,
	balance 		DOUBLE 			NOT NULL	DEFAULT 0.0,
	interestRate 	DOUBLE			NOT NULL	DEFAULT 0.0, -- 이자율
	overdraft 		DOUBLE 			NOT NULL 	DEFAULT 0.0, -- 마이너스 대출한도
	accountType		CHAR(1)			NOT NULL 	DEFAULT "S",
	customerId 		BIGINT			NOT NULL,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP, -- 데이터를 넣은 날짜를 자동으로 넣어준다
	CONSTRAINT Account_customerId_FK FOREIGN KEY (customerId) REFERENCES Customer(cid) -- 제약을건다 위에 사람 1명당 여러 계좌를 만들수있으니 
	-- FOREIGN KEY (customerId)는 Customer(cid)에서 받아와서 
)AUTO_INCREMENT = 3001;

INSERT INTO Account (accountNum,balance,interestRate,overdraft,accountType,customerId) VALUES ('111-111-111','123','1','1000','A','1001');
INSERT INTO Account (accountNum,balance,interestRate,overdraft,accountType,customerId) VALUES ('222-222-222','456','2','2000','B','1002');
INSERT INTO Account (accountNum,balance,interestRate,overdraft,accountType,customerId) VALUES ('333-333-333','789','3','3000','C','1003');

SELECT * FROM Account;
SELECT * FROM Customer;

-- inner join
SELECT * FROM Account, Customer WHERE Account.customerId = Customer.cid AND Customer.ssn='901213-1234567'; -- 이너조인 두개의 테이블을 합친다

SELECT * FROM Account a INNER JOIN Customer c on a.customerId = c.cid;

SELECT * FROM Account a INNER JOIN Customer c on a.customerId = c.cid WHERE c.ssn = '901213-1234567';



CREATE TABLE User (
   userId      VARCHAR(16)      NOT NULL,
   passwd      VARCHAR(16)      NOT NULL,
   userName   VARCHAR(20)      NOT NULL,
   ssn         VARCHAR(14)      NOT NULL,
   email      VARCHAR(40)      NOT NULL,
   addr      VARCHAR(30)      NOT NULL,
   regDate      TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001;



SELECT * FROM User;


CREATE TABLE Manager (
   mid			BIGINT				PRIMARY KEY AUTO_INCREMENT,
   name      	VARCHAR(16)      	NOT NULL,
   userId      	VARCHAR(16)      	NOT NULL,
   passwd   	VARCHAR(20)      	NOT NULL,
   area      	VARCHAR(30)      	NOT NULL
) AUTO_INCREMENT = 1;

SELECT * FROM Manager;
