package com.qualitest.booking;

import com.qualitest.booking.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Hello world!
 *
 */
public class HomePage extends AbstractPage
{
    private By searchDestinyInput = By.xpath("//*[@type='search']");


    private By calendarCheckInButton = By.xpath("//*[@data-mode='checkin']");

    private By calendarCheckOutButton = By.xpath("//*[@data-mode='checkout']");

    private By nextMonthCalendarButton = By.xpath("//*[@data-bui-ref='calendar-next']");

    private By nameFirstCalendarMonth = By.xpath("(//*[@class='bui-calendar__month'])[1]");

    private By nameSecondCalendarMonth = By.xpath("(//*[@class='bui-calendar__month'])[2]");

    private String checkinDate = time.getDateCheckInDate();
    private By dateCheckInButton = By.xpath("//*[@data-date='" + checkinDate + "']");

    private String checkoutDate = time.getDateCheckOutDate();
    private By dateCheckOutButton = By.xpath("//*[@data-date='" + checkoutDate + "']");

    private By submitTravelButton = By.cssSelector("button[type='submit']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void writeDestinyInput(String input, String destiny){
        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(searchDestinyInput).sendKeys(input);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@role='option']")));
        List<WebElement> listDestinyButtons = driver.findElements(By.xpath("//li[@role='option']"));

        for(WebElement location: listDestinyButtons) {
            By linkLocation = By.xpath("//li[@role='option']/*/span[@class='search_hl_name']");
            String city = driver.findElement(linkLocation).getText();
            if(city.equalsIgnoreCase(destiny)) {
                driver.findElement(linkLocation).click();
            }
        }
    }

    public void checkMonthTravelButton() {
        driver.findElement(calendarCheckInButton).click();
        String month;
        do {
            month = driver.findElement(nameSecondCalendarMonth).getText();
            LOGGER.info(month);
            if(!driver.findElement(nextMonthCalendarButton).isDisplayed()) {
                driver.findElement(calendarCheckInButton).click();
            }
            driver.findElement(nextMonthCalendarButton).click();
        } while(!time.getMonthCalendarPage(month));
    }

    public void selectDateCheckInButton() {
        driver.findElement(dateCheckInButton).click();
    }

    public void selectDateCheckOutButton() {
        driver.findElement(dateCheckOutButton).click();
    }

    public DestinyPage clickSubmitButton() {
        driver.findElement(submitTravelButton).click();
        return new DestinyPage(this.driver);
    }
}
