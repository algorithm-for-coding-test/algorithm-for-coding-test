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
    N = int(input())
    nums = list(map(int, input().split()))
    nums.sort()
    M = int(input())
    answer = []
    for q in list(map(int, input().split())):
        answer.append(upper_bound(nums, 0, N - 1, q) - lower_bound(nums, 0, N - 1, q) + 1)
    print(" ".join(map(str, answer)))
    
if __name__ == "__main__":
    main()
