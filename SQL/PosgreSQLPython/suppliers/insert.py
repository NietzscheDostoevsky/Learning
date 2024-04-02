# -------------------------------------------------------------------------------------
# Steps for inserting one row into a table from Python
# To insert one or more rows into a table from Python,
# follow these steps:
#
# 1. First, connect to the PostgreSQL server.
# 2. Next, create a cursor object from the connection object.
# 3. Then, execute the INSERT statement with values by calling 
#       the execute() or executemany() method of the cursor object.
# 4. After that, commit the transaction by calling the commit() 
#       method of the connection object.
# 5. Finally, obtain the inserted ID by calling the fetchone() method of the cursor object.
#
# --------------------------------------------------------------------------------------

