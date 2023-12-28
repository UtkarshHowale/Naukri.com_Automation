package org.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public WebDriver driver;
    public HomePage(WebDriver driver){

        this.driver = driver;
    }

    By ProfileButton = By.xpath("//a[normalize-space()='View profile']");

    public void GoToProfilePage(){

        driver.findElement(ProfileButton).click();
    }
}
