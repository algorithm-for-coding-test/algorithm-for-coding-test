import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
colors = list(input())

color_dict = {'R' : 0, 'B' : 0}
previous = ''

answer = 0
for color in colors:
    if color != previous:
        color_dict[color] += 1
    previous = color

print(color_dict['R'] + 1 if color_dict['B'] >= color_dict['R'] else color_dict['B']+1)