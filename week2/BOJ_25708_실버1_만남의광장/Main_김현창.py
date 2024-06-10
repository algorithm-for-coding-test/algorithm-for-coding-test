import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())
    d = [list(map(int, input().split())) for _ in range(N)]

    horizSum = []
    vertiSum = []

    for i in range(N):
        horizSum.append(sum(d[i]))

    for j in range(M):
        summation = 0
        for i in range(N):
            summation += d[i][j]
        vertiSum.append(summation)

    answer = -987654321
    for x1 in range(N):
        for x2 in range(x1 + 1, N):
            for y1 in range(M):
                for y2 in range(y1 + 1, M):
                    beauty = horizSum[x1] + horizSum[x2] + vertiSum[y1] + vertiSum[y2]
                    beauty -= d[x1][y1] + d[x1][y2] + d[x2][y1] + d[x2][y2]
                    beauty += (y2 - y1 - 1) * (x2 - x1 - 1)
                    answer = max(answer, beauty)

    print(answer)


if __name__ == "__main__":
    main()
