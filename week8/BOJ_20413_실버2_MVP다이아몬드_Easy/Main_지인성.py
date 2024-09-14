import sys
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
standards = list(map(int, input().split()))
grade = input()

prev = 0
answer = 0
paying = 0

for g in grade:
    if g == 'B':
        paying = standards[0] - prev - 1
    elif g == 'S':
        paying = standards[1] - prev - 1
    elif g == 'G':
        paying = standards[2] - prev - 1
    elif g == 'P':
        paying = standards[3] - prev - 1
    else:
        paying = standards[3]
    answer += paying
    prev = paying


print(answer)