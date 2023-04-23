import pandas as pd

df = pd.DataFrame({'Id': [202001, 202002, 202003, 202004, 202005, 202006, 202007, 202008, 202009, 202010],
                   'Chinese': [98, 67, 84, 88, 78, 90, 93, 75, 82, 87],
                   'Math': [92, 80, 73, 76, 88, 78, 90, 82, 77, 69],
                   'English': [88, 79, 90, 73, 79, 83, 81, 91, 71, 78]})
temp = df[['Chinese','Math','English']]
df["SumScore"] = temp.sum(axis=1)
df["MeanScore"] = temp.mean(axis=1).astype(int)
df["MaxScore"] = temp.max(axis=1)
df["MinScore"] = temp.min(axis=1)
df["PtpScore"] = temp.max(axis=1) - temp.min(axis=1)
df["VarScore"] = temp.var(axis=1).astype(int)

df.style

print(df)

data = pd.concat([df.iloc[:,0],df.iloc[:,1],df.iloc[:,2],df.iloc[:,3],df.iloc[:,4],df.iloc[:,5],df.iloc[:,6],df.iloc[:,7],df.iloc[:,8],df.iloc[:,9]])
df = pd.DataFrame(data, columns=['answer'])
df['id'] = range(len(df))
df = df[['id', 'answer']]


print(df)

#————————————————————————————————————————————————
# code by 陈龙Date 2023-03-07 : UTC(13:38) + 8:00
# All rights reserved
# copy not permitted