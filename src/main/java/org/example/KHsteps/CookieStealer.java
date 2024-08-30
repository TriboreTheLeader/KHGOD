package org.example.KHsteps;

import org.example.BaseTest;


import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import static org.example.Xpaths.Xpaths.*;

public class CookieStealer extends BaseTest {





    @Test
    public void openBrowser() throws InterruptedException, IOException {

        driver.get("https://klanhaboru.hu");
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);
        Thread.sleep(1000);
        driver.findElement(USERNAME).sendKeys(""); //Your UserName
        Thread.sleep(500);
        driver.findElement(PW).sendKeys(""); //Your PW
        Thread.sleep(500);
        driver.findElement(LOGIN).click();


        Thread.sleep(100000);  // Csináld meg a nem vagyok robot Puzzelt manuálisan majd várj a Teszt Lefutására


        saveCookiesToFile("cookies.txt");
    }

    private void saveCookiesToFile(String filePath) throws IOException {
        Set<Cookie> cookies = driver.manage().getCookies();
        try (FileWriter writer = new FileWriter(new File(filePath))) {
            for (Cookie cookie : cookies) {
                writer.write(cookie.getName() + "=" + cookie.getValue() + ";");
            }
        }
    }


}