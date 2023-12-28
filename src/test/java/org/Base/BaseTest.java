package org.Base;

import org.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public WebDriver driver = null;
    public LoginPage loginPage = null;

    @BeforeSuite
    public void Setup(){

        try {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.naukri.com/");
            loginPage = new LoginPage(driver);
            loginPage.GoToLoginSection();
            Thread.sleep(2000);
            loginPage.LoginToNaukriProfile();
            Thread.sleep(5000);
        }
        catch (Exception e ){
            e.printStackTrace();
        }



    }

    @AfterSuite
    public void TearDown(){

        driver.quit();
    }
}
