import matplotlib.pyplot as plt
import pandas as pd

import datetime
import pandas_datareader.data as web
from pandas import Series, DataFrame


start = datetime.datetime(2010, 1, 1)
end = datetime.datetime(2017, 1, 11)

df = web.DataReader("AAPL", '', start, end)
df.tail()

plt.plot(df['Close'].tail(100))
plt.ylabel('Gía chứng khoán')
plt.xlabel('Thời gian')
plt.title('Gía chứng khoán APPLE')