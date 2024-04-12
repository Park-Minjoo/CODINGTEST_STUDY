import sys, math

'''
문제: 거의 소수
메모리: 111368 KB
시간: 2708 ms
https://www.acmicpc.net/problem/1456
'''

input = sys.stdin.readline

def find_prime_numbers(b):
    check_prime_number = [True] * (int(math.sqrt(b)) + 1)
    check_prime_number[0] = False
    check_prime_number[1] = False

    for i in range(2, int(math.sqrt(b) + 1)):
        if check_prime_number[i]:
            for j in range(2 * i, int(math.sqrt(b)) + 1, i):
                check_prime_number[j] = False
    return check_prime_number

def solution(a, b):
    count = 0
    check_prime_numbers = find_prime_numbers(b)
    
    for i in range(2, len(check_prime_numbers)):
        if check_prime_numbers[i]:
            num = i * i
            while True:
                if num < a:
                    num *= i
                    continue

                if b < num:
                    break

                count += 1
                num *= i
    return count

# ----- 입력 & 출력 -----
a, b = map(int, input().split())
print(solution(a, b))