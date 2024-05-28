import sys

# 문제가 뭘 하라는건지 모르겠어서 해설 보고 푼 문제..ㅎ

n = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
nums.reverse()

dp = [1] * n

for i in range(1, n):
    for j in range(0, i):
        if nums[j] < nums[i]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))

'''
입력
7
15 11 4 8 5 2 4
출력
2
'''