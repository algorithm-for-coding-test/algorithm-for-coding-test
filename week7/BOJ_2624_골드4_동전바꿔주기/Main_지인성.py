import sys
input = lambda: sys.stdin.readline().rstrip()


T = int(input())
k = int(input())
coins = []
for _ in range(k):
    p, n = map(int, input().split())
    coins.append((p,n))

DP = [0] * 10001
DP[0] = 1

for c, n in coins:
    for m in range(T, 0, -1):
        for i in range(1, n+1):
            if m - c*i >= 0:
                DP[m] += DP[m-c*i]
print(DP[T])