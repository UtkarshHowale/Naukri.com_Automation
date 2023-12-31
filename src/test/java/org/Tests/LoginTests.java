package org.Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.Base.BaseTest;
import org.Driver.DriverManager;
import org.Pages.LoginPage;
import org.Utils.ExcelDataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


public class TC_01 extends BaseTest {

    public LoginPage loginPage = null;
    public Assertion assertion = new Assertion();


    @Owner("Utkarsh Howale")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login functionality with invalid credentials")
    @Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "Data", groups = {"P0", "Negative"},priority = 1)
    public void InvalidLoginTest(String Username, String Password, String expected_error_text) throws InterruptedException {

        loginPage = new LoginPage();
        loginPage.GoToLoginSection();
        Thread.sleep(2000);
        loginPage.InvalidLoginTest(Username, Password);
        Thread.sleep(2000);
        String Actual_Error_Text = loginPage.error_text();
        assertion.assertEquals(Actual_Error_Text, expected_error_text);
    }

    @Owner("Utkarsh Howale")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login functionality with valid credentials")
    @Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "Data", groups = {"P0", "Positive"},priority = 2)
    public void ValidLoginTest(String Username, String Password, String expectedPageTitle) throws Exception {

        loginPage = new LoginPage();
        loginPage.GoToLoginSection();
        Thread.sleep(2000);
        loginPage.Login(Username, Password);
        Thread.sleep(2000);
        String ActualTitle = DriverManager.getDriver().getTitle();
        assertion.assertEquals(ActualTitle, expectedPageTitle);
    }
}
