from selenium import webdriver
import time

driver = webdriver.Chrome()
expectedURL = "https://www.redbus.in/"

driver.get(expectedURL)
driver.maximize_window() 
actualURL = driver.current_url
driver.close() 

if(actualURL == expectedURL):
    print("Same same")
else:
    print("Not same")
