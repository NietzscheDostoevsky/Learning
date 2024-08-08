from selenium import webdriver

driver = webdriver.Chrome()
expectedTitle = "Demo Web Shop"

driver.get("https://demowebshop.tricentis.com/")
actualTitle = driver.title

if(expectedTitle == actualTitle):
    print("Same same")
else:
    print("not same")
driver.close()