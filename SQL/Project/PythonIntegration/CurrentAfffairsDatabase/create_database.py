# Crate database with the given name which can be 
# edited in the variable databaseName
# ---------------------------------------------------------

import psycopg2
from config import load_config

databaseName = "CURRENTAFFAIRS" # Set database name here 

def create_database(databaseName):
    """ Create database in the PostgreSQL database
        
        Args:
            databaseName (string): The name of the Database 
            
    """

    dbName = databaseName
    config = load_config()
    conn = psycopg2.connect(**config)
    conn.autocommit = True
    cur = conn.cursor()
    command = f"""CREATE DATABASE {dbName}"""
     
    
    try:
        cur.execute(command)
        print(f"Created Database : {dbName} : successfully")
    except (psycopg2.DatabaseError, Exception) as error:
        print(error)


if __name__ == '__main__':
    create_database(databaseName)