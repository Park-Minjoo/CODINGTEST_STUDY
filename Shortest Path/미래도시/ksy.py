import sys

INF = int(1e9)
n, m = map(int, sys.stdin.readline().split())

graph = [[INF] * (n + 1) for _ in range(n + 1)]

for i in range(n + 1):
    graph[i][i] == 0

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a][b] = 1
    graph[b][a] = 1

x, k = map(int, sys.stdin.readline().split())

for middle in range(1, n + 1):
    for start in range(1, n + 1):
        for end in range(1, n + 1):
            graph[start][end] = min(graph[start][end], graph[start][middle] + graph[middle][end])

result = graph[1][k] + graph[k][x]

if INF <= result:
    print(-1)
else:
    print(result)

'''
문제: 미래도시
유형: 최단 경로 - 플로이드
입력
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
출력
3
'''