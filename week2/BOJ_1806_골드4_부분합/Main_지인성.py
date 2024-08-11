import sys 
input = lambda: sys.stdin.readline().rstrip()
N, S = map(int, input().split())
numbers = list(map(int, input().split()))

i, j = 0, 0
current_sum = 0
answer = float('inf')

while j < N:
    current_sum += numbers[j]
    j += 1

    while current_sum >= S:
        answer = min(answer, j - i)
        current_sum -= numbers[i]
        i += 1

print(answer if answer != float('inf') else 0)