import sys, math

'''
문제: 다음 소수
분류: 수학, 브루트포스, 소수 판정
메모리: 33240 KB
시간: 1452 ms
'''

def is_primary_number(number):
    for i in range(2, int(math.sqrt(number)) + 1):
        if number % i == 0:
            return False
    return True

def find_primary_number(n):
    if n == 0 or n == 1:
        return 2

    current_num = n
    while True:
        if is_primary_number(current_num):
            return current_num
        current_num += 1

def solution(test_case_num):
    for _ in range(test_case_num):
        n = int(sys.stdin.readline())
        print(find_primary_number(n))

# --------- 입력 ------------------
test_case_num = int(sys.stdin.readline())
solution(test_case_num)
