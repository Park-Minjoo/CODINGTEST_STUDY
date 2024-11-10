from itertools import permutations
def solution(ability):
    ans = 0

    p = list(permutations(ability, len(ability[0])))

    for i in range(len(p)):
        total = 0
        for j in range(len(p[i])):
            total += p[i][j][j]
        ans = max(ans, total)
    return ans