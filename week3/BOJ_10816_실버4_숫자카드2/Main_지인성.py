def bisect_left(array, target):
    left, right = 0, len(array)
    while left < right:
        mid = (left + right) // 2
        if array[mid] < target:
            left = mid + 1
        else:
            right = mid
    return left


def bisect_right(array, target):
    left, right = 0, len(array)
    while left < right:
        mid = (left + right) // 2
        if array[mid] <= target:
            left = mid + 1
        else:
            right = mid
    return right


N = int(input())
lists = list(map(int, input().split()))
lists.sort()

M = int(input())
trials = list(map(int, input().split()))

for target in trials:
  print(bisect_right(lists, target) - bisect_left(lists, target), end=' ')
print(' ')
