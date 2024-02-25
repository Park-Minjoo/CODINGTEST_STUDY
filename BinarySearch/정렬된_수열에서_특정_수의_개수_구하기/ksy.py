import sys

def lower_bound(target):
    global nums
    start = 0
    end = len(nums)

    while start < end:
        mid = (start + end) // 2

        if target <= nums[mid]:
            end = mid
        else:
            start = mid + 1
    
    return start

def upper_bound(target):
    global nums
    start = 0
    end = len(nums)

    while start < end:
        mid = (start + end) // 2

        if nums[mid] <= target:
            start = mid + 1
        else:
            end = mid
    
    return start

n, x = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
lower = lower_bound(x)
upper = upper_bound(x)

if lower < upper:
    print(upper - lower)
else:
    print(-1)

'''
입력
7 2
1 1 2 2 2 2 3

출력
4

입력
7 2
1 1 1 1 1 1 2

출력
1

입력
7 2
1 1 1 1 3 3 3

출력
-1
'''
