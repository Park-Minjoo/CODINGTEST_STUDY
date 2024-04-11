import sys
from math import prod

'''
문제: 최대공약수
메모리: 33240 KB
시간: 76 ms
https://www.acmicpc.net/problem/2824
'''

input = sys.stdin.readline

def gcd(a, b):
    while 0 < b:
        a, b = b, a % b
    return a

def solution(a, b):
    result = str(gcd(a, b))

    if 9 < len(result):
        return result[-9:]
    else:
        return result

# ----- 입력 & 출력 -----
n = int(input())
a = prod(list(map(int, input().split())))
m = int(input())
b = prod(list(map(int, input().split())))

print(solution(a, b))