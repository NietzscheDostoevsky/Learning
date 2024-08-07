import selenium; 
import time; 
from selenium import webdriver; 

driver = webdriver.Chrome(); 
driver.maximize_window();
driver.get("https://google.com");
time.sleep(5); 
driver.close();