import sys

# 입력
n = int(sys.stdin.readline())
lengths = list(map(int, sys.stdin.readline().split()))
prices = list(map(int, sys.stdin.readline().split()))

result = 0
current_price = max(prices)
for i in range(n-1):
    current_price = min(current_price, prices[i])
    result += lengths[i] * current_price

print(result)