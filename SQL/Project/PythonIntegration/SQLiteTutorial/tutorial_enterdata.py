import sqlite3
#REFER TO tutorial_sqlite.py for more comments


conn =  sqlite3.connect('test.db') 

c = conn.cursor()



c.execute("INSERT INTO CUSTOMERS VALUES('SUNDARA', 'SUNDARI', 'SUNDARA@GMAIL.COM')")

conn.commit()

# Close the connection 


# Many records

many_customers = [('Macha', 'Machi', 'machamachi@gmail.com'),
                 ('Gulto', 'Gulti', 'gultotulti@gmailc.comm'),
                 ('Mahi', 'Dhoni', 'mahi@dhoni.com')]

c.executemany("INSERT INTO CUSTOMERS VALUES (?,?,?)", many_customers)
conn.commit()

print("Command executed successfully...")
conn.close()