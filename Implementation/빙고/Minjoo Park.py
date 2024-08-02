import sys
input = sys.stdin.readline

board = []
for _ in range(5):
    board.append(list(map(int, input().strip().split())))

call = []
for _ in range(5):
    call.append(list(map(int, input().strip().split())))

bingo = [[0] * 5 for _ in range(5)]

def check_row():
    res = 0
    for i in range(5):
        cnt = 0
        for j in range(5):
            if bingo[i][j] == 1:
                cnt += 1
        if cnt == 5:
            res += 1
        return res

def check_col():
    res = 0
    for i in range(5):
        cnt = 0
        for j in range(5):
            if bingo[j][i] == 1:
                cnt += 1
        if cnt == 5:
            res += 1
        return res

def check_dia():
    res = 0
    cnt = 0
    for i in range(5):
        if bingo[i][5 - i - 1] == 1:
            cnt += 1
    if cnt == 5:
        res += 1
    cnt = 0
    for i in range(5):
        if bingo[i][i] == 1:
            cnt += 1
    if cnt == 5:
        res += 1
    return res

cnt = 0
for i in range(5):
    for j in range(5):
        s = call[i][j]
        for y in range(5):
            for x in range(5):
                if board[y][x] == s:
                    cnt = 0
                    bingo[y][x] = 1
                    cnt += check_row()
                    cnt += check_col()
                    cnt += check_dia()
                    if cnt >= 3:
                        print(
                            i * 5 + j + 1
                        )
                        exit()

'''
Input
11 12 2 24 10
16 1 13 3 25
6 20 5 21 17
19 4 8 14 9
22 15 7 23 18
5 10 7 16 2
4 22 8 17 13
3 18 1 6 25
12 19 23 14 21
11 24 9 20 15

Output
15
'''
