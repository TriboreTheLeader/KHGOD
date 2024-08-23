package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create ChromeOptions instance and add arguments to disable first-run UI
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--disable-popup-blocking");



        // Initialize WebDriver with ChromeOptions
        driver = new ChromeDriver(options);



    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}