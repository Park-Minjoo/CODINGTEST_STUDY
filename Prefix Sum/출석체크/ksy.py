import sys

'''
문제: 출석체크
분류: 누적합, 수학
메모리: 31120 KB
시간: 520 ms

* 시간 초과 나서 풀이법 확인 (코드 확인 X)
'''

n, k, q, m = map(int, sys.stdin.readline().split())
k_students = list(map(int, sys.stdin.readline().split()))
q_students = list(map(int, sys.stdin.readline().split()))
attend_status = [False] * (n + 3)

for num in range(n + 3):
    if num in k_students:
        continue

    for q_student in q_students:
        if q_student in k_students:
            continue

        if num % q_student == 0:
            attend_status[num] = True
            break

dp = [0] * (n + 3)
for i in range(3, n + 3):
    if not attend_status[i]:
        dp[i] = dp[i - 1] + 1
    else:
        dp[i] = dp[i - 1]

for _ in range(m):
    s, e = map(int, sys.stdin.readline().split())
    print(dp[e] - dp[s-1])
