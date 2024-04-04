# Crete tables in the CurrentAffairs Database with the 
# requried constrains. 
# The tables can be altered later and use this script to 
# create them again based on the new requirements. 
# ---------------------------------------------------------

import psycopg2
from config import load_config

def create_tables():
    """ Create tables in the PostgreSQL database"""
    commands = [
        """
        CREATE TABLE articles (
            article_id SERIAL PRIMARY KEY,
            title VARCHAR(511) NOT NULL,
            subtitle VARCHAR(255) ,
            articletext TEXT NOT NULL,
            author_id INTEGER ,
            pubdate DATE NOT NULL,
            category_id INTEGER NOT NULL,
            location_id INTEGER ,
            category_id2 INTEGER ,
            category_id3 INTEGER ,
            location_id INTEGER ,
            url VARCHAR(511),
            source_id INTEGER NOT NULL,
            lang_id INTEGER ,
            type_id INTEGER
        )
        """,
        """ 
        CREATE TABLE locations (
                location_id SERIAL PRIMARY KEY,
                location VARCHAR(255) NOT NULL,
                location_data TEXT 
                )
        """,
        """
        CREATE TABLE userprofile (
                user_id  SERIAL PRIMARY KEY,
                username  CHAR(10) NOT NULL,
                email  CHAR(50) NOT NULL,
                phone CHAR(13) NOT NULL,
                regdate DATE NOT NULL,
                preference_id INTEGER NOT NULL
        )
        """,
        """
        CREATE TABLE sources(
                sources_id SERIAL PRIMARY KEY,
                source_name VARCHAR(255) NOT NULL,
                source_desc TEXT ,
                source_bias SMALLINT,
                source_rating SMALLINT,
        )
        """
            ,
        """
        CREATE TABLE type(
            type_id SERIAL PRIMARY KEY,
            type VARCHAR(255),
            type_desc TEXT 
        )
        """
            ,
        """
        CREATE TABLE userAuthentication(
            user_id  INTEGER NOT NULL,
            pass_hash  TEXT NOT NULL
        """
            ,
        """
        CREATE TABLE userPreferences(
            preference_id  SERIAL PRIMARY KEY,
            category_id_1  SMALLINT NOT NULL,
            category_id_2 SMALLINT,
            category_id_3 SMALLINT,
            category_id_4 SMALLINT,
            category_id_5 SMALLINT
        """
            ,
        """
        CREATE TABLE language(
            lang_id SERIAL PRIMARY KEY,
            language VARCHAR(255),
            lang_desc TEXT
        """
            ,
        """
        CREATE TABLE authors(
            author_id  SERIAL PRIMARY KEY,
            author_name  VARCHAR(255),
            author_desc TEXT
        """
            ,
        """
        CREATE TABLE category(
            category_id  SERIAL PRIMARY KEY,
            category_name  VARCHAR(255),
            category_desc TEXT
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