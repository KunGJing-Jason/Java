USE SPJ;

/*7���ҳ�û��ʹ�������Ĺ��̺���*/

SELECT SPJ.SNO,JNO
From SPJ,S
WHERE S.CITY != '���' AND S.SNO = SPJ.SNO;

/*8���Ѻ�ɫ�������ɫ�ĳ���ɫ*/
UPDATE P
SET COLOR = '��' 
WHERE COLOR = '��';

/*9����S5����J4�����P6��Ϊ��S3��Ӧ*/
UPDATE SPJ
SET SNO = 'S3'
WHERE PNO = 'P6' AND JNO = 'J4' AND SNO = 'S5';

/*10���ӹ�Ӧ�̹�ϵ��ɾ��S2�ļ�¼�����ӹ�Ӧ��ϵ��ɾ����Ӧ�ļ�¼*/
DELETE SPJ
FROM S, SPJ
WHERE S.SNO = 'S2' AND SPJ.SNO = 'S2';

/*11���뽫��S2,J6,P4,200�����빩Ӧ��ϵ*/
INSERT INTO SPJ VALUES
('S2','J6','P4',200);
