import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, d, k, c = map(int, input().split())
    belt = []
    for _ in range(N):
        belt.append(int(input()))

    belt += belt[:k]

    N = len(belt)

    counter = defaultdict(int)
    for i in range(k):
        counter[belt[i]] += 1

    answer = len(counter)
    if c not in counter:
        answer += 1

    for i in range(k, N):
        counter[belt[i]] += 1
        counter[belt[i - k]] -= 1
        if counter[belt[i - k]] == 0:
            del counter[belt[i - k]]

        answer = max(answer, len(counter) if c in counter else len(counter) + 1)

    print(answer)


if __name__ == "__main__":
    main()
