n = int(input())
len = list(map(int, input().split()))
costs = list(map(int, input().split()))
total = costs[0] * len[0] # 처음은 무조건 가야하므로.
min = costs[0] # 최솟값은 초기값으로 세팅
dist = 0 # 가야할 거리 계산

for i in range(1, n-1):
    if costs[i] < min: # 비용이 최솟값보다 작을 때
        total += min * dist # 그 전 최솟값과 길이를 곱해줌
        dist = len[i] # i번째 길이로 초기화
        min = costs[i] # 최솟값으로 교체
    else:
        dist += len[i] # 최솟값일때, dist에 거리 더해줌
    if i == n-2:
        total += min * dist # 계속 최솟값일때 거리 곱해주기

print(total)