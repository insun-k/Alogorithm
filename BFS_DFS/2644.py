# [BOJ-Silver2] 2644_촌수계산

n = int(input())
a, b = map(int, input().split())
m = int(input())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
  x, y = map(int, input().split())
  graph[x].append(y)
  graph[y].append(x)

visited = [-1] * (n + 1)


def dfs(x):
  for i in graph[x]:
    if i == x:
      return

    if visited[i] == -1:
      visited[i] = visited[x] + 1
      dfs(i)


visited[b] = 0
dfs(b)
print(visited[a])
