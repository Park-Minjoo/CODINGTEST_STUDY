# 인접한 모든 자리의 차이가 1 -> 계단수

import sys
input = sys.stdin.readline

n = int(input())
# DP 테이블 초기화
dp = [[0] * 10 for _ in range(n)]

# 초기값 설정
dp[0] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]

for i in range(1, n):
    dp[i][0] = dp[i - 1][1]
    dp[i][9] = dp[i - 1][8]
    # print(dp)
    for k in range(1, 9):
        dp[i][k] = dp[i-1][k-1] + dp[i-1][k+1]
        # print(dp)
print(sum(dp[n-1])%1000000000)
'''
Input
1
Output
9

Input2
2
Output2
17
'''



