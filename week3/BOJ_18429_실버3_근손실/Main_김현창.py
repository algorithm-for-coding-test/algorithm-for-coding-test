import sys

input = lambda: sys.stdin.readline().rstrip()


def next_permutation(perm, n):
    i = n - 1
    while perm[i - 1] >= perm[i]:
        i -= 1

    if i == 0:
        return False

    j = n - 1
    while perm[i - 1] >= perm[j]:
        j -= 1

    perm[i - 1], perm[j] = perm[j], perm[i - 1]

    k = n - 1
    while i < k:
        perm[i], perm[k] = perm[k], perm[i]
        i += 1
        k -= 1

    return True


def simulate(n, k, arr, order):
    weight = 500
    for o in order:
        weight += arr[o]
        weight -= k
        if weight < 500:
            return False
    return True


def main():
    N, K = map(int, input().split())
    A = list(map(int, input().split()))
    perm = [i for i in range(N)]
    answer = 0
    while True:
        answer += int(simulate(N, K, A, perm))
        if next_permutation(perm, N) == False:
            break

    print(answer)


if __name__ == "__main__":
    main()
