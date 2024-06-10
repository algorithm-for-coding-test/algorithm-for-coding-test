import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().rstrip()


def solution(m, sentense):
    counter = defaultdict(int)
    result = 0
    left = 0
    for right in range(len(sentense)):
        counter[sentense[right]] += 1

        while len(counter) > m:
            counter[sentense[left]] -= 1
            if counter[sentense[left]] == 0:
                del counter[sentense[left]]
            left += 1

        result = max(result, right - left + 1)

    return result


def main():
    while True:
        m = int(input())

        if m == 0:
            break

        sentense = input()
        print(solution(m, sentense))


if __name__ == "__main__":
    main()
