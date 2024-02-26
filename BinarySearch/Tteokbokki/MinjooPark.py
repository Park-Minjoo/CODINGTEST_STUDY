n, m = list(map(int, input().split(' ')))
arr = list(map(int, input().split()))

end = max(arr) # 19
start = 0 # 10


result = 0
while start <= end:
    count = 0
    mid = (end + start) // 2

    for i in arr:
        if i > mid:
            count += i - mid
    if count < m:
        end = mid - 1
    else:
        result = mid
        start = mid + 1

print(result)