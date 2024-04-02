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

# INSERTING ONE ROW INTO THE TABLE 
# ---------------------------------------------------------
# The following insert_vendor() function inserts a new row 
# into the vendors table and returns the inserted vendor_id.

import psycopg2
from config import load_config


def insert_vendor(vendor_name):
    """ Insert a new vendor into the vendors table """

    sql = """INSERT INTO vendors(vendor_name)
             VALUES(%s) RETURNING vendor_id;"""
    
    vendor_id = None
    config = load_config()

    try:
        with  psycopg2.connect(**config) as conn:
            with  conn.cursor() as cur:
                # execute the INSERT statement
                cur.execute(sql, (vendor_name,))   # execute(query, vars=None) 
                                                   # Execute a database operation (query or command).
                                                   # Parameters may be provided as sequence or mapping 
                                                   # and will be bound to variables in the operation.
                                                   # Variables are specified either with positional (%s) or 
                                                   # named (%(name)s) placeholders. 
                                                   # If a query was executed, the returned values can be 
                                                   # retrieved using fetch*() methods.

                # get the generated id back                
                rows = cur.fetchone()
                if rows:
                    vendor_id = rows[0]

                # commit the changes to the database
                conn.commit()
    except (Exception, psycopg2.DatabaseError) as error:
        print("ERROR in single : " , error)    
    finally:
        return vendor_id
    

if __name__ == '__main__':
    insert_vendor("3M Co.")


# INSERTING MULTIPLE ROWS INTO THE TABLE 
# ----------------------------------------
# The steps for inserting multiple rows into a table are
# similar to the steps of inserting one row. 
# The key difference is in the third step: 
# instead of calling the execute() method of the cursor object, 
# you use the  executemany() method.


def insert_many_vendors(vendor_list):
    """ Insert multiple vendors into the vendors table  """

    sql = "INSERT INTO vendors(vendor_name) VALUES(%s) RETURNING *"
    config = load_config()
    rows = []

    try:
        with  psycopg2.connect(**config) as conn:
            with  conn.cursor() as cur:
                # execute the INSERT statement
                cur.executemany(sql, vendor_list)

                # obtain the inserted rows
                rows = cur.fetchall()

                # commit the changes to the database
                conn.commit()
    except (Exception, psycopg2.DatabaseError) as error:
        print("ERROR in many : ", error)    
    finally:
        return rows    
    
# INSERTING DATA INTO THE TABLE USING THE ABOVE FUNCTIONS 
# -------------------------------------------------------

if __name__ == '__main__':
    insert_vendor("3M Co.")

    insert_many_vendors([
        ('AKM Semiconductor Inc.',),
        ('Asahi Glass Co Ltd.',),
        ('Daikin Industries Ltd.',),
        ('Dynacast International Inc.',),
        ('Foster Electric Co. Ltd.',),
        ('Murata Manufacturing Co. Ltd.',)
    ])    

    

