n = int(input())
total = 0

while True:
    if (n%5 ==0):
        total+=n//5
        break
    else:
        n=n-3
        total += 1
        
    if(n<0):
        total = -1
        break

print(total)
       