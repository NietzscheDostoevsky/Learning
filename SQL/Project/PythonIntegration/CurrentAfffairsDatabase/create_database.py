# Crete tables in the CurrentAffairs Database with the 
# requried constrains. 
# The tables can be altered later and use this script to 
# create them again based on the new requirements. 
# ---------------------------------------------------------

import psycopg2
from config import load_config

def create_database(databaseName):
    """ Create tables in the PostgreSQL database
        
        Args:
            databaseName (string): The name of the Database 
            
    """
    commands = [
    """
    """
       ]
    try:
        config = load_config()
        with psycopg2.connect(**config) as conn:
            with conn.cursor() as cur:
                # execute the CREATE TABLE statement
                for command in commands:
                    cur.execute(command)
                    tablename = command.split()[2]
                    print(f"Created Table - {tablename} successfully") 
    except (psycopg2.DatabaseError, Exception) as error:
        print(error)

if __name__ == '__main__':
    create_tables()