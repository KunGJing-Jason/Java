import pandas as pd
import numpy as np

#读取数据为DataFrame格式
data = pd.read_excel('国际股票价格指数日交易数据表.xlsx')

#取出Indexcd列的所有唯一值
unique_list = data["Indexcd"].unique()
for i in unique_list:
    #空格1：
    #用来筛选出data DataFrame中Indexcd列等于i的所有行，并且只选取这些行的Trddt列
    df_trddt = data[data["Indexcd"]==i]["Trddt"]
    # 用来筛选出data DataFrame中Indexcd列等于i的所有行，并且只选取这些行的Clsdix列
    df_clsidx = data[data["Indexcd"]==i]["Clsidx"]

    # 空格2：
    #用来计算每个股票指数每天的涨跌幅是否超过了0.5%
    #(df_clsidx.shift(1) / df_clsidx)计算的是当天收盘价相对于前一天收盘价的变化率，其中1减去这个变化率，得到的是当天的涨跌幅
    df_bool = abs(1 - (df_clsidx.shift(1) / df_clsidx)) > 0.005

    # 第一个“股指”对应初始化的df_result
    if i == "DJI":
    #空格3：
        # 将两个Series按按水平方向拼接起来，生成一个新的DataFrame df_result
        df_result = pd.concat([df_trddt, df_bool], axis=1)
    # 非第一个“股指”进行循环merge操作，用inner连接逐步取出非共同Trddt的行
    else:
    # 空格4：
        # 两个DataFrame按照交易日期进行内连接（inner join），然后将结果赋值给df_result
        df_result = pd.merge(df_result, pd.concat([df_trddt, df_bool], axis=1), how='inner', on='Trddt')


#df_result就是“购物篮”的布尔集形式，删除第一列时间，其余列名用“股指名称”
df_result.drop(columns=["Trddt"], inplace=True)
df_result.columns = unique_list

#scan频繁集
from mlxtend.frequent_patterns import apriori

#算频繁集之间的关联关系
from mlxtend.frequent_patterns import association_rules

#最小支持度设为0.1
out_1 = apriori(df_result.iloc[:, 1:], min_support=0.1, use_colnames=True)

#最小置信度设为0.6，metric也可设为提升度“lift”
out_2 = association_rules(out_1, metric='confidence', min_threshold=0.6)

#如何同时筛选support,confidence,lift并根据某个指标排序？？？
#空格5：
#对一个频繁项集关联规则的结果进行排序，并且按照支持度、置信度和提升度降序排序
print(out_2.sort_values(by=['support', 'confidence', 'lift'], ascending=[False, False, False]))

