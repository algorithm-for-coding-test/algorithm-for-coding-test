import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    T = int(input())

    for _ in range(T):
        N = int(input())
        stock = list(map(int, input().split()))

        answer = 0
        while stock:
            high = stock.pop()
            earn = 0
            cost = 0
            while stock and stock[-1] <= high:
                cost += stock.pop()
                earn += high
            answer += earn - cost

        print(answer)


if __name__ == "__main__":
    main()
