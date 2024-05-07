# 참고: https://velog.io/@hygge/Python-%EB%B0%B1%EC%A4%80-2573-%EB%B9%99%EC%82%B0-BFS
# 아직 수정 중...

import sys
input = sys.stdin.readline
from collections import deque

def bfs(x, y):
    q = deque([(x, y)])
    visited[x][y] = 1
    seaList = []

    while q:
        x, y = q.popleft()
        sea = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if not graph[nx][ny]:
                    sea += 1
                    # print('sea', sea, graph[nx][ny])

            elif graph[nx][ny] and not visited[nx][ny]:
                # print(graph[nx][ny], not visited[nx][ny], (x, y))
                q.append((x, y))
                visited[nx][ny] = 1

        if sea > 0:
            seaList.append((x, y, sea))
            # print(seaList)

    for x, y, sea in seaList:
        graph[x][y] = max(0, graph[x][y] - sea)
    return 1

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
ice = [] # 빙산 위치 저장
for i in range(n):
    for j in range(m):
        if graph[i][j]:
            ice.append((i, j))
print('ice', ice)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
year = 0

while ice:
    visited = [[0] * m for _ in range(n)]
    delList = []
    group = 0
    for i, j in ice:
        print('ice[i][j]: ', i, j)
        if graph[i][j] and not visited[i][j]:
            group += bfs(i, j)
            print('bfs', group)
        if graph[i][j] == 0:
            delList.append((i, j)) # ice에서 제거하기 위해 delList에 저장
            print('delList', delList)
    if group > 1:
        print(year)
        break
    ice = sorted(list(set(ice) - set(delList)))
    year += 1

if group < 2:
    print(0)
'''
Input
5 7
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0

Output
2
'''