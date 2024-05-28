import sys

n = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))

dp = [0] * n

if 1 <= n:
    dp[0] = nums[0]

if 2 <= n:
    dp[1] = max(dp[0], nums[1])

for i in range(2, n):
    dp[i] = max(dp[i-1], dp[i-2] + nums[i])

print(dp[n-1])

'''
입력
4
1 3 1 5
출력
8
'''