package org.Tests;

import org.Base.BaseTest;
import org.Pages.HomePage;
import org.Pages.ProfilePage;
import org.testng.annotations.Test;

public class TC_02 extends BaseTest {

    HomePage homePage = null;
    ProfilePage profilePage = null;

    @Test
    public void UpdateProfileHeadline() throws InterruptedException {

        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);

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
