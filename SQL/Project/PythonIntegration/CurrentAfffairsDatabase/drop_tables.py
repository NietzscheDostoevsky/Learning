# ---------------------------------
# WARNING 
#----------------------------------
#
# CODE NOT COMPLETE AND NOT WORKING 
#
#----------------------------------


import psycopg2
from config import load_config


config = load_config()
conn = psycopg2.connect(**config) 
cur = conn.cursor()

# Get all the tables in the database
cur.execute("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'")

# Drop all the tables
for table in cur.fetchall():
    cur.execute("DROP TABLE IF EXISTS {}".format(table[0]))

# Commit the changes
conn.commit()

# Close the connection
conn.close()