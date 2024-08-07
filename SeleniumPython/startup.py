import selenium;
import time; 
from selenium import webdriver; 
print("Testing the installation")

driver = webdriver.Chrome()
driver.maximize_window(); 
driver.get("https://google.co.in")
time.sleep(10)
print("Exiting")
driver.close()