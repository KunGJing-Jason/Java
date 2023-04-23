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
('S1','����',20,'���'),
('S2','ʢ��',10,'����'),
('S3','������',30,'����'),
('S4','��̩ʢ',20,'���'),
('S5','Ϊ��',30,'�Ϻ�');


INSERT INTO P VALUES
('P1','��ĸ','��',12),
('P2','��˨','��',17),
('P3','��˿��','��',14),
('P4','��˿��','��',14),
('P5','͹��','��',40),
('P6','����','��',30);


INSERT INTO J VALUES
('J1','����','����'),
('J2','һ��','����'),
('J3','���ɳ�','���'),
('J4','�촬��','���'),
('J5','������','��ɽ'),
('J6','���ߵ糧','����'),
('J7','�뵼�峧','�Ͼ�');


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


/*1�����й�Ӧ�̵����������ڳ���*/
SELECT SNAME,CITY
FROM S;

/*2���ҳ�������������ơ���ɫ������*/
SELECT PNAME,COLOR,WEIGHT
FROM P;


/*3���ҳ�����ʹ�ù�Ӧ��S1����Ӧ����Ĺ��̺���*/
SELECT JNO
FROM SPJ
WHERE SNO = 'S1'; 

/*4���ҳ����й�����ĿJ2ʹ�õĸ�����������Ƽ�����*/
SELECT PNAME, QTY
FROM P,SPJ
WHERE SPJ.JNO = 'J2' AND P.PNO = SPJ.PNO; 

/*5���ҳ��Ϻ����̹�Ӧ�������������*/
SELECT PNO
FROM S,SPJ
WHERE S.CITY = '�Ϻ�' AND S.SNO = SPJ.SNO;

/*6���ҳ�ʹ���Ϻ���������Ĺ�������*/
SELECT DISTINCT JNAME
FROM S,J,SPJ
WHERE S.CITY = '�Ϻ�' AND S.SNO = SPJ.SNO AND J.JNO = SPJ.JNO;

/*7���ҳ�û��ʹ������������Ĺ��̺���*/
SELECT SPJ.JNO
FROM J,SPJ
WHERE J.JNO = SPJ.JNO AND J.CITY != '���';


/*1����Ӧ����J1����Ĺ�Ӧ�̺���SNO*/
SELECT DISTINCT SNO
FROM SPJ
WHERE JNO = 'J1';
/*2����Ӧ����J1����P�Ĺ�Ӧ�̺���SNO*/
SELECT DISTINCT SNO
FROM SPJ
WHERE JNO = 'J1' AND PNO = 'P1';
/*3���󹲹�Ӧ����J1���Ϊ��ɫ�Ĺ�Ӧ�̺���SNO*/
SELECT SNO
FROM SPJ
WHERE JNO = 'J1' AND SPJ.PNO IN (SELECT PNO FROM P WHERE COLOR = '��');
/*4��û��ʹ�����Ӧ�������ĺ�ɫ����Ĺ��̺�JNO*/
SELECT JNO
FROM SPJ
WHERE SPJ.SNO IN (SELECT S.SNO FROM S WHERE S.CITY != '���')  AND SPJ.PNO IN (SELECT PNO FROM P WHERE COLOR = '��');
/*5���������˹�Ӧ��S1����Ӧ��ȫ������Ĺ��̺�*/
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