USE SPJ;

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
