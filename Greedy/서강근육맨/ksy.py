import sys

'''
문제: 서강 근육맨
메모리: 32140 KB
시간: 48 ms
https://www.acmicpc.net/problem/20300
'''

input = sys.stdin.readline

def calculate_max_m(n, nums):
    max_sum = 0

    for i in range(0, n//2):
        current_sum = nums[i] + nums[n - (i + 1)]
        max_sum = max(max_sum, current_sum)
    
    return max_sum

def solution(n, nums):
    nums.sort()

    if n % 2 == 0:
        return calculate_max_m(n, nums)
    else:
        return max(nums[-1], calculate_max_m(n - 1, nums[:-1]))

# ----- 입력 & 출력 -----
n = int(input())
nums = list(map(int, input().split()))

print(solution(n, nums))