package org.example.KHsteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.BaseTest;
import org.example.Procedures.Procedures;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.example.Xpaths.Xpaths.*;

public class KHV1LOGIN extends BaseTest {

    @Test
    public void accessSiteWithCookies() throws InterruptedException, IOException, AWTException {
        int count = 1; // Számláló kezdeti értéke

        while (true) {
            try {

                WebDriverManager.chromedriver().setup();

                // Create ChromeOptions instance and add arguments to disable first-run UI
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-search-engine-choice-screen");
                options.addArguments("--disable-popup-blocking");



                // Initialize WebDriver with ChromeOptions
                driver = new ChromeDriver(options);

                System.out.println("Ciklus száma: " + count); // Logolás a konzolra

                driver.get("https://klanhaboru.hu");
                Procedures procedures = new Procedures(driver);
                procedures.LOGIN();
                procedures.Farm();
            } finally {
                if (driver != null) {
                    driver.quit();
                }
            }


            Thread.sleep(150000);

            count++; // Növeld a számlálót minden ciklus után
        }
    }





}








