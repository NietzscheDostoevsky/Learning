def largest_connected_component(grid):
    if not grid or not grid[0]:
        return 0

    m, n = len(grid), len(grid[0])
    visited = [[False for _ in range(n)] for _ in range(m)]

    def dfs(x, y):
        if x < 0 or x >= m or y < 0 or y >= n or grid[x][y] == 0 or visited[x][y]:
            return 0
        
        visited[x][y] = True
        size = 1

        for dx, dy in [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]:
            size += dfs(x + dx, y + dy)
        
        return size

    max_size = 0
    for i in range(m):
        for j in range(n):
            if grid[i][j] == 1 and not visited[i][j]:
                max_size = max(max_size, dfs(i, j))

    return max_size

# Example usage:
grid = [
    [1, 0, 0, 1],
    [1, 0, 0, 0],
    [1, 1, 0, 1],
    [0, 0, 1, 0]
]

print(largest_connected_component(grid))  # Output: 6
