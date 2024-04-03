# Steps for updating data in a PostgreSQL table from Python

# 1. First, connect to the PostgreSQL server.
# 2. Next, create a cursor object from the connection object.
# 3. Then, execute an UPDATE statement by calling the 
#       execute() method of the cursor object.
# 4. After that, commit the changes by calling the commit() method 
#       of the connection object.
# 5. Finally, optionally obtain the number of updated rows 
#       from the rowcount property of the cursor object.