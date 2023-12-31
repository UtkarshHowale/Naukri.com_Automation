package org.Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.Base.BaseTest;
import org.Pages.HomePage;
import org.Pages.ProfilePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TC_02 extends BaseTest {

    private static final Logger logger = LogManager.getLogger(TC_02.class);
    HomePage homePage = null;
    ProfilePage profilePage = null;

    @Owner("Utkarsh Howale")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user able to edit profile headline or not")
    @Test(groups = {"P0","Positive"})
    public void UpdateProfileHeadline() throws InterruptedException {

        homePage = new HomePage();
        profilePage = new ProfilePage();

        homePage.GoToProfilePage();
        Thread.sleep(2000);
//        profilePage.HandlePopUpWindow();
//        Thread.sleep(2000);
        profilePage.ClickOnProfileHeadline();
        Thread.sleep(2000);
        profilePage.EnterProfileHeadline();
        Thread.sleep(2000);
        profilePage.ClickOnSaveButton();
        Thread.sleep(2000);

        String ActualMessage = profilePage.SuccessMessage();

        String ExpectedMessage = "Resume Headline has been successfully saved.";

        if (ActualMessage.equalsIgnoreCase(ExpectedMessage)){

            System.out.println("Profile Updated Sucessfully");
        }
        else {

            try {

                throw new Exception("Profile Not Updated !!!!");
            }
            catch (Exception e){

                e.printStackTrace();
            }
        }
    }
}
