# 참고: https://velog.io/@hygge/Python-%EB%B0%B1%EC%A4%80-2573-%EB%B9%99%EC%82%B0-BFS
# 아직 수정 중...

import sys
input = sys.stdin.readline
from collections import deque

def bfs(x, y):
    q = deque([(x, y)])
    visited[x][y] = 1
    seaList = [] # (x, y, 빙산 주변의 바다 개수) 형태로 저장
    # 연결된 빙산을 모두 탐색한 후에 빙산을 녹이기 위해서 (바로 녹이면 바다로 인식할 수도 있기 때문)

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
                q.append((nx, ny))
                visited[nx][ny] = 1

        if sea > 0:
            seaList.append((x, y, sea))
            # print(seaList)

    for x, y, sea in seaList:
        graph[x][y] = max(0, graph[x][y] - sea)

    return 1 # 빙산 그룹의 수를 카운트해야 하기 때문에 하나의 그룹을 탐색했다는 의미로 1을 리턴

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
ice = [] # 빙산 위치 저장 (i, j) 형태
for i in range(n):
    for j in range(m):
        if graph[i][j]:
            ice.append((i, j))
# print('ice', ice)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
year = 0

while ice:
    visited = [[0] * m for _ in range(n)]
    delList = []
    group = 0
    for i, j in ice:
        # print('ice[i][j]: ', i, j)
        if graph[i][j] and not visited[i][j]:
            group += bfs(i, j)
            # print('bfs', group)
        if graph[i][j] == 0: # 탐색이 끝나면 바다가 된 빙산을 체크
            delList.append((i, j)) # ice에서 제거하기 위해 delList에 저장
            # print('delList', delList)
    if group > 1: # 빙산 그룹이 2 이상이면 year를 출력
        print(year)
        break
    # 다 녹은 빙산은 탐색할 필요가 없음 -> ice에서 제거
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