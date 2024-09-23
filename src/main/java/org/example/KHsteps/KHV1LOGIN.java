package org.example.KHsteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.BaseTest;
import org.example.Procedures.Procedures;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.awt.*;

import java.io.IOException;


public class KHV1LOGIN extends BaseTest {


    @Test
    public void accessSiteWithCookies() throws InterruptedException, IOException, AWTException {
        int count = 1;

        while (true) {
            try {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-search-engine-choice-screen");
                options.addArguments("--disable-popup-blocking");
                driver = new ChromeDriver(options);
                System.out.println("Ciklus száma: " + count);
                driver.get("https://klanhaboru.hu");
                if (isBotProtectionVisible()) {
                    System.out.println("Bot védelem észlelve, a teszt leáll.");
                    break;
                }
                Procedures procedures = new Procedures(driver);
                procedures.LOGIN();
                procedures.Farm();
            } finally {
                if (driver != null) {
                    driver.quit();
                }
            }
            Thread.sleep(150000);
            count++;
        }
    }
    private boolean isBotProtectionVisible() {
        try {
            // Locate the bot protection element by its id
            WebElement botProtectionElement = driver.findElement(By.id("botprotection_quest"));
            return botProtectionElement.isDisplayed(); // Returns true if the element is visible
        } catch (Exception e) {
            return false; // If element is not found or not visible, return false
        }
    }
}













