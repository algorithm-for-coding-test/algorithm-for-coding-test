import sys 
import copy 
input = lambda : sys.stdin.readline().rstrip()
alphabet = "abcdefghijklmnopqrstuvwxyz"
database = [[0] * 26]

S = input()
q = int(input())
questions = []
for _ in range(q):
  questions.append(list(input().split()))

for (index, alpha) in enumerate(S):
  idx = alphabet.find(alpha)
  dblist = copy.deepcopy(database[index])
  dblist[idx] += 1
  database.append(dblist)

for alpha, i, j in questions:
  idx = alphabet.find(alpha)
  print(database[int(j)+1][idx] - database[int(i)][idx])
  