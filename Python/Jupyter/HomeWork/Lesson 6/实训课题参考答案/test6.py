# -*- coding: utf-8 -*-
import pandas as pd
import numpy as np
A=pd.read_excel('hepatitis.xlsx')
#1.缺失值"？"转换为nan
for i in range(len(A)):
    for j in range(len(A.iloc[0,:])):
        if A.iloc[i,j]=='?':
           A.iloc[i,j]=np.nan
           

#2.B1均值策略填充及数据标准化
B1=A.iloc[:,0:6]
from sklearn.preprocessing import Imputer 
imp = Imputer(missing_values='NaN', strategy='mean', axis=0)
imp.fit(B1)
B1=imp.transform(B1)
from sklearn.preprocessing import MinMaxScaler   
min_max_scaler = MinMaxScaler()
min_max_scaler.fit(B1)
B1=min_max_scaler.transform(B1)

#3.B2最频繁值填充
B2=A.iloc[:,6:-1]
imp = Imputer(missing_values='NaN', strategy='most_frequent', axis=0)
imp.fit(B2)
B2=imp.transform(B2)

#4.合并B1和B2,并做主成分分析，提取主成分
B=np.hstack((B1,B2))
from sklearn.decomposition import PCA
pca=PCA(n_components=0.95) 
pca.fit(B)
X=pca.transform(B)

# 5.决策树预测

x=X[:130,:]
x1=X[130:,:]
Y=A.iloc[:,19].values
y=Y[:130]
y1=Y[130:]
'''
from sklearn import tree
clf = tree.DecisionTreeClassifier()
from sklearn.linear_model import LogisticRegression as LR
clf = LR()   #创建逻辑回归模型类
'''
from sklearn import svm
clf = svm.SVC()  
clf = clf.fit(x,y)
y0=clf.predict(x1)
ty=y1-y0
r=len(ty[ty==0])/len(ty)
