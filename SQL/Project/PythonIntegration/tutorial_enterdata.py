import sqlite3
#REFER TO tutorial_sqlite.py for more comments


conn =  sqlite3.connect('test.db') 

c = conn.cursor()



conn.commit()

# Close the connection 
conn.close()