import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, K = map(int, input().split())
    temperature = list(map(int, input().split()))
    summation = sum(temperature[0:K])
    answer = summation

    for i in range(K, N):
        summation += temperature[i]
        summation -= temperature[i - K]
        answer = max(answer, summation)

    print(answer)


if __name__ == "__main__":
    main()
