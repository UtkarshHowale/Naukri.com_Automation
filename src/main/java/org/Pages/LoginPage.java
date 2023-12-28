package org.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {

    public WebDriver driver = null;

    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

    By Username = By.xpath("//input[@placeholder='Enter your active Email ID / Username']");
    By Password = By.xpath("//input[@placeholder='Enter your password']");
    By LoginButton = By.xpath("//button[@class=\"btn-primary loginButton\"]");
    By LoginLayerButton = By.id("login_Layer");

    public void GoToLoginSection(){

        driver.findElement(LoginLayerButton).click();
    }

    public void Login(String EnterUsername, String EnterPassword){

        driver.findElement(Username).sendKeys(EnterUsername);
        driver.findElement(Password).sendKeys(EnterPassword);
        driver.findElement(LoginButton).click();
    }

    public void LoginToNaukriProfile(){

        driver.findElement(Username).sendKeys("utkarshhowale16@gmail.com");
        driver.findElement(Password).sendKeys("Utkarsh@16");
        driver.findElement(LoginButton).click();
    }
}
