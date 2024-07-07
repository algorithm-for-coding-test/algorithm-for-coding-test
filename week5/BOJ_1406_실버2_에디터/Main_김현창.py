import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    string = input()
    N = len(string)
    M = int(input())
    lefthand = list(string)
    righthand = []
    for _ in range(M):
        cmd, *x = input().split()
        if cmd == "L":
            if lefthand:
                righthand.append(lefthand.pop())
        elif cmd == "D":
            if righthand:
                lefthand.append(righthand.pop())
        elif cmd == "B":
            if lefthand:
                lefthand.pop()
        elif cmd == "P":
            lefthand.append(x[0])

    print("".join(lefthand) + "".join(reversed(righthand)))


if __name__ == "__main__":
    main()
