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
            article_id  NOT NULL AUTO_INCREMENT PRIMARY KEY,
            title  NOT NULL,
            subtitle  NOT NULL,
            author_id  NOT NULL,
            pubdate  NOT NULL,
            category_id  NOT NULL,
            location_id  NULL,
            category_id  NOT NULL,
            category_id2  NOT NULL,
            category_id3  NOT NULL,
            location_id  NOT NULL,
            url  NOT NULL,
            source_id  NOT NULL,
            lang_id  NOT NULL,
            type_id  NOT NULL
        )
        """,
        """ CREATE TABLE locations (
                location_id PRIMARY KEY,
                location NOT NULL,
                location_data NOT NULL
                )
        """,
        """
        CREATE TABLE userprofile (
                `user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                `username` VARCHAR(255) NOT NULL,
                `email` VARCHAR(255) NOT NULL,
                `phone` BIGINT NOT NULL,
                `regdate` DATE NOT NULL,
                `preference_id` BIGINT NOT NULL
        )
        """,
        """
        CREATE TABLE `sources`(
                `sources_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                `source_name` VARCHAR(255) NOT NULL,
                `source_desc` VARCHAR(255) NOT NULL,
                `source_bias` BIGINT NOT NULL,
                `source_rating` BIGINT NOT NULL
        )
        """
            ,
        """
        CREATE TABLE `type`(
        `type_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `type` VARCHAR(255) NOT NULL,
        `type_desc` VARCHAR(255) NOT NULL
        )
        """
            ,
        """
        CREATE TABLE `userAuthentication`(
            `user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
            `pass_hash` BIGINT NOT NULL
        """
            ,
        """
        CREATE TABLE `UserPreferences`(
            `preference_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
            `category_id_1` BIGINT NOT NULL,
            `category_id_2` BIGINT NOT NULL,
            `category_id_3` BIGINT NOT NULL,
            `category_id_4` BIGINT NOT NULL,
            `category_id_5` BIGINT NOT NULL
        """
            ,
        """
        CREATE TABLE `language`(
            `lang_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
            `language` VARCHAR(255) NOT NULL,
            `lang_desc` VARCHAR(255) NOT NULL
        """
            ,
        """
        """
            ,
        """
        """
            ,
        
        
        
        
        
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