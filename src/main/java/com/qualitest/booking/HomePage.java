package com.qualitest.booking;

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

    private final By searchDestinyInput = By.xpath("//*[@type='search']");

    private final By calendarCheckInButton = By.xpath("//*[@data-mode='checkin']");

    private final By calendarCheckOutButton = By.xpath("//*[@data-mode='checkout']");

    private final By nextMonthCalendarButton = By.xpath("//*[@data-bui-ref='calendar-next']");

    private final By nameFirstCalendarMonth = By.xpath("(//*[@class='bui-calendar__month'])[1]");

    private final By nameSecondCalendarMonth = By.xpath("(//*[@class='bui-calendar__month'])[2]");

    private final String checkinDate = time.getDateCheckIn();
    private final By dateCheckInButton = By.xpath("//*[@data-date='" + checkinDate + "']");

    private final String checkoutDate = time.getDateCheckOut();
    private final By dateCheckOutButton = By.xpath("//*[@data-date='" + checkoutDate + "']");

    private final By submitTravelButton = By.cssSelector("button[type='submit']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void writeDestinyInput(String input, String destiny){
        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(searchDestinyInput).sendKeys(input);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@role='option']")));
        List<WebElement> listDestinyButtons = driver.findElements(By.xpath("/span[@class='search_hl_name']"));

        for(WebElement location: listDestinyButtons) {
            if(location.getText().equalsIgnoreCase(destiny)) {
                location.click();
            }
        }
    }

    public void checkMonthTravelButton() {
        if(!driver.findElement(nextMonthCalendarButton).isDisplayed()) {
            driver.findElement(calendarCheckInButton).click();
        }
        String month;
        do {
            month = driver.findElement(nameSecondCalendarMonth).getText();
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
