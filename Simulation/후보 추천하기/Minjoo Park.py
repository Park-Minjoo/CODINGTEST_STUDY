def solution():
    n = int(input())
    candidate = int(input())
    vote = list(map(int, input().split()))
    result = []
    cnt = []

    for i in vote:
        if i in result:
            cnt[result.index(i)] += 1
        else:
            if len(result) >= n:
                idx = cnt.index(min(cnt))
                del result[idx]
                del cnt[idx]
            result.append(i)
            cnt.append(1)

    result.sort()
    print(' '.join(map(str, result)))

solution()
'''
Input
3
9
2 1 4 3 5 6 2 7 2

Output
2 6 7
'''