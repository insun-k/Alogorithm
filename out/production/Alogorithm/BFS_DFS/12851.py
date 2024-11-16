# [BOJ-Gold4] 12851_숨바꼭질 2

from collections import deque


n, k = map(int, input().split())
limit = 100001

queue = deque([n])
visited = [-1] * limit

visited[n] = 0
result = 0

while queue:
    x = queue.popleft()
    
    if x == k:
        result += 1
        
    for i in (x + 1, x - 1, 2 * x):
        if 0 <= i < limit and (visited[i] == -1 or visited[i] == visited[x] + 1):
            queue.append(i)
            visited[i] = visited[x] + 1
            

print(visited[k])
print(result)