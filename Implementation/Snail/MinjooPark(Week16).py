import sys
input = sys.stdin.readline

n = int(input())
k = int(input())

# 달팽이가 돌아가는 방향
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
graph = [[0] * n for _ in range(n)]

x, y = n//2, n//2
graph[x][y] = 1 # 시작값
repeat = 1
i = 0
num = 2
ans = [0,0]

while x != 0 or y != 0: # 마지막 점 (0,0)
    flag = 0
    for _ in range(2):
        for _ in range(repeat):
            x += dx[i]
            y += dy[i]
            graph[x][y] = num
            if num == k: # 찾는 숫자
                ans = [x+1, y+1]
            if x == 0 and y == 0: # 마지막
                flag = 1
                break
            num += 1
        if flag == 1: break
        i = (i+1)%4 # 0 1 2 3
    repeat += 1 # 반복 횟수 증가

for i in graph:
    print(*i, sep=' ')

print(*ans)



'''
Input
7
35

Output
49 26 27 28 29 30 31
48 25 10 11 12 13 32
47 24 9 2 3 14 33
46 23 8 1 4 15 34
45 22 7 6 5 16 35
44 21 20 19 18 17 36
43 42 41 40 39 38 37
5 7
'''