import heapq
import sys
input = sys.stdin.readline
INF = int(1e9) # 무한, 10억

n, m, start = map(int, input().split())
graph = [[] for i in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
    x, y, z = map(int, input().split())
    # X에서 Y로 가는 거리 비용이 Z
    graph[x].append((y,z))
def dijkstra(start):
    q = []
    # 시작노드로 가기 위한 최단 거리 0, 큐에 삽입
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q: # 큐가 비어있지 않으면,
        # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 다른 인접한 노드 확인
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐서~ 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(start)
count = 0 # 도달할 수 있는 노드의 개수
max_distance = 0 # 도달할 수 있는 노드 중에서 가장 멀리 있는 노드의 최단 거리

for d in distance:
    # 도달할 수 있는 노드
    if d != 1e9:
        count += 1
        max_distance = max(max_distance, d)

# 시작노드 제외 (-1)
print(count -1, max_distance)

'''
3 2 1
1 2 4
1 3 2
'''