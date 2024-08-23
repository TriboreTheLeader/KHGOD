package org.example.KHsteps;

import org.example.BaseTest;


import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import static org.example.Xpaths.Xpaths.*;

public class KH extends BaseTest {





    @Test
    public void openBrowser() throws InterruptedException, IOException {
        // Navigálás egy weboldalra
        driver.get("https://klanhaboru.hu");

        // Ellenőrizzük az oldal címét
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);

        // Várakozás az oldal betöltésére
        Thread.sleep(1000);

        // Bejelentkezési mezők kitöltése
        driver.findElement(USERNAME).sendKeys("");
        Thread.sleep(500);
        driver.findElement(PW).sendKeys("");
        Thread.sleep(500);
        driver.findElement(LOGIN).click();

        // Várakozás a bejelentkezés befejezésére
        Thread.sleep(100000);  // Az időt az oldal betöltési idejéhez igazítsd

        // Elmentjük a cookie-kat
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