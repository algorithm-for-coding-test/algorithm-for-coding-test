import sys

input = lambda: sys.stdin.readline().rstrip()


def generate_snail_array(r, c):
    graph = [[0] * c for _ in range(r)]
    top = 0
    bottom = r - 1
    left = 0
    right = c - 1
    index = 1
    n = r * c
    while index <= n:
        if index <= n:
            for i in range(bottom, top - 1, -1):
                graph[i][left] = index
                index += 1
            left += 1

        if index <= n:
            for j in range(left, right + 1):
                graph[top][j] = index
                index += 1
            top += 1

        if index <= n:
            for i in range(top, bottom + 1):
                graph[i][right] = index
                index += 1
            right -= 1

        if index <= n:
            for j in range(right, left - 1, -1):
                graph[bottom][j] = index
                index += 1
            bottom -= 1

    return graph


def main():
    C, R = map(int, input().split())
    K = int(input())

    if K > R * C:
        print(0)
    else:
        graph = generate_snail_array(R, C)
        answer = (-1, -1)
        for i in range(R):
            for j in range(C):
                if graph[i][j] == K:
                    answer = (j + 1, R - i)
                    i = R
                    break

        print(answer[0], answer[1])


if __name__ == "__main__":
    main()
