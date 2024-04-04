import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
q = deque(enumerate(map(int, input().split())))
ans = []

while q:

    idx, paper = q.popleft()
    # print(q, -(paper-1))
    ans.append(idx + 1)

    if paper > 0:
        q.rotate(-(paper - 1))
        # print("+", q)
    else:
        q.rotate(-paper)
        # print("-", q)
print(' '.join(map(str, ans)))

'''
Input
5
3 2 1 -3 -1

Output
1 4 5 3 2
'''