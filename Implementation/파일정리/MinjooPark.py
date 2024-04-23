import sys
input = sys.stdin.readline

n = int(input())
files = dict()

for _ in range(n):
    extend = (input().split('.'))[1]
    if not extend in files:
        files[extend] = 1
    else:
        files[extend] += 1

s_files = sorted(files.items())

for key, value in s_files:
    print(key.rstrip(), value)

'''
Input
8
sbrus.txt
spc.spc
acm.icpc
korea.icpc
sample.txt
hello.world
sogang.spc
example.txt

Output
icpc 2
spc 2
txt 3
world 1

'''