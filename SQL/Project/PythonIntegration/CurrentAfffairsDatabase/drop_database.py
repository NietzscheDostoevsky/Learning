# DROP database with the given name which can be 
# edited in the variable databaseName
# ---------------------------------------------------------

import psycopg2
from config import load_config

databaseName = "CURRENTAFFAIRS" # Set database name here 

def drop_database(databaseName):
    """ drop database in the PostgreSQL database
        
        Args:
            databaseName (string): The name of the Database 
            
    """

    dbName = databaseName
    config = load_config()
    conn = psycopg2.connect(**config)
    conn.autocommit = True
    cur = conn.cursor()
    command = f"""DROP DATABASE {dbName}"""
     
    
    try:
        cur.execute(command)
        print(f"dropd Database : {dbName} : successfully")
    except (psycopg2.DatabaseError, Exception) as error:
        print(error)


if __name__ == '__main__':
    drop_database(databaseName)