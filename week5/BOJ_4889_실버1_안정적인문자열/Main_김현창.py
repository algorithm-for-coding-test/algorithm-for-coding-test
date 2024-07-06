import sys

input = lambda: sys.stdin.readline().rstrip()


def solution(string):
    open_bracket = 0
    answer = 0
    for char in string:
        if char == "}":
            if open_bracket:
                open_bracket -= 1
            else:
                open_bracket += 1
                answer += 1
        else:
            if char == "{":
                open_bracket += 1

    answer += open_bracket >> 1
    return answer


def solution2(string):
    stack = []
    answer = 0
    for char in string:
        if char == "}":
            if stack:
                stack.pop()
            else:
                stack.append("{")
                answer += 1
        else:
            if char == "{":
                stack.append("{")

    answer += len(stack) >> 1
    return answer


def main():
    tc = 1
    while True:
        string = input()
        if string[0] == "-":
            break
        print(str(tc) + ". " + str(solution(string)), sep="")
        tc += 1


if __name__ == "__main__":
    main()
