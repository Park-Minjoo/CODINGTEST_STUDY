# 참고
# https://cobokjang.tistory.com/18
# https://hseungyeon.tistory.com/354

# 시간 초과 이슈로 브루트 포스 사용 불가
# 중복을 제거해야 함.
# 재귀 함수 사용
# 아직 완전히 정복 못함...

import sys
input = sys.stdin.readline

n, w = int(input()), list(map(int, input().split()))
m, b = int(input()), list(map(int, input().split()))

# dp[사용한 추의 개수][추의 무게 차이]
dp = [[0 for _ in range((500 * j)+1)] for j in range(n+1)]
ans = []

def cal(num, weight): # 추로 판별할 수 있는 구슬의 무게를 나타내는 함수
    if num > n: # 사용할 수 있는 추의 개수를 넘어가면 종료
        return
    if dp[num][weight] == 1: # 이미 같은 추의 무게와 개수로 방문했다면 종료
        return
    dp[num][weight] = 1

    # 3가지 경우 수행
    cal(num+1, weight + w[num-1]) # 추의 무게를 더함, 오른쪽에 추를 올리는 경우 (구슬의 무게 = weight + w)
    cal(num+1, weight) # 추를 사용하지 않음 (구슬의 무게 = weight)
    cal(num+1, abs(weight - w[num-1])) # 왼쪽에 추를 올리는 경우 (구슬의 무게 = abs(weight-w))

cal(0,0)

for bead in b:
    if bead > 500 * n:
        ans.append('N')
    elif dp[n][bead] == 1:
        ans.append('Y')
    else:
        ans.append('N')
print(*ans)

'''
Input
2
1 4
2
3 2

Output
Y N

Input2
4
2 3 3 3
3
1 4 10

Output2
Y Y N
'''