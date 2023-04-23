# -*- coding: utf-8 -*-
import pandas as pd     #导入pandas库
import numpy as np      #导入nmypy库
import math             #导入数学函数模
import fun

A=pd.read_excel('附件一：已结束项目任务数据.xls') 
B=pd.read_excel('附件二：会员信息数据2.xlsx')
Z=np.zeros((len(A),13))
for t in range(len(A)):
   A_W0=A.iloc[t,1]  #第0个任务的维度
   A_J0=A.iloc[t,2]  #第0个任务的经度
   Z1=np.zeros(len(A))
   Z2=np.zeros(len(B))
   for i in range(len(A)):
      A_Wi=A.iloc[i,1]  #第i个任务的维度
      A_Ji=A.iloc[i,2]  #第i个任务的经度
      d1=111.19*math.sqrt((A_W0-A_Wi)**2+(A_J0-A_Ji)**2*math.cos((A_W0+A_Wi)*math.pi/180)**2);  
      Z1[i]=d1
   for k in range(len(B)):
      B_Wk=B.iloc[k,1]   #第0个会员的维度
      B_Jk=B.iloc[k,2]   #第0个会员的经度
      d2=111.19*math.sqrt((A_W0-B_Wk)**2+(A_J0-B_Jk)**2*math.cos((A_W0+B_Wk)*math.pi/180)**2);
      Z2[k]=d2

   Z[t,0]=t
   Z[t,1]=len(Z1[Z1<=5])
   Z[t,2]=A.iloc[Z1<=5,3].mean()
   Z[t,3]=B.iloc[Z2<=5,3].sum()
   Z[t,4]=B.iloc[Z2<=5,5].mean()
   Z[t,5]=len(Z2[Z2<=5])
   Z[t,6]=B.iloc[fun.find_I(6,30,6,30,Z2,B),3].sum()
   Z[t,7]=B.iloc[fun.find_I(6,33,6,45,Z2,B),3].sum()
   Z[t,8]=B.iloc[fun.find_I(6,48,7,3,Z2,B),3].sum()
   Z[t,9]=B.iloc[fun.find_I(7,6,7,21,Z2,B),3].sum()
   Z[t,10]=B.iloc[fun.find_I(7,24,7,39,Z2,B),3].sum()
   Z[t,11]=B.iloc[fun.find_I(7,42,7,57,Z2,B),3].sum()
   Z[t,12]=B.iloc[fun.find_I(8,0,8,0,Z2,B),3].sum()
np.save('Z',Z)
print(Z)