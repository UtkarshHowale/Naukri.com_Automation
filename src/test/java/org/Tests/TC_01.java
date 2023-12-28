package org.Tests;

import org.Base.BaseTest;
import org.Pages.LoginPage;
import org.Utils.ExcelDataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


public class TC_01 extends BaseTest {

    public  LoginPage loginPage = null;
    public Assertion assertion = new Assertion();

    @Test(dataProviderClass = ExcelDataProvider.class,dataProvider = "Data")
    public void AutomateLoginFunctionality(String Username, String Password){

        try {

            loginPage = new LoginPage(driver);

            loginPage.GoToLoginSection();
            Thread.sleep(5000);

            loginPage.Login(Username,Password);
            Thread.sleep(5000);

            String ActualTitle = driver.getTitle();

            String ExpectedTitle = "Home | Mynaukri";

            assertion.assertEquals(ActualTitle,ExpectedTitle);
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }
}
