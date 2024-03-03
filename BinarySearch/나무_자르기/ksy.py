import sys

'''
문제: 나무 자르기 (실버2)
분류: 이분 탐색
메모리: 150200 KB
시간: 2212 ms
'''

# 입력
n, m = map(int, sys.stdin.readline().split())
tree_heights = list(map(int, sys.stdin.readline().split()))

# 상근이가 얻어갈 수 있는 나무 높이 합 계산 메서드
def sum_tree_height(cut_height):
    global tree_heights
    sum = 0

    for tree_height in tree_heights:
        if cut_height < tree_height:
            sum += tree_height - cut_height
    return sum

# 이분 탐색 메서드
def binary_search(start, end, target):
    while start <= end:
        mid = (start + end) // 2
        sum_height = sum_tree_height(mid)

        if sum_height == target:
            return mid
    
        if sum_height < target:
            end = mid - 1

        if sum_height > target:
            start = mid + 1
    return end

# 탐색 범위
start = 0
end = max(tree_heights)

print(binary_search(start, end, m))