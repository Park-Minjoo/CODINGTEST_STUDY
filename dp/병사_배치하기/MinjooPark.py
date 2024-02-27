n = int(input())
arr = list(map(int, input().split()))
arr.reverse()
d = [1] * n

for i in range(1, n):
    for j in range(0, i):
        if arr[j] < arr[i]:
            d[i] = max(d[i], d[j] + 1)
# print(d)
print(n - max(d))

'''
7
15 11 4 8 5 2 4

reverse()
4 2 5 8 4 11 15
'''