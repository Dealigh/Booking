package com.qualitest.booking;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

/**
 * Unit test for simple App.
 */
public class HomeTests extends AbstractTest
{

    private final String DESTINY= "Villa General Belgrano";

    @Test
    public void testDestinyLocationSelected()
    {
        HomePage homePage = new HomePage(utils.getPageUrl());
        homePage.writeDestinyInput("Villa", DESTINY);
        homePage.checkMonthTravelButton();
        homePage.selectDateCheckInButton();
        homePage.selectDateCheckOutButton();

        DestinyPage destinyPage = homePage.clickSubmitButton();
        destinyPage.closeSignInWindow();

        destinyPage.printListHotelNames();
        Assert.assertTrue(destinyPage.checkListCityNameSame(DESTINY));
    }
}
