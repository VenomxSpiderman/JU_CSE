from collections import OrderedDict
from itertools import groupby

stock_prices1 = OrderedDict({
    "AAPL": 100,
    "GOOGL": 2800,
    "TSLA": 750,
    "AMZN": 3400,
    "MSFT": 299,
    "NFLX": 600,
    "NVDA": 800,
    "META": 320,
    "TATA":15
})

min_stock = min(stock_prices1.items(), key=lambda x: x[1])
max_stock = max(stock_prices1.items(), key=lambda x: x[1])
sorted_stocks1 = OrderedDict(sorted(stock_prices1.items(), key=lambda x: x[1]))

print(f"Minimum Price: {min_stock}")
print(f"Maximum Price: {max_stock}")
print(f"Sorted Stocks: {sorted_stocks1}")

stock_prices2 = OrderedDict({
    "TSLA": 750,
    "AAPL": 155,  
    "GOOGL": 2800,
    "AMZN": 3400,
    "IBM": 130,
    "INTC": 500,
    "NVDA": 850,
    "TATA":25
})

unique_to_stock1 = set(stock_prices1.keys()) - set(stock_prices2.keys())
print(f"Items only in first dictionary: {unique_to_stock1}")

mismatched_prices = {
    key: (stock_prices1[key], stock_prices2[key])
    for key in set(stock_prices1.keys()).intersection(stock_prices2.keys())
    if stock_prices1[key] != stock_prices2[key]
}
print(f"Items with different prices: {mismatched_prices}")

unique_stock_prices1 = OrderedDict({k: v for k, v in stock_prices1.items() if k not in stock_prices2})
print(f"First Dictionary after removing duplicates: {unique_stock_prices1}")

sorted_stocks1 = OrderedDict(sorted(stock_prices1.items(), key=lambda x: x[1]))

sorted_stocks2 = OrderedDict(sorted(stock_prices2.items(), key=lambda x: x[1]))

print(f"Sorted First Dictionary: {sorted_stocks1}")

print(f"Sorted Second Dictionary: {sorted_stocks2}")

grouped_stocks1 = {k: list(v) for k, v in groupby(sorted_stocks1.items(), key=lambda x: x[1] // 500)}

print(f"Grouped Stocks in multiples of 500: {grouped_stocks1}")

stock_800_1 = [k for k, v in stock_prices1.items() if v == 800]

stock_800_2 = [k for k, v in stock_prices2.items() if v == 800]

print(f"Stocks priced at 800 in First Dictionary: {stock_800_1}")

print(f"Stocks priced at 800 in Second Dictionary: {stock_800_2}")

