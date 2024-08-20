import sys
from collections import defaultdict 

input = lambda: sys.stdin.readline().rstrip()

S = input()
length = len(S)

nums = [1 if pa == '(' else -1 for pa in S]

# 누적합
for i in range(1, length):
    nums[i] += nums[i - 1]

if nums[-1] == -1:
    index = length - 1
    for i in range(length):
        if nums[i] == -1:
            index = i
            break

    answer = 0
    
    for i in range(index, -1, -1):
        if S[i] == ')':
            answer += 1
    print(answer)
else:
    index = 0
    for i in range(length - 1, -1, -1):
        if nums[i] == 0:
            index = i
            break

    answer = 0
    for i in range(index, length):
        if S[i] == '(':
            answer += 1
    print(answer)


