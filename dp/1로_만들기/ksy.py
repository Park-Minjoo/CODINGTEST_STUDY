import sys

x = int(sys.stdin.readline())
dp = [0] * (x + 1)
dp[1] = 0

for i in range(2, x + 1):
    dp[i] = dp[i-1] + 1

    if i % 5 == 0:
        dp[i] = min(dp[i], dp[i//5] + 1)
    
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i//3] + 1)

    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i//2] + 1)

print(dp[x])

'''
입력
26
출력
3
'''