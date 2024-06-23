import sys
sys.setrecursionlimit(100000)

T = int(input())
def dfs(y, x):
    graph[y][x] = '.'
    dy = [0, 1, 0, -1]
    dx = [1, 0, -1, 0]
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if ny >= 0 and nx >= 0 and ny < H and nx < W:
            if graph[ny][nx] == "#":
                dfs(ny, nx)

for _ in range(T):
    H, W = map(int, input().split())
    graph = [list(input()) for _ in range(H)]
    count = 0
    for i in range(H):
        for j in range(W):
            if graph[i][j] == '#':
                dfs(i, j)
                count += 1

    print(count)

'''
Input
2
4 4
#.#.
.#.#
#.##
.#.#
3 5
###.#
..#..
#.###

Output
6
3
'''