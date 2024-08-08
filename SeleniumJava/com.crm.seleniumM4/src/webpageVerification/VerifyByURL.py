from selenium import webdriver
import time; 

driver = webdriver.Chrome() 
driver.maximize_window()
expected_result = "https://demowebshop.tricentis.com/";
driver.get(expected_result)
actual_result = driver.current_url
if(expected_result == actual_result):
    print("I am in DWS page")
else:
    print("I am not in dws page")
