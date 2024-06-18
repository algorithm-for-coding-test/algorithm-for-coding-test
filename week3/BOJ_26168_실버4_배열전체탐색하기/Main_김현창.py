import sys

input = lambda: sys.stdin.readline().rstrip()

def lower_bound(nums, left, right, value):
    while left <= right:
        mid = (left + right) >> 1
        if nums[mid] >= value:
            right = mid - 1
        else:
            left = mid + 1
    return right + 1

def upper_bound(nums, left, right, value):
    while left <= right:
        mid = (left + right) >> 1
        if nums[mid] > value:
            right = mid - 1
        else:
            left = mid + 1
    return left - 1

def main():
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    A.sort()
    answer = []
    for _ in range(m):
        c, *i = map(int, input().split())
        if (c == 1):
            answer.append(n - lower_bound(A, 0, n - 1, i[0]))
        elif c == 2:
            answer.append(n - upper_bound(A, 0, n - 1, i[0]) - 1)
        else:
            answer.append(upper_bound(A, 0, n - 1, i[1]) - lower_bound(A, 0, n - 1, i[0]) + 1)
    
    print("\n".join(map(str, answer)))
    
if __name__ == "__main__":
    main()
