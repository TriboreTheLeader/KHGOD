package org.example.Xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpaths {

    private WebDriver driver;

    public static final By USERNAME = By.xpath("//*[@id=\"user\"]");

    public static final By PW = By.xpath("//*[@id=\"password\"]");

    public static final By LOGIN = By.xpath("//*[@id=\"login_form\"]/div/div/a");

    public static final By Classic22 = By.xpath("//*[text()=\"Classic 22\"]");

    public static final By Wood = By.xpath("//*[@id=\"wood\"]");

    public static final By Clay = By.xpath("//*[@id=\"stone\"]");

    public static final By Iron = By.xpath("//*[@id=\"iron\"]");

    public static final By Vár = By.xpath("//area[@data-title='Főhadiszállás']");

}

