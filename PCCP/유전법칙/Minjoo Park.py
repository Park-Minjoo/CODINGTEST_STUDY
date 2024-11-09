# 아.. 어렵다 ㅏ....
# 참고: https://programming4myself.tistory.com/88

def get_gene(pose):
    n, p = pose
    stack = []

    p -= 1
    while n > 1:
        stack.append(p%4)
        n -= 1
        p //= 4

    while len(stack) > 0:
        num = stack.pop()
        if num == 0: return 'RR'
        if num == 3: return 'rr'
    return 'Rr'

def solution(queries):
    return [*map(get_gene, queries)]