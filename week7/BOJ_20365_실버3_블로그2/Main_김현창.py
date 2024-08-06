import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    color = list(input())

    blue = 0
    red = 0

    i = 0
    j = 0
    while i < N:
        j = i
        while j < N and color[i] == color[j]:
            j += 1

        j -= 1
        if color[i] == "B":
            blue += 1
        else:
            red += 1
        i = j + 1

    print(min(blue, red) + 1)


if __name__ == "__main__":
    main()
