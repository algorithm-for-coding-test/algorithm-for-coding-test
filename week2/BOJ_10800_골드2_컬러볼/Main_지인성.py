import sys
from collections import defaultdict 

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
balls = []

for i in range(N):
    color, size = map(int, input().split())
    balls.append([i, color, size])

# 크기 순서대로 정렬
balls.sort(key=lambda x: x[2])

# 누적합과 색깔별 누적합 초기화
s = 0
j = 0
color = defaultdict(int)
answer = [0] * N

for i in range(N):
    leftball = balls[i]

    while balls[j][2] < leftball[2]:
        rightball = balls[j]
        s += rightball[2]
        color[rightball[1]] += rightball[2]
        j += 1

    answer[leftball[0]] = s - color[leftball[1]]

print("\n".join(map(str, answer)))