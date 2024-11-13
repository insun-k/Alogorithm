# [BOJ-Silver2] 1260_DFS와 BFS

from collections import deque

n, m, v = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    
# 정점 번호가 작은 순으로 방문
for i in graph:
    i.sort()
    
visited1 = [False] * (n+1)
visited2 = [False] * (n+1) 
    
# BFS    
def bfs(v):
   visited1[v] = True    
   queue = deque([v])
   
   while queue:
       x = queue.popleft()
       print(x, end=' ')
       
       for i in graph[x]:
            if not visited1[i]:
                visited1[i] = True
                queue.append(i)
                

# DFS
def dfs(v):
    visited2[v] = True
    print(v, end=' ')
    
    for i in graph[v]:
        if not visited2[i]:
            dfs(i)

dfs(v)
print()
bfs(v)