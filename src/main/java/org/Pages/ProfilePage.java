package org.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {


    WebDriver driver;
    public ProfilePage(WebDriver driver){

        this.driver = driver;
    }

    By ProfileHeadlineButton = By.xpath("//span[@class=\"edit icon\"]");
    By ProfileHeadlineText = By.id("resumeHeadlineTxt");
    By SaveButton = By.xpath("//button[normalize-space()='Save']");
    By SuccessMessage = By.xpath("//p[@class=\"msg\"]");
    By Pop_Up = By.xpath("//div[@class='crossIcon chatBot chatBot-ic-cross']");

    public void ClickOnProfileHeadline(){

        driver.findElement(ProfileHeadlineButton).click();
    }

    public void EnterProfileHeadline() throws InterruptedException {

        WebElement HeadlineText = driver.findElement(ProfileHeadlineText);
        HeadlineText.clear();
        Thread.sleep(2000);
        HeadlineText.sendKeys("Experienced QA Engineer Ensuring Software Excellence");

    }

    public void ClickOnSaveButton(){

        driver.findElement(SaveButton).click();
    }

    public String SuccessMessage(){

        return driver.findElement(SuccessMessage).getText();
    }

    public void HandlePopUpWindow(){

        driver.findElement(Pop_Up).click();
    }
}
