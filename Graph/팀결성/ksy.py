import sys

'''
문제: 팀 결성
'''

def find_team(parents, node):
    if parents[node] != node:
        parents[node] = find_team(parents, parents[node])
    return parents[node]

def union_team(parents, node1, node2):
    node1 = find_team(parents, node1)
    node2 = find_team(parents, node2)
    team = min(node1, node2)
    parents[node1] = team
    parents[node2] = team

def is_same_team(parents, a, b):
    return find_team(parents, a) == find_team(parents, b)

n, m = map(int, sys.stdin.readline().split())
parents = [0] * (n + 1)

for i in range(n + 1):
    parents[i] = i

for _ in range(m):
    command, a, b = map(int, sys.stdin.readline().split())
    
    if command == 0:
        union_team(parents, a, b)
        continue
    
    if command == 1:
        if is_same_team(parents, a, b):
            print("YES")
        else:
            print("NO")

'''
입력
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

출력
NO
NO
YES
'''