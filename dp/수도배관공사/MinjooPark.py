import sys
input = sys.stdin.readline

# https://ddiyeon.tistory.com/63
# 수도관의 용량은 그것을 이루는 파이프들의 용량(C) 중 최솟값 (min)
# 수도관의 길이는 파이프들 길이(L)의 총합(sum)
# 수도관을 한 개 만들어 총 길이가 정확히 D와 같도록
d, p = map(int, input().split())
# 1. 길이마다 파이프 최대용량 저장할 일차원 배열 dp생성
dp = [1e9] + [0]*d

# 2. 파이프 순서대로 돌면서
# dp[i] = max(i길이의 파이프용량,
#               min(현재파이프 l을 추가하기 전 i-l길이의 파이프용량, 현재파이프 l의 용량))
#         수행하며 배열의 파이프 최대용량 갱신
for _ in range(p):
    l, c = map(int, input().split())
    dp_max = dp.copy()
    for i in range(l, d+1):
        print('i', i)
        if dp_max[i-l]:
            dp[i] = max(dp[i], min(dp_max[i-l], c))
            # print('i:', i, 'i-l:', i-l)
            # print('dp:', dp, 'dp_max:', dp_max)

# 3. d 길이의 파이프 최대용량 출력
print(dp[d])

'''
Input
7 6
4 5
3 6
2 7
1 4
6 7
1 5

Output
5
'''