USE SPJ;

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
