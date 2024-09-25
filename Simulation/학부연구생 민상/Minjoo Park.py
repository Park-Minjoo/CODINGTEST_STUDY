import sys
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
maps = [list(map(int, input().rstrip().split())) for _ in range(n)]
on = [[0 for _ in range(m)] for _ in range(n)]

row = [-1, 1, 0, 0]
col = [0, 0, -1, 1]

for i in range(n):
    for j in range(m):
        if maps[i][j] == 9:
            on[i][j] = 1
            for d in range(4):
                y = i + row[d]
                x = j + col[d]
                dir = d
                while 0 <= y < n and 0 <= x < m:
                    on[y][x] = 1
                    if maps[y][x] == 0 or (maps[y][x] == 1 and dir <= 1) or (maps[y][x] == 2 and dir >= 2):
                        y += row[dir]
                        x += col[dir]
                    elif maps[y][x] == 3:
                        if dir == 0: dir = 3
                        elif dir == 1: dir = 2
                        elif dir == 2: dir = 1
                        else: dir = 0
                        y += row[dir]
                        x += col[dir]
                    elif maps[y][x] == 4:
                        if dir == 0: dir = 2
                        elif dir == 1: dir = 3
                        elif dir == 2: dir = 0
                        else: dir = 1
                        y += row[dir]
                        x += col[dir]
                    else: break
result = 0
for i in range(n): result += on[i].count(1)
print(result)