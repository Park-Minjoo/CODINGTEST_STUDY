import sys

'''
문제: 전력난
분류: 그래프 이론, 최소 스패닝 트리
메모리: 59080 KB
시간: 2148 ms
'''

def find_parent(parents, node):
    if parents[node] != node:
        parents[node] = find_parent(parents, parents[node])
    return parents[node]

def union_parent(parents, node1, node2):
    node1 = find_parent(parents, node1)
    node2 = find_parent(parents, node2)

    if node1 < node2:
        parents[node2] = node1
    else:
        parents[node1] = node2

while True:
    m, n = map(int, sys.stdin.readline().split())
    if m == 0 or n == 0:
        break

    edges = []
    for _ in range(n):
        x, y, z = map(int, sys.stdin.readline().split())
        edges.append((z, x, y))

    edges.sort()
    parents = list(range(m))
    cost_sum = 0
    for edge in edges:
        cost, x, y = edge

        if find_parent(parents, x) != find_parent(parents, y):
            union_parent(parents, x, y)
        else:
            cost_sum += cost

    print(cost_sum)
