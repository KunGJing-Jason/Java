# 导入必要的库和模块
import pandas as pd
from sklearn.ensemble import RandomForestRegressor
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error

# 读取“泰坦尼克号”数据集
titanic = pd.read_csv('test.csv')

# 取出Age字段为空的记录作为测试集，其余记录作为训练集
test = titanic[titanic['Age'].isnull()]
train = titanic[titanic['Age'].notnull()]

# 提取特征和目标变量
features = ['Pclass', 'Sex', 'SibSp', 'Parch', 'Fare', 'Embarked']
target = 'Age'
X_train = train[features]
y_train = train[target]
X_test = test[features]

# 将分类变量转换为虚拟变量
X_train = pd.get_dummies(X_train)
X_test = pd.get_dummies(X_test)

# 划分训练集和测试集
X_train_part, X_test, y_train_part, y_test = train_test_split(X_train, y_train, test_size=0.2, random_state=0)

# 使用随机森林模型进行预测
rf_model = RandomForestRegressor(n_estimators=100, random_state=42)
rf_model.fit(X_train_part, y_train_part)
rf_predictions = rf_model.predict(X_test)
rf_score = rf_model.score(X_test, y_test)
print('随机森林模型分数:', rf_score)

# 使用线性回归模型进行预测
lr_model = LinearRegression()
lr_model.fit(X_train_part, y_train_part)
lr_predictions = lr_model.predict(X_test)
lr_score = lr_model.score(X_test, y_test)
print('线性回归模型分数:', lr_score)

# 计算均方误差（MSE）和均方根误差（RMSE）
rf_mse = mean_squared_error(y_test, rf_predictions)
rf_rmse = rf_mse ** 0.5
print('随机森林均方误差:', rf_mse)
print('随机森林均方根误差:', rf_rmse)

lr_mse = mean_squared_error(y_test, lr_predictions)
lr_rmse = lr_mse ** 0.5
print('线性回归均方误差:', lr_mse)
print('线性回归均方根误差:', lr_rmse)