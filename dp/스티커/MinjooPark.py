'''
⭐️
'''

tc = int(input())
for _ in range(tc):
    n = int(input())
    dp = [list(map(int, input().split())) for _ in range(2)]

    if n == 1:
        print(max(dp[0][0], dp[1][0]))
        continue
    elif n > 1:
        dp[0][1] += dp[1][0]
        dp[1][1] += dp[0][0]

    for i in range(2, n):
        dp[0][i] += max(dp[1][i-1], dp[1][i-2])
        dp[1][i] += max(dp[0][i-1], dp[0][i-2])

    print(max(dp[0][n-1], dp[1][n-1]))

'''
3
1
30
50
5
50 10 100 20 40
30 50 70 10 60
7
10 30 10 50 100 20 40
20 40 30 50 60 20 80
'''