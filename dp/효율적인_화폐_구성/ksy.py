import sys

n, m = map(int, sys.stdin.readline().split())
dp = [m + 1] * (m + 1)
nums = [int(sys.stdin.readline()) for _ in range(n)]
dp[0] = 0

for i in range(min(nums), m + 1):
    for num in nums:
        if 0 <= i - num and dp[i-num] != (m+1):
            dp[i] = min(dp[i], dp[i - num] + 1)
    
if dp[m] == m + 1:
    print(-1)
else:
    print(dp[m])

'''
입력
2 15
2
3
출력
5

입력
3 4
3
5
7
출력
-1
'''