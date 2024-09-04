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




    }

    @AfterMethod
    public void tearDown() {
        // Close the browser

    }
}