import sys
input = sys.stdin.readline

n, k = map(int, input().split())
numbers = [0] * 1000001 # 얼음 양동이
end = 0
for _ in range(n):
    g, x = map(int, input().split())
    numbers[x] = g
    end = max(end, x) # 얼음 양동이의 위치의 최대값

step = 2*k + 1
window = sum(numbers[:step])
answer = window

for i in range(step, end+1):
    window += (numbers[i] - numbers[i-step])
    answer = max(answer, window)
print(answer)

'''
Input
4 3
4 7
10 15
2 2
5 1

Output
11
'''