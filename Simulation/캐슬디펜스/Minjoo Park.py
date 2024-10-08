# check: https://ryu-e.tistory.com/105

import sys
input = sys.stdin.readline
import copy

def combinations(arr, r):
    for i in range(len(arr)):
        if r == 1:
            yield [arr[i]]
        else:
            for next in combinations(arr[i+1:], r-1):
                yield [arr[i]] + next

def attack(list_):
    # 궁수별 가까운 적 공격
    attack_list = list()
    cnt = 0
    for l in list_:
        pos = list()
        for i in range(n):
            for j in range(m):
                if temp[i][j] == 1:
                    now_d = abs(i - n) + abs(j - l)
                    if d >= now_d:
                        pos.append((now_d, i, j))
        pos.sort(key=lambda x: (x[0], x[2]))
        if pos:
            attack_list.append(pos[0])

    for a in attack_list:
        _, i, j = a
        if temp[i][j] == 1:
            temp[i][j] = 0
            cnt += 1
    return cnt

def move():
    for i in range(-1, -n, -1):
        temp[i] = temp[i-1]
    temp[0] = [0 for _ in range(m)]

def is_empty():
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 1:
                return False
    return True

n, m, d = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
items = [i for i in range(m)]
result = 0

for a in combinations(items, 3):
    temp = copy.deepcopy(graph)
    count = 0
    while not is_empty():
        count += attack(a)
        move()
    result = max(result, count)
print(result)
