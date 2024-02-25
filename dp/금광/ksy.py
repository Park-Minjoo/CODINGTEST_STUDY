import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    nums = list(map(int, sys.stdin.readline().split()))
    graph = [nums[i * m : i * m + m] for i in range(n)]
    
    for i in range(1, m):
        for j in range(n):
            max_value = graph[j][i-1]
            if 0 <= j - 1:
                max_value = max(graph[j-1][i-1], max_value)
            
            if j + 1 < n:
                max_value = max(graph[j+1][i-1], max_value)
            
            graph[j][i] = graph[j][i] + max_value

    result = 0
    for i in range(n):
        result = max(result, graph[i][-1])   
                
    print(result)

'''
입력
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
출력
19
16
'''