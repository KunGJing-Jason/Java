CREATE DATABASE SPJ;
USE SPJ;

CREATE TABLE S (
	SNO CHAR(3) PRIMARY KEY,
	SNAME CHAR(20) NOT NULL,
	STATUS INT,
	CITY CHAR(20)
);

CREATE TABLE P (
	PNO CHAR(3) PRIMARY KEY,
	PNAME CHAR(20) NOT NULL,
	COLOR CHAR(10),
	WEIGHT INT
);

CREATE TABLE J (
	JNO CHAR(3) PRIMARY KEY,
	JNAME CHAR(20) NOT NULL,
	CITY CHAR(20)
);

CREATE TABLE SPJ (
	SNO CHAR(3),
	PNO CHAR(3),
	JNO CHAR(3),
	QTY INT,
	
	PRIMARY KEY(SNO,PNO,JNO),
	FOREIGN KEY (SNO) REFERENCES S(SNO),
	FOREIGN KEY (PNO) REFERENCES P(PNO),
	FOREIGN KEY (JNO) REFERENCES J(JNO)
);

INSERT INTO S VALUES
('S1','精益',20,'天津'),
('S2','盛锡',10,'北京'),
('S3','东方红',30,'北京'),
('S4','丰泰盛',20,'天津'),
('S5','为民',30,'上海');


INSERT INTO P VALUES
('P1','螺母','红',12),
('P2','螺栓','绿',17),
('P3','螺丝刀','蓝',14),
('P4','螺丝刀','红',14),
('P5','凸轮','蓝',40),
('P6','齿轮','红',30);


INSERT INTO J VALUES
('J1','三建','北京'),
('J2','一汽','长春'),
('J3','弹簧厂','天津'),
('J4','造船厂','天津'),
('J5','机车厂','唐山'),
('J6','无线电厂','常州'),
('J7','半导体厂','南京');


INSERT INTO SPJ VALUES
('S1','P1','J1',200),
('S1','P1','J3',100),
('S1','P1','J4',700),
('S1','P2','J2',100),
('S2','P3','J1',400),
('S2','P3','J2',200),
('S2','P3','J4',500),
('S2','P3','J5',400),
('S2','P5','J1',400),
('S2','P5','J2',100),
('S3','P1','J1',200),
('S3','P3','J1',200),
('S4','P5','J1',100),
('S4','P6','J3',300),
('S4','P6','J4',200),
('S5','P2','J4',100),
('S5','P3','J1',200),
('S5','P6','J2',200),
('S5','P6','J4',500);


/*1、所有供应商的姓名和所在城市*/
SELECT SNAME,CITY
FROM S;

/*2、找出所有零件的名称、颜色、重量*/
SELECT PNAME,COLOR,WEIGHT
FROM P;


/*3、找出所有使用供应商S1所供应零件的工程号码*/
SELECT JNO
FROM SPJ
WHERE SNO = 'S1'; 

/*4、找出所有工程项目J2使用的各种零件的名称及数量*/
SELECT PNAME, QTY
FROM P,SPJ
WHERE SPJ.JNO = 'J2' AND P.PNO = SPJ.PNO; 

/*5、找出上海厂商供应的所有零件号码*/
SELECT PNO
FROM S,SPJ
WHERE S.CITY = '上海' AND S.SNO = SPJ.SNO;

/*6、找出使用上海产的零件的工程名称*/
SELECT DISTINCT JNAME
FROM S,J,SPJ
WHERE S.CITY = '上海' AND S.SNO = SPJ.SNO AND J.JNO = SPJ.JNO;

/*7、找出没有使用天津产的零件的工程号码*/
SELECT SPJ.JNO
FROM J,SPJ
WHERE J.JNO = SPJ.JNO AND J.CITY != '天津';


/*1、求供应工程J1零件的供应商号码SNO*/
SELECT DISTINCT SNO
FROM SPJ
WHERE JNO = 'J1';
/*2、求供应工程J1两件P的供应商号码SNO*/
SELECT DISTINCT SNO
FROM SPJ
WHERE JNO = 'J1' AND PNO = 'P1';
/*3、求共供应工程J1零件为红色的供应商号码SNO*/
SELECT SNO
FROM SPJ
WHERE JNO = 'J1' AND SPJ.PNO IN (SELECT PNO FROM P WHERE COLOR = '红');
/*4、没有使用天津供应商生产的红色零件的工程号JNO*/
SELECT JNO
FROM SPJ
WHERE SPJ.SNO IN (SELECT S.SNO FROM S WHERE S.CITY != '天津')  AND SPJ.PNO IN (SELECT PNO FROM P WHERE COLOR = '红');
/*5、至少用了供应商S1所供应的全部零件的工程号*/
SELECT DISTINCT JNO
FROM SPJ SPJ1
WHERE NOT EXISTS
			(SELECT *
			FROM SPJ SPJ2
			WHERE SPJ2.SNO='S1' AND NOT EXISTS
				(SELECT *
				FROM SPJ SPJ3
				WHERE SPJ3.JNO=SPJ1.JNO AND SPJ3.PNO=SPJ2.PNO));
/**/
/**/