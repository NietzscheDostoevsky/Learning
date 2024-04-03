# Steps for updating data in a PostgreSQL table from Python

# 1. First, connect to the PostgreSQL server.
# 2. Next, create a cursor object from the connection object.
# 3. Then, execute an UPDATE statement by calling the 
#       execute() method of the cursor object.
# 4. After that, commit the changes by calling the commit() method 
#       of the connection object.
# 5. Finally, optionally obtain the number of updated rows 
#       from the rowcount property of the cursor object.

# *****************************************************************

import psycopg2
from config import load_config


def update_vendor(vendor_id, vendor_name):
    """ Update vendor name based on the vendor id """
    
    updated_row_count = 0

    sql = """ UPDATE vendors
                SET vendor_name = %s
                WHERE vendor_id = %s"""
    
    config = load_config()
    
    try:
        with  psycopg2.connect(**config) as conn:
            with  conn.cursor() as cur:
                
                # execute the UPDATE statement
                cur.execute(sql, (vendor_name, vendor_id))
                updated_row_count = cur.rowcount

            # commit the changes to the database
            conn.commit()
    except (Exception, psycopg2.DatabaseError) as error:
        print("There is an error: ", error)    
    finally:
        return updated_row_count

if __name__ == '__main__':
    update_vendor(1, "3M Corp")