package org.example.Procedures;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.example.Xpaths.Xpaths.Classic22;
import static org.example.Xpaths.Xpaths.Script;

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



    public void Farm() throws IOException, InterruptedException, AWTException {

        Thread.sleep(1000);

        try {

            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_1);
            Thread.sleep(1500);
            robot.keyPress(KeyEvent.VK_1);
            Thread.sleep(1500);
            robot.keyPress(KeyEvent.VK_ENTER);

            long endTime = System.currentTimeMillis() + 15000;



            while (System.currentTimeMillis() < endTime) {



                robot.keyPress(KeyEvent.VK_ENTER);


                Thread.sleep(100);


                robot.keyRelease(KeyEvent.VK_ENTER);


                Thread.sleep(500);
            }




            Thread.sleep(1500);
            robot.keyRelease(KeyEvent.VK_2);

            System.out.println("C gomb ismételt megnyomása befejeződött.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backtovillage() throws IOException, InterruptedException, AWTException {

        Thread.sleep(1000);
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(10000);
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
