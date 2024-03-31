import cx_Oracle
cx_Oracle.init_oracle_client(lib_dir=r"C:\oracle\instantclient_21_13")
con = cx_Oracle.connect('tiger/scott@localhost:1521/xe')