import sys
from itertools import combinations

# 입력
n, m = map(int, sys.stdin.readline().split())
preferences = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

max_sum = 0
for idx1, idx2, idx3 in combinations(range(m), 3):
    current_sum = 0
    for preference in preferences:
        current_sum += max(preference[idx1],preference[idx2],preference[idx3])

    max_sum = max(max_sum, current_sum)

print(max_sum)