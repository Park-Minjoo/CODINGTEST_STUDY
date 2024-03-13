import sys, copy
from collections import deque

'''
문제: 커리큘럼
'''

def solution():
    # result = times[:]
    result = copy.deepcopy(times)
    queue = deque()

    for i in range(1, n + 1):
        if check[i] == 0: queue.append(i)
    
    while queue:
        current_node = queue.popleft()

        for i in graph[current_node]:
            result[i] = max(result[current_node] + times[i], result[i])
            check[i] -= 1
            if check[i] == 0: queue.append(i)
    
    return result

n = int(sys.stdin.readline())

check = [0] * (n + 1)
graph = [[] for _ in range(n + 1)]
times = [0] * (n + 1)

for i in range(n):
    input = list(map(int, sys.stdin.readline().split()))
    times[i + 1] = input[0]

    for node in input[1:-1]:
        graph[node].append(i+1)
        check[i + 1] += 1

for time in solution()[1:]:
    print(time)

'''
입력
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1

출력
10
20
14
18
17
'''