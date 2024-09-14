text = input()
add = []


total = 0
for temp1 in text.split('-'):
    total = 0
    for temp2 in temp1.split('+')  :
      total += int(temp2)
    add.append(total)

print(add[0] - sum(add[1:]))

