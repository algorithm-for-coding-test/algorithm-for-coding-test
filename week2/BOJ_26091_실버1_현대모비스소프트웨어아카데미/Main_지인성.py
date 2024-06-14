import sys
input = lambda: sys.stdin.readline().rstrip()
N, M = map(int, input().split())
members = list(map(int, input().split()))
answer = 0
i = 0
j = N-1

members.sort()

while i < j:
  if (members[i] + members[j]) >= M:
    answer +=1
    i+=1
    j-=1
  else:
    i+=1
print(answer)