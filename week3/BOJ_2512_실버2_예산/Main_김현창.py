import sys

input = lambda: sys.stdin.readline().rstrip()

def test(budget, k):
    res = 0
    for x in budget:
        res += min(x, k)
    return res

def main():
    N = int(input())
    budget = list(map(int, input().split()))
    M = int(input())
    
    left = N
    right = max(budget)
    while left <= right:
        mid = (left + right) >> 1
        if test(budget, mid) <= M:
            left = mid + 1
        else:
            right = mid - 1
    
    print(right)        
    
if __name__ == "__main__":
    main()
