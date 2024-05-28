from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
g = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    g[b].append(a)

def bfs(start):
    q = deque()
    q.append(start)
    # print(q)
    cnt = 0
    visited = [0] * (n+1)
    visited[start] = 1
    # print(visited)
    while q:
        # print(q)
        cur = q.popleft()
        for next in g[cur]:
            # print(next)
            if not visited[next]:
                visited[next] = 1
                q.append(next)
                cnt += 1
                # print(visited, q, cnt)
    return cnt

res = []
for start in range(1, len(g)):
    # print('start:', start)
    res.append(bfs(start))
    # print(res)

for i in range(len(res)):
    if max(res) == res[i]:
        print(i+1, end=" ")
'''
Input
5 4
3 1
3 2
4 3
5 3

Output
1 2
'''
