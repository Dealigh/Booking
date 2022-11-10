package com.qualitest.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DestinyPage extends AbstractPage{

    private List<WebElement> listDestinyHotelNames = driver.findElements(By.xpath("//a/div[@data-testid='title']"));

    private List<WebElement> listDestinyName = driver.findElements(By.xpath("//span[@data-testid='address']"));

    private By closeWindowSignInButton = By.xpath("//button[@aria-label='Dismiss sign in information.']");

    public DestinyPage(WebDriver driver) {
        super(driver);
    }

    public void printListHotelNames() {
        for(WebElement hotels: listDestinyHotelNames) {
            LOGGER.info(hotels.getText());
        }
    }

    public boolean checkListCityNameSame(String destiny) {
        for(WebElement city: listDestinyName) {
            if(!(city.getText().equalsIgnoreCase(destiny))) {
                return false;
            }
        }
        return true;
    }

    public void closeSignInWindow() {
        try {
            driver.findElement(closeWindowSignInButton).click();
        } catch (Exception e) {
        }
    }
}
