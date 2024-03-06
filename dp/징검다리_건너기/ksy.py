import sys, copy

'''
문제: 징검다리 건너기 (실버1)
분류: dp
'''

n = int(sys.stdin.readline())
jump_scores = [list(map(int, sys.stdin.readline().split())) for _ in range(n-1)]
k = int(sys.stdin.readline())

# 매우 큰 점프 사용 X
dp = [0] * n
if 1 < n: dp[1] = jump_scores[0][0]

for i in range(2, n):
    dp[i] = min(dp[i-1] + jump_scores[i-1][0], dp[i-2] + jump_scores[i-2][1])

# 매우 큰 점프 사용 O
dp_k = copy.deepcopy(dp)
for i in range(3, n):
    dp_k[i] = min(dp[i-3] + k, dp_k[i])
    for j in range(i + 1, n):
        dp_k[j] = min(dp_k[j-1] + jump_scores[j-1][0], dp_k[j-2] + jump_scores[j-2][1])

print(dp_k[n-1])