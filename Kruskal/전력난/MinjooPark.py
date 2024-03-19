import sys
input = sys.stdin.readline

def find_parent(parent, x): # 특정 원소가 속한 집합
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b): # 두 원소가 속한 집합을 합치기
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b
while True:
    v, e = map(int, input().split())
    if v == 0 and e == 0:
        break

    parent = [i for i in range(e)]
    edges = []
    result = 0

    for _ in range(e): # 간선을 입력받음
        a, b, cost = map(int, input().split())
        edges.append((cost, a, b))
        result += cost # 모든 cost를 더해줌

    edges.sort() # cost를 중심으로 오름차순 정렬

    for edge in edges:
        cost, a, b = edge
        if find_parent(parent, a) != find_parent(parent, b):
            # 다르면 사이클 x
            union_parent(parent, a, b)
            result -= cost # 연결된 것을 빼줌

    print(result)


'''
입력
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
0 0

출력
51
'''