# -*- coding: utf-8 -*-
tiem=['西红柿','排骨','鸡蛋','茄子','袜子','酸奶','土豆','鞋子']
import pandas as pd
import numpy as np
data = pd.read_excel('tr.xlsx',header = None)
data=data.iloc[:,1:]
D=dict()
for t in range(len(tiem)):
    z=np.zeros((len(data)))
    li=list()
    for k in range(len(data.iloc[0,:])):
        s=data.iloc[:,k]==tiem[t]
        li.extend(list(s[s.values==True].index))
    z[li]=1
    D.setdefault(tiem[t],z)
Data=pd.DataFrame(D)  #布尔值数据表


#获取字段名称，并转化为列表
c=list(Data.columns) 
c0=0.5 #最小置信度
s0=0.2 #最小支持度
list1=[] #预定义定义列表list1，用于存放规则
list2=[] #预定义定义列表list2，用于存放规则的支持度
list3=[] #预定义定义列表list3，用于存放规则的置信度
for k in range(len(c)):
    for q in range(len(c)):
        #对第c[k]个项与第c[q]个项挖掘关联规则
        #规则的前件为c[k]
        #规则的后件为c[q]
        #要求前件和后件不相等
        if c[k]!=c[q]:
           c1=Data[c[k]]
           c2=Data[c[q]]
           I1=c1.values==1
           I2=c2.values==1
           t12=np.zeros((len(c1)))
           t1=np.zeros((len(c1)))
           t12[I1&I2]=1
           t1[I1]=1
           sp=sum(t12)/len(c1) #支持度
           co=sum(t12)/sum(t1) #置信度
           #取置信度大于等于c0的关联规则
           if co>=c0 and sp>=s0:
              list1.append(c[k]+'--'+c[q])
              list2.append(sp)
              list3.append(co)
#定义字典，用于存放关联规则及其置信度、支持度   
R={'rule':list1,'support':list2,'confidence':list3}
#将字典转化为数据框
R=pd.DataFrame(R)
#将结果导出到Excel
R.to_excel('rule1.xlsx')

import apriori                 #导入自行编写的apriori函数
outputfile = 'apriori_rules.xls'     #结果文件
support = 0.2                  #最小支持度
confidence = 0.4               #最小置信度
ms = '---'                      #连接符，默认'--'，
apriori.find_rule(Data, support, confidence, ms).to_excel(outputfile)     #保存结果到Excel
