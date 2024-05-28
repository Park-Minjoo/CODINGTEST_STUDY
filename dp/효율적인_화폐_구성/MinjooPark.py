n, m = map(int, input().split())
cost = [int(input()) for _ in range(n)]

d = [10001] * (m+1)
d[0] = 0
for i in range(n): # 3
    for j in range(cost[i], m+1): # cost ~ 7
        if d[j - cost[i]] != 10001:
            d[j] = min(d[j], d[j - cost[i]] + 1)

if d[m] == 10001:
    print(-1)
else:
    print(d[m])


'''
3 7
2
3
5

2 13
2
3
'''