import sys

# 입력
n = int(sys.stdin.readline())
pair_counts = int(sys.stdin.readline())

graph = [[] for _ in range(n + 1)]

for _ in range(pair_counts):
    computer1, computer2 = map(int, sys.stdin.readline().split())
    graph[computer1].append(computer2)
    graph[computer2].append(computer1)


count = 0
def dfs(visited, current_node):
    global graph, count
    visited[current_node] = True
    count += 1

    for node in graph[current_node]:
        if not visited[node]:
            dfs(visited, node)

visited = [False] * (n + 1)
dfs(visited, 1)

print(count - 1)