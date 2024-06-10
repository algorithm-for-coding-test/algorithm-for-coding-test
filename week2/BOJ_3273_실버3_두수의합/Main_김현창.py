import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    counter = [0] * 1000001
    a = list(map(int, input().split()))
    x = int(input())

    for v in a:
        counter[v] += 1

    a = list(set(a))
    a.sort()

    left = 0
    right = len(a) - 1
    answer = 0
    while left < right:
        temp = a[left] + a[right]
        if temp == x:
            answer += counter[a[right]] * counter[a[left]]
        if temp > x:
            right -= 1
        else:
            left += 1

    if x & 1 == 0:
        answer += (counter[x >> 1] * counter[(x >> 1) - 1]) >> 1

    print(answer)


if __name__ == "__main__":
    main()
