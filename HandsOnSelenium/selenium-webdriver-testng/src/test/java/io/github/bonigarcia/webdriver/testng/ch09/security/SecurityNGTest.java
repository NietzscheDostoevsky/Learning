/*
 * (C) Copyright 2021 Boni Garcia (https://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia.webdriver.testng.ch09.security;

import static io.github.bonigarcia.wdm.WebDriverManager.isOnline;
import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.File;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecurityNGTest {

    static final Logger log = getLogger(lookup().lookupClass());

    static final String ZAP_PROXY_ADDRESS = "localhost";
    static final int ZAP_PROXY_PORT = 8080;
    static final String ZAP_API_KEY = "<put-api-key-here-or-disable-it>";

    WebDriver driver;

    ClientApi api;

    @BeforeMethod
    public void setup() {
        String proxyStr = ZAP_PROXY_ADDRESS + ":" + ZAP_PROXY_PORT;
        assumeThat(isOnline("http://" + proxyStr)).isTrue();

        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyStr);
        proxy.setSslProxy(proxyStr);

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setProxy(proxy);

        driver = WebDriverManager.chromedriver().capabilities(options).create();

        api = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_API_KEY);
    }

    @AfterMethod
    public void teardown() throws ClientApiException {
        if (api != null) {
            String title = "My ZAP report";
            String template = "traditional-html";
            String description = "This is a sample report";
            String reportfilename = "zap-report.html";
            String targetFolder = new File("").getAbsolutePath();
            ApiResponse response = api.reports.generate(title, template, null,
                    description, null, null, null, null, null, reportfilename,
                    null, targetFolder, null);
            log.debug("ZAP report generated at {}", response.toString());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSecurity() {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }

}
