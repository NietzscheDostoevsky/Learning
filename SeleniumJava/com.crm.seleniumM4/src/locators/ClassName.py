from selenium import webdriver
import time
from selenium.webdriver.common.by import By

driver = webdriver.Chrome(); 
driver.maximize_window(); 
url = "https://demowebshop.tricentis.com/";
driver.get(url)
fetched_url = driver.current_url
if(url == fetched_url) :
    print("I am on dws website")
    time.sleep(2)
    
    # clicking on register button 
    driver.find_element(By.CLASS_NAME, "ico-register").click()
    time.sleep(5)
    driver.close()
else:
    print("wrong website")
    driver.close()
