INF = int(1e9)

n, m = map(int, input().split())
graph = [[INF] * (n+1) for i in range(n+1)]

# 자기 자신인 경우, 0으로 초기화
for a in range(1, n+1):
    for b in range(1, n+1):
        if a == b:
            graph[a][b] = 0

# 간선에 대한 정보, 거리는 다 1로 초기화
for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

x, k = map(int, input().split())

# 플로이드 워셜 알고리즘
for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# 결과
distance = graph[1][k] + graph[k][x]


if distance >= 1e9:
    print("-1") # 도달할 수 없는 경우
else:
    print(distance) # 도달한 경우

'''
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
'''