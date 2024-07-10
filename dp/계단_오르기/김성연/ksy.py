import sys

'''
문제: 계단 오르기 (실버3)
분류: dp
메모리: 31120 KB
시간: 40 ms

* 점화식을 못 찾아서, 검색한 문제 (코드 확인 X) - 나중에 다시 풀어보기
'''

n = int(sys.stdin.readline())
stairs = [int(sys.stdin.readline()) for _ in range(n)]
dp = [0] * (n)

dp[0] = stairs[0]
if 1 < n: dp[1] = max(stairs[1], stairs[0] + stairs[1])
if 2 < n: dp[2] = max(stairs[0] + stairs[2], stairs[1] + stairs[2])

for i in range(3, n):
    dp[i] = max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i])

print(dp[n-1])
