import sys

input = lambda: sys.stdin.readline().rstrip()

def test(tree, k):
    res = 0
    for height in tree:
        res += max(0, height - k)
    return res

def main():
    N, M = map(int, input().split())
    tree = list(map(int, input().split()))
    left = 0
    right = 2_000_000_000
    while left <= right:
        mid = (left + right) >> 1
        if test(tree, mid) >= M:
            left = mid + 1
        else:
            right = mid - 1
    print(left - 1)
        
    
if __name__ == "__main__":
    main()
