from selenium import webdriver; 
import time

driver = webdriver.Chrome(); 
driver.maximize_window();
driver.get("https://demowebshop.tricentis.com/")
time.sleep(3); 
driver.get("https://google.com")
time.sleep(3); 
driver.back()
time.sleep(3); 
driver.forward();
time.sleep(3); 
driver.refresh();
time.sleep(5); 
driver.close();