import sys

'''
문제: 도시 분할 계획
'''

def find_parent(parents, node):
    if parents[node] != node:
        parents[node] = find_parent(parents, parents[node])
    return parents[node]

def union_parent(parents, node1, node2):
    node1_parent = find_parent(parents, node1)
    node2_parent = find_parent(parents, node2)
    parent = min(node1_parent, node2_parent)
    parents[node1_parent] = parent
    parents[node2_parent] = parent

n, m = map(int, sys.stdin.readline().split())

# edges = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]
# edges.sort(key= lambda edge: edge[2]) 
# 왜 이 코드는 안 되는거지..?_?

edges = []
for _ in range(m):
    home_a, home_b, cost = map(int, sys.stdin.readline().split())
    edges.append((cost, home_a, home_b))

edges.sort()

parents = [i for i in range(n + 1)]
final_cost = 0
max_cost = 0

for edge in edges:
    cost, home_a, home_b = edge
    
    if find_parent(parents, home_a) != find_parent(parents, home_b):
        union_parent(parents, home_a, home_b)
        final_cost += cost
        max_cost = cost
        
print(final_cost - max_cost)

'''
입력
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4

출력
8
'''