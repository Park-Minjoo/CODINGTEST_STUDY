import sys

# 입력
n = int(sys.stdin.readline())
target = int(sys.stdin.readline())

graph = [[0] * n for _ in range(n)]

x = n // 2
y = n // 2
x_sign = -1
y_sign = 1
x_count = 0
y_count = 0
current_length = 1
target_x = 0
target_y = 0

for num in range(1, n * n + 1):
    if num == target:
        target_x = x
        target_y = y

    graph[x][y] = str(num)

    if x_count < current_length:
        x_count += 1
        x += x_sign
        continue
    
    if y_count < current_length:
        y_count += 1
        y += y_sign
        continue
    
    if x_count == y_count == current_length:
        x_sign *= -1
        y_sign *= -1
        current_length += 1
        x_count = 1
        y_count = 0
        x += x_sign

for line in graph:
    print(' '.join(line))

print(target_x + 1, target_y + 1)