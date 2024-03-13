import sys
input = sys.stdin.readline
from collections import deque
import copy

n = int(input())
indegree = [0] * (n+1)
graph = [[] for i in range(n+1)]
time = [0] * (n+1)

for i in range(1, n+1):
    values = list(map(int, input().split()))
    time[i] = values[0]
    for x in values[1:-1]:
        indegree[i] += 1
        graph[x].append(i)
        # print(graph)

# 위상정렬 함수
def topology_sort():
    result = copy.deepcopy(time) # 알고리즘 수행 결과를 담을 리스트
    q = deque() # 큐 기능을 위한 deque 라이브러리 사용

    # 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
    for i in range(1, n+1):
        if indegree[i] == 0:
            q.append(i)

    #큐가 빌 때까지 반복
    while q:
        # 큐에서 원소 꺼내기
        now = q.popleft()
        result.append(now)
        # 해당 노드의 진입차수에서 1빼기
        for i in graph[now]:
            result[i] = max(result[i], result[now] + time[i])
            indegree[i] -= 1
            # 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
            if indegree[i] == 0:
                q.append(i)

    # 위상 정렬을 수행한 결과
    for i in range(1, n+1):
        print(result[i])

topology_sort()


'''
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
'''
