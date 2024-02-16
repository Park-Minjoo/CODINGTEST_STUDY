import sys

r, c = map(int, sys.stdin.readline().split())
graph = [sys.stdin.readline() for _ in range(r)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

result = []
min_x = r
min_y = c
max_x = 0
max_y = 0
for x in range(r):
    line = ''
    for y in range(c):
        if graph[x][y] == '.':
            line += '.'
            continue
        
        sea_count = 0
        for i in range(len(dx)):
            new_x = x + dx[i]
            new_y = y + dy[i]

            if new_x < 0 or r <= new_x or new_y < 0 or c <= new_y: 
                sea_count += 1
                continue

            if graph[new_x][new_y] == '.': 
                sea_count += 1
            
        if 3 <= sea_count:
            line += '.'
        else:
            min_y = min(y, min_y)
            max_y = max(y, max_y)
            min_x = min(x, min_x)
            max_x = max(x, max_x)
            line += 'X'

    result.append(line)

for x in range(min_x, max_x + 1):
    print(result[x][min_y: max_y + 1])