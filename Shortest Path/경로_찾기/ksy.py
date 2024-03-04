import sys

'''
문제: 경로 찾기 (실버 1)
분류: 최단 경로
메모리: 31120 KB
시간: 344 ms
'''

n = int(sys.stdin.readline())
graph = [sys.stdin.readline().split() for _ in range(n)]

for k in range(n):
    for i in range(n):
        for j in range(n):
                if 0 < int(graph[i][j]) or 1 < int(graph[i][k]) + int(graph[k][j]):
                     graph[i][j] = '1'

for line in graph:
     print(" ".join(line))