import math

# Coordinates
x = [5, 2, 6, 8, 1]
y = [3, 6, 2, 1, 5]

# Number of nearest points to find
k = 3

# List to store distances and corresponding points
distances = []

# Calculate distances from the origin and store in the list
# for i in range(len(x)):
#     dis = x[i] * x[i] + y[i] * y[i]  # Squared distance to avoid unnecessary square root
#     dis = math.sqrt(dis)
#     distances.append((dis, (x[i], y[i])))

for i in range(len(x)):
    dis = abs(x[i]) + abs(y[i])  # Manhattan distance
    distances.append((dis, (x[i], y[i])))

# Sort the list by distances
distances.sort(key=lambda point: point[0])

# Get the nearest k points
return_list = [point[1] for point in distances[:k]]

# Print the results
print(return_list)
