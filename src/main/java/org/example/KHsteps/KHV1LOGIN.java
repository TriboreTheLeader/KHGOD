package org.example.KHsteps;
import org.example.BaseTest;
import org.example.Procedures.Procedures;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.example.Xpaths.Xpaths.*;

public class KHV1LOGIN extends BaseTest {

    @Test
    public void accessSiteWithCookies() throws InterruptedException, IOException {

        driver.get("https://klanhaboru.hu");
        Procedures procedures = new Procedures(driver);
        procedures.LOGIN();




    }


}
