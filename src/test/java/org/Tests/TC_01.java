package org.Tests;

import org.Base.BaseTest;
import org.Pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


public class TC_01 extends BaseTest {

    public  LoginPage loginPage = null;
    public Assertion assertion = new Assertion();

    @Test
    public void AutomateLoginFunctionality() throws InterruptedException {

        loginPage = new LoginPage(driver);

        loginPage.GoToLoginSection();
        Thread.sleep(2000);

        loginPage.Login("utkarshhowale16@gmail.com","Utkarsh@16");
        Thread.sleep(5000);

        String ActualTitle = driver.getTitle();

        String ExpectedTitle = "Home | Mynaukri";

        assertion.assertEquals(ActualTitle,ExpectedTitle);

    }
}
