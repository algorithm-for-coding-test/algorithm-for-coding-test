import sys

input = lambda: sys.stdin.readline().rstrip()

N = -1
N2 = -1
S = None
answer = 9876543210


def calculate_ability_difference(visit):
    start = 0
    link = 0
    for i in range(N):
        for j in range(i + 1, N):
            if (visit & (1 << i)) > 0 and (visit & (1 << j)) > 0:
                start += S[i][j]
                start += S[j][i]
            elif (visit & (1 << i)) == 0 and (visit & (1 << j)) == 0:
                link += S[i][j]
                link += S[j][i]

    return abs(start - link)


def dfs(index, depth, visit):
    global answer
    if depth == N2:
        calculated = calculate_ability_difference(visit)
        answer = min(answer, calculated)
        return

    for i in range(index, N):
        if (visit & (1 << i)) > 0:
            continue
        dfs(i + 1, depth + 1, visit | (1 << i))


def main():
    global N, N2, S
    N = int(input())
    N2 = N >> 1
    S = [list(map(int, input().split())) for _ in range(N)]
    dfs(1, 1, 1)
    print(answer)


if __name__ == "__main__":
    main()
