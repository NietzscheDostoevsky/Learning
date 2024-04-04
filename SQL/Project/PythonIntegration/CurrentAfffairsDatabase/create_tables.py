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
                location_id PRIMARY KEY,
                location NOT NULL,
                location_data NOT NULL
                )
        """,
        """
        CREATE TABLE userprofile (
                user_id   NOT NULL AUTO_INCREMENT PRIMARY KEY,
                username  NOT NULL,
                email  NOT NULL,
                phone  NOT NULL,
                regdate DATE NOT NULL,
                preference_id  NOT NULL
        )
        """,
        """
        CREATE TABLE sources(
                sources_id   NOT NULL AUTO_INCREMENT PRIMARY KEY,
                source_name  NOT NULL,
                source_desc  NOT NULL,
                source_bias  NOT NULL,
                source_rating  NOT NULL
        )
        """
            ,
        """
        CREATE TABLE type(
            type_id   NOT NULL AUTO_INCREMENT PRIMARY KEY,
            type  NOT NULL,
            type_desc  NOT NULL
        )
        """
            ,
        """
        CREATE TABLE userAuthentication(
            user_id   NOT NULL AUTO_INCREMENT PRIMARY KEY,
            pass_hash  NOT NULL
        """
            ,
        """
        CREATE TABLE UserPreferences(
            preference_id   NOT NULL AUTO_INCREMENT PRIMARY KEY,
            category_id_1  NOT NULL,
            category_id_2  NOT NULL,
            category_id_3  NOT NULL,
            category_id_4  NOT NULL,
            category_id_5  NOT NULL
        """
            ,
        """
        CREATE TABLE language(
            lang_id   NOT NULL AUTO_INCREMENT PRIMARY KEY,
            language  NOT NULL,
            lang_desc  NOT NULL
        """
            ,
        """
        CREATE TABLE authors(
            author_id   NOT NULL AUTO_INCREMENT PRIMARY KEY,
            author_name  NOT NULL,
            author_desc  NOT NULL COMMENT 'Description about the author'
        """
            ,
        """
        CREATE TABLE category(
            category_id   NOT NULL AUTO_INCREMENT PRIMARY KEY,
            category_name  NOT NULL,
            category_desc  NOT NULL
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