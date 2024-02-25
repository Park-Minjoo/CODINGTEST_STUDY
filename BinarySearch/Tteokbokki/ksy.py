import sys

def checker(h):
    global lengths
    sum_length = 0
    for length in lengths:
        if 0 < length - h:
            sum_length += length - h
    return sum_length
    
n, m = map(int, sys.stdin.readline().split())
lengths = list(map(int, sys.stdin.readline().split()))

start = 0
end = max(lengths)

while start < end:
    mid = (start + end) // 2

    if m <= checker(mid):
        start = mid + 1
    else:
        end = mid - 1

print(start - 1)


'''
입력 
4 6
19 15 10 17

출력
15

입력 
4 3
5 7 6 3

출력
5
'''