n, m = list(map(int, input().split()))
arr = list(map(int, input().split()))

start = arr[0]
end = arr[-1]
count  = 0
while start <= end:
    mid = (start + end) // 2
    if arr[mid] == m:
        count = arr.count(m)
    elif arr[mid] > m:
        end = mid - 1
    else:
        start = mid + 1
print(count)