def bisect_left(array, target):
  left, right = 0, len(array)
  while left < right:
    mid = (left + right) // 2
    if array[mid] < target:
      left = mid +1
    else:
      right = mid
  return left

def bisect_right(array, target):
  left, right = 0, len(array)
  while left < right:
    mid = (left + right) // 2
    if array[mid] <= target:
      left = mid +1
    else:
      right = mid
  return right

n, m = map(int, input().split())
lists = list(map(int, input().split()))
lists.sort()
trials = []

for _ in range(m):
  trials.append(list(map(int, input().split())))

length = len(lists)
for trial in trials:
  if trial[0] == 1:
    print(length - bisect_left(lists, trial[1]))

  if trial[0] == 2:
    print(length - bisect_right(lists, trial[1]))

  if trial[0] == 3:
    print(bisect_right(lists,trial[2]) - bisect_left(lists, trial[1]))