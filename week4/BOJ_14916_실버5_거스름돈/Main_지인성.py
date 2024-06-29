import sys
input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**5)

n = int(input())
DP = [100001] * (n + 1)

# 기본 경우 초기화
DP[0] = 0
DP[1] = 100001
if n >= 2:
    DP[2] = 1
if n >= 3:
    DP[3] = 100001
if n >= 4:
    DP[4] = 2
if n >= 5:
    DP[5] = 1

def solution(k):
    if k < 1:
        return 100001  

    if DP[k] != 100001:
        return DP[k]

    DP[k] = min(solution(k - 2) + 1, solution(k - 5) + 1)

    return DP[k]

result = solution(n)
print(result if result < 100001 else -1)