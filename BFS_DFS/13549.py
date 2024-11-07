# [BOJ-Gold5] 13549_숨바꼭질3

from collections import deque


n, k = map(int, input().split())
limit = 100001

queue = deque()
visited = [False] * limit
time = [0] * limit

queue.append(n)
visited[n] = True

def bfs():
    while queue:
        x = queue.popleft()
        
        if x == k:
            break
        
        for i in (x*2, x+1, x-1):
            if (0 <= i < limit and not visited[i]):
                queue.append(i)
                visited[i] = True
                if (i == (2*x)):
                    time[i] = time[x]
                else:
                    time[i] = time[x] + 1

bfs()
print(time[k])        
