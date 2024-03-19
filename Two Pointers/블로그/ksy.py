import sys

'''
문제: 블로그
분류: 누적합, 슬라이딩 윈도우, 투 포인터
메모리: 60556 KB
시간: 144 ms
'''

def calculate_interval_sum(total_days, x, visitor_nums):
    count = 0
    left_pointer = 0
    right_pointer = 0
    current_visitor_sum = 0
    max_visitor_nums = 0

    while right_pointer < total_days:
        current_visitor_sum += visitor_nums[right_pointer]
        window_size = right_pointer - left_pointer + 1

        if window_size < x:
            right_pointer += 1
            continue

        if window_size == x:
            if max_visitor_nums < current_visitor_sum:
                max_visitor_nums = current_visitor_sum
                count = 1
            elif max_visitor_nums == current_visitor_sum:
                count += 1

        current_visitor_sum -= visitor_nums[left_pointer]
        left_pointer += 1
        right_pointer += 1

    return max_visitor_nums, count

def solution(total_days, x, visitor_nums):
    max_visitor_nums, count = calculate_interval_sum(total_days, x, visitor_nums)
    if max_visitor_nums == 0:
        print("SAD")
        return

    print(max_visitor_nums)
    print(count)

# ---------- 입력 ---------------
total_days, x = map(int, sys.stdin.readline().split())
visitor_nums = list(map(int, sys.stdin.readline().split()))

solution(total_days, x, visitor_nums)
