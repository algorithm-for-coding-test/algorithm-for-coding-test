from bisect import bisect_left 

import sys
import copy
input = lambda : sys.stdin.readline().rstrip()

N = int(input())

lists = list(map(int, input().split()))
copylist = list(set(lists))
copylist.sort()

for value in lists:
  print(bisect_left(copylist, value))
print(" ")