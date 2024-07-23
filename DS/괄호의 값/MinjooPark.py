# 참고: https://velog.io/@rhdmstj17/%EB%B0%B1%EC%A4%80-2504%EB%B2%88-%EA%B4%84%ED%98%B8%EC%9D%98-%EA%B0%92-python-stack-%EC%9E%90%EC%84%B8%ED%95%9C-%ED%92%80%EC%9D%B4

import sys
input = sys.stdin.readline

arr = input()
stack = []

answer = 0
tmp = 1
for i in range(len(arr)):
    if arr[i] == '(':
        stack.append(arr[i])
        tmp *= 2
    elif arr[i] == '[':
        stack.append(arr[i])
        tmp *= 3
    elif arr[i] == ")":
        if not stack or stack[-1] == "[":
            answer = 0
            break
        if arr[i-1] == "(":
            answer += tmp
        stack.pop()
        tmp //= 2
    else:
        if not stack or stack[-1] == "(":
            answer = 0
            break
        if arr[i-1] == "[":
            answer += tmp
        stack.pop()
        tmp //= 3

if stack:
    print(0)
else:
    print(answer)

'''
Input
(()[[]])([])
Output
28

Input
[][]((])
Output
0
'''