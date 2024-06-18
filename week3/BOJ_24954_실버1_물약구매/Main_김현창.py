import sys

input = lambda: sys.stdin.readline().rstrip()

N = -1
c = None
sales = None


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


def simulate(order):
    total_cost = 0
    c_copied = c.copy()
    for o in order:
        total_cost += c_copied[o]
        for index, sale_price in sales[o]:
            c_copied[index] = max(1, c_copied[index] - sale_price)
    return total_cost


def main():
    global N, c, sales
    N = int(input())
    c = list(map(int, input().split()))
    c.insert(0, 0)

    sales = [[] for _ in range(N + 1)]
    for i in range(1, N + 1):
        p = int(input())
        for j in range(p):
            sales[i].append(tuple(map(int, input().split())))

    answer = 9876543210
    perm = [i for i in range(1, N + 1)]
    while True:
        answer = min(answer, simulate(perm))
        if next_permutation(perm, N) == False:
            break

    print(answer)


if __name__ == "__main__":
    main()
