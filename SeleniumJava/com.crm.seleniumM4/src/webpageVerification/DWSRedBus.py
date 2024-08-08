from selenium import webdriver
driver = webdriver.Chrome(); 

DWSURL = "https://demowebshop.tricentis.com/"
RedBusURL = "https://www.redbus.in/"
RedBusTitle = "Bus Ticket Booking Online made Easy, Secure with Top Bus Operators - redBus";

driver.get(DWSURL)
if(driver.current_url==DWSURL):
    print("URL verified")
else:
    print("URL not same")
driver.get(RedBusURL)
if(driver.title == RedBusTitle):
    print("RedBus title verified")
else:
    print("RedBus title not verfied.")