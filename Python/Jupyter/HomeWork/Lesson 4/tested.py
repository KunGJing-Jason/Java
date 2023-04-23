import pandas as pd
from sklearn.ensemble import RandomForestRegressor, GradientBoostingRegressor
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_absolute_error

# 加载泰坦尼克号数据
data = pd.read_csv('test.csv')

# 数据预处理
data['Sex'] = data['Sex'].replace({'male': 0, 'female': 1})
data['Embarked'] = data['Embarked'].replace({'C': 0, 'Q': 1, 'S': 2})
data = data[['Pclass', 'Sex', 'SibSp', 'Parch', 'Fare', 'Embarked', 'Age']].dropna()

# 划分训练集和测试集
X = data.drop('Age', axis=1)
y = data['Age']
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# 训练随机森林模型
rf_model = RandomForestRegressor(n_estimators=100, random_state=42)
rf_model.fit(X_train, y_train)
rf_predictions = rf_model.predict(X_test)
rf_mae = mean_absolute_error(y_test, rf_predictions)

# 训练梯度提升树模型
gb_model = GradientBoostingRegressor(n_estimators=100, random_state=42)
gb_model.fit(X_train, y_train)
gb_predictions = gb_model.predict(X_test)
gb_mae = mean_absolute_error(y_test, gb_predictions)

# 输出模型得分
print(f"Random Forest Mean Absolute Error: {rf_mae:.2f}")
print(f"Gradient Boosting Mean Absolute Error: {gb_mae:.2f}")