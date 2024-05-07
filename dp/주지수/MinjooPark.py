import sys
input = sys.stdin.readline

n, m = map(int, input().split())
people = [list(map(int, input().split())) for _ in range(n)]

dp = [[0] * (m+1) for _ in range(n+1)]
for i in range(1, n+1):
    for j in range(1, m+1):
        dp[i][j] = people[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]

for _ in range(int(input())):
    x, y, i, j = map(int, input().split())
    print(dp[i][j] - dp[x-1][j] - dp[i][y-1] + dp[x-1][y-1])


'''
Input
4 4
9 14 29 7
1 31 6 13
21 26 40 16
8 38 11 23
3
1 1 3 2
1 1 1 4
1 1 4 4

Output
102
59
293
'''