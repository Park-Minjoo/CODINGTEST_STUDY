# 참고: https://seongonion.tistory.com/115
import sys
input = sys.stdin.readline

h, w = map(int, input().split())
arr = list(map(int, input().split()))

ans = 0
for i in range(1, w-1): # arr[i]에 담긴 물
    left_max = max(arr[:i])
    right_max = max(arr[i+1:])
    # print(arr[:i], arr[i+1:])

    compare = min(left_max, right_max)
    # print('min: ', compare)
    if arr[i] < compare:
        ans += compare - arr[i]
        # print(compare - arr[i])
print(ans)
'''
Input1
4 4
3 0 1 4
Output1
5

Input2
4 8
3 1 2 3 4 1 1 2
Output2
5

Input3
3 5
0 0 0 2 0
Output3
0

'''