import sqlite3
import os.path

# NOTE : SQLLITE3 IS CASE SENSITIVE

# conn =  sqlite3.connect(':memory:') 
# This creates the db in memeory which disappears after programme ends

conn =  sqlite3.connect('test.db') 

# Creating a cursor

c = conn.cursor()

# Table Creation 

c.execute(""" CREATE TABLE CUSTOMERS (
            FIRSTNAME DATATYPE,
            LASTNAME DATATYPE , 
            EMAIL DATATYPE
          ) """)

# If not using docstrings, the commands have to be written as a single line, shown below. 
# c.execute("CREATE TABLE CUSTOMERS (FIRSTNAME DATATYPE, LASTNAME DATATYPE , EMAIL DATATYPE)")