import sys, heapq

INF = int(1e9)
n, m, start = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]
times = [INF] * (n + 1)

for _ in range(m):
    x, y, z = map(int, sys.stdin.readline().split())
    graph[x].append((y, z))

def solution(start):
    q = []
    heapq.heappush(q, (0, start))
    times[start] = 0

    while q:
        current_node_time, current_node_num = heapq.heappop(q)

        if times[current_node_num] < current_node_time:
            continue

        for connect_node in graph[current_node_num]:
            new_time = current_node_time + connect_node[1]
            if new_time < times[connect_node[0]]:
                times[connect_node[0]] = new_time
                heapq.heappush(q, (new_time, connect_node[0]))

solution(start)

count = -1
max_time = 0
for time in times:
    if time != INF:
        count += 1
        max_time = max(max_time, time)

print(count, max_time)

'''
문제: 전보 
유형: 최단 경로 - 다익스트라
입력
3 2 1
1 2 4
1 3 2
출력
2 4
'''