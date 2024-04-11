import sys

'''
문제: 탑
'''

input = sys.stdin.readline

def solution(n, tops):
    stack = []
    result = []

    for i in range(n):
        current = tops[i]

        while stack:
            lastIndex = stack[-1]
            if current <= tops[lastIndex]:  # 스택의 마지막 값 높이가 나보다 크면
                result.append(lastIndex + 1)
                break
            stack.pop()

        if not stack: # 스택이 비어있으면(앞에 나보다 높은 탑이 없으면)
            result.append(0)

        stack.append(i) # 다음 비교를 위해

    return ' '.join(map(str, result))

# ----- 입력 & 출력 -----
n = int(input())
tops = list(map(int, input().split()))

print(solution(n, tops))