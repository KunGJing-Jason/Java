USE SPJ;

/*7、找出没有使用天津产的工程号码*/

SELECT SPJ.SNO,JNO
From SPJ,S
WHERE S.CITY != '天津' AND S.SNO = SPJ.SNO;

/*8、把红色零件的颜色改成蓝色*/
UPDATE P
SET COLOR = '蓝' 
WHERE COLOR = '红';

/*9、由S5供给J4的零件P6改为由S3供应*/
UPDATE SPJ
SET SNO = 'S3'
WHERE PNO = 'P6' AND JNO = 'J4' AND SNO = 'S5';

/*10、从供应商关系中删除S2的记录，并从供应关系中删除相应的记录*/
DELETE SPJ
FROM S, SPJ
WHERE S.SNO = 'S2' AND SPJ.SNO = 'S2';

/*11、请将（S2,J6,P4,200）插入供应关系*/
INSERT INTO SPJ VALUES
('S2','J6','P4',200);
