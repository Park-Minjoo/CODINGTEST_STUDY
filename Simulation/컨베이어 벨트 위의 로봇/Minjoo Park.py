from sys import stdin
from collections import deque

def solution(N, K, A):
    answer = 0
    belt = deque([False] * N)

    while True:
        answer += 1

        A.rotate(1)
        belt.rotate(1)

        belt[N-1] = False

        for i in range(N-2, -1, -1):
            if belt[i] and not belt[i+1] and A[i+1] > 0:
                belt[i], belt[i+1] = False, True
                A[i+1] -= 1

        belt[N-1] = False

        if A[0] > 0:
            belt[0] = True
            A[0] -= 1

        if A.count(0) >= K:
            break

    return answer

N, K = map(int, stdin.readline().split())
A = deque(list(map(int, stdin.readline().split())))

response = solution(N, K, A)
print(response)