package com.qualitest.booking;

import com.qualitest.booking.utils.Time;
import com.qualitest.booking.utils.Utils;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Driver;

public abstract class AbstractPage {

    protected static final Logger LOGGER = LogManager.getLogger(AbstractPage.class);

    protected WebDriver driver;

    protected Time time = new Time();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
