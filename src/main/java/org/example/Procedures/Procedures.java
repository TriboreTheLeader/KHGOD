package org.example.Procedures;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.example.Xpaths.Xpaths.*;

public class Procedures {


    private WebDriver driver;

    // Constructor to initialize the driver
    public Procedures(WebDriver driver) {
        this.driver = driver;
    }


    public void LOGIN( ) throws IOException, InterruptedException {


        loadCookiesFromFile("cookies.txt");
        driver.navigate().refresh();
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);
        Thread.sleep(1000);
        driver.findElement(Classic22).click();
        Thread.sleep(1000);


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
