import sys
input = lambda: sys.stdin.readline().rstrip()
N, K = map(int, input().split())
w_list = [0]
v_list = [0]

for _ in range(N):
    w, v = map(int, input().split())
    w_list.append(w)
    v_list.append(v)

dp = [[0] * (K + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    for W in range(K + 1):
        if w_list[i] <= W:
            dp[i][W] = max(dp[i-1][W], dp[i-1][W-w_list[i]] + v_list[i])
        else:
            dp[i][W] = dp[i-1][W]

print(dp[N][K])