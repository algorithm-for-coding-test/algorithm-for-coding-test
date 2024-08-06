import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())

    five = N // 5 + 1
    three = 0
    while five >= 0 and 5 * five + 3 * three != N:
        five -= 1
        while five >= 0 and 5 * five + 3 * three < N:
            three += 1

    print(three + five if five >= 0 else -1)


if __name__ == "__main__":
    main()
