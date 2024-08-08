from selenium import webdriver
import time; 
from asyncio.tasks import sleep
from selenium.webdriver.common.by import By

driver = webdriver.Chrome() 
driver.maximize_window()
expected_result = "https://demowebshop.tricentis.com/";
driver.get(expected_result)
actual_result = driver.current_url
if(expected_result == actual_result):
    print("I am in DWS page")
    search_field = driver.find_element(By.TAG_NAME, "input")
    search_field.send_keys("iphone")
    time.sleep(5)
    driver.close()
    print("successfully sent iphone into searchfiled")
else:
    print("I am not in dws page")
