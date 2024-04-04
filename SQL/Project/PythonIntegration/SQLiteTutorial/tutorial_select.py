import sqlite3
#REFER TO tutorial_sqlite.py for more comments


conn =  sqlite3.connect('test.db') 

c = conn.cursor()



c.execute("SELECT rowid,* FROM CUSTOMERS")

# c.fetchone() # fetches the last item in the table
# c.fetchmany(3)
items = c.fetchall()

#for  item in items:
 #   print(item[0] +"\t"+ item[1] + "\t\t"+ item[2])


print(items)

c.execute("SELECT * FROM CUSTOMERS WHERE LASTNAME = 'SUNDARI'")
print(c.fetchall())
print("Command executed successfully...")


conn.commit()
conn.close()