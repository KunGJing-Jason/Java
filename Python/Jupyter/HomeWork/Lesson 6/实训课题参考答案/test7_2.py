# -*- coding: utf-8 -*-
"""
Created on Thu Nov 14 08:33:38 2019

@author: lenovo
"""
import numpy as np 
import pandas as pd
Z=np.load('Z.npy')
Data=pd.DataFrame(Z[:,1:])
R=Data.corr()

X=Data.fillna(0)
xx=X
X=X.as_matrix()
from sklearn.preprocessing import StandardScaler
scaler = StandardScaler()
scaler.fit(X) 
X=scaler.transform(X)  

from sklearn.decomposition import PCA
pca=PCA(n_components=0.9) 
pca.fit(X)
Y=pca.transform(X)
tzxl=pca.components_              
tz=pca.explained_variance_          
gxl=pca.explained_variance_ratio_  

#线性回归
A=pd.read_excel('附件一：已结束项目任务数据.xls') 
A4=A.iloc[:,4].values

y=A.iloc[:,3].values
y=y.reshape(len(y),1)
y0=y[A4==0]
y=y[A4==1]
x=Y
x1=x[A4==0,:]
x=x[A4==1,:]

'''
from sklearn.linear_model import LinearRegression as LR
lr = LR()    #创建线性回归模型类
lr.fit(x, y) #拟合
Slr=lr.score(x,y)   # 判定系数 R^2
c_x=lr.coef_        # x对应的回归系数
c_b=lr.intercept_   # 回归系数常数项
'''
from sklearn.neural_network import MLPRegressor 
clf = MLPRegressor(solver='lbfgs', alpha=1e-5,hidden_layer_sizes=35, random_state=1) 
clf.fit(x, y);   
rv=clf.score(x,y)
y1=clf.predict(x1)

A3=A.iloc[:,[3]]
xx=pd.concat((xx,A3),axis=1)
xx=xx.as_matrix()
yy=A4.reshape(len(A4),1)

from sklearn import svm
clf = svm.SVC(kernel='rbf')  
clf.fit(xx, yy) 
rv=clf.score(xx, yy);

xx1=np.hstack((Z[A4==0,1:],y1.reshape(len(y1),1)))
R=clf.predict(xx1)

R1=len(R[R==1])      #任务完成增加量
R2=sum(y1)-sum(y0)   #成本增加额
