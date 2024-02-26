import sys
n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

sorted_arr = sorted(arr)
end = sorted_arr[n-1] # 19
start = sorted_arr[0]


for i in range(end - 1, start, -1):
    count = 0
    for j in range(len(sorted_arr)):
        if sorted_arr[j] - i >= 0:
            count += sorted_arr[j] - i
    if count == m:
        break
print(i)

