
#  create a new file called config.py 
# in the project directory and define a 
# function called load_config() that 
# reads configuration data from the database.ini file:


# By using the database.ini, you can change the PostgreSQL connection parameters 
# when moving the code to the production environment.
from configparser import ConfigParser

def load_config(filename='database.ini', section='postgresql'):
    parser = ConfigParser()
    parser.read(filename)

    # get section, default to postgresql
    config = {}
    if parser.has_section(section):
        params = parser.items(section)
        for param in params:
            config[param[0]] = param[1]
    else:
        raise Exception('Section {0} not found in the {1} file'.format(section, filename))

    return config

if __name__ == '__main__':
    config = load_config()
    print(config)