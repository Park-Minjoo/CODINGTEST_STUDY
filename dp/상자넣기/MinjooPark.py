import sys
input = sys.stdin.readline

# 앞에 있는 상자 < 뒤에 있는 상자 : 넣을 수 있음 -> 최대를 구해라
n = int(input())
boxes = list(map(int, input().split()))

dp = [1 for _ in range(n)]

for i in range(1, n):
    for j in range(i):
        if boxes[i] > boxes[j]:
                dp[i] = max(dp[i], dp[j]+1)
print(max(dp))
'''
Input
8
1 6 2 5 7 3 5 6
Output
5

Input2
10
1 2 3 4 5 6 7 8 9 10
Output2
10
'''