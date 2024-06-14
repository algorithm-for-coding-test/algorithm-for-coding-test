import sys
input = lambda: sys.stdin.readline().rstrip()
N, K = map(int, input().split())
numbers = list(map(int, input().split()))

answer = 0
counts = sum(numbers[0:K])
answer = counts

for i in range(K, N):
  counts += numbers[i] - numbers[i-K]
  answer = max(answer, counts)

print(answer)
  