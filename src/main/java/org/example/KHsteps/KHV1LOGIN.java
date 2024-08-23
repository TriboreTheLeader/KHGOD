package org.example.KHsteps;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.example.Xpaths.Xpaths.*;

public class KHV1LOGIN extends BaseTest {

    @Test
    public void accessSiteWithCookies() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(12));

        driver.get("https://klanhaboru.hu");
        loadCookiesFromFile("cookies.txt");
        driver.navigate().refresh();
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);
        Thread.sleep(1000);
        driver.findElement(Classic22).click();
        Thread.sleep(1000);


       String fa = driver.findElement(Wood).getText();
       String agyag = driver.findElement(Clay).getText();
       String vas = driver.findElement(Iron).getText();


       System.out.println(fa+" fa "+agyag+" agyag "+vas+" vas "+"ezek vannak most-----------------------------------------------------------------------------------------------------------");


       driver.findElement(Vár).click();
        Thread.sleep(2500);




    }

    private void loadCookiesFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cookies = line.split(";");
                for (String cookie : cookies) {
                    String[] cookieParts = cookie.split("=");
                    if (cookieParts.length == 2) {
                        Cookie newCookie = new Cookie(cookieParts[0], cookieParts[1]);
                        driver.manage().addCookie(newCookie);
                    }
                }
            }
        }
    }
}
