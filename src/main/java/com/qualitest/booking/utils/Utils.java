package com.qualitest.booking.utils;

import com.qualitest.booking.exceptions.BrowserException;
import com.qualitest.booking.exceptions.PropertiesException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Utils {

    private WebDriver driver;
    private final Properties property = loadProperties();
    private final String URL= property.getProperty("URL");
    private final String BROWSER= property.getProperty("BROWSER");
    private final String LANGUAGE= property.getProperty("LANGUAGE");

    private final String PATH_NAME = "src\\main\\resources\\";
    private final String CAPABILITIES = "capabilities.properties";

    public WebDriver getPageUrl(){
        driver = selectDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get(URL);
        return driver;
    }

    private Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream(PATH_NAME + CAPABILITIES)) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch(IOException e) {
            throw new PropertiesException();
        }
    }

    public WebDriver selectDriver() {
        switch(BROWSER.toLowerCase()) {
            case "chrome":
                ChromeOptions opt = new ChromeOptions();
                opt.addArguments(LANGUAGE);
                driver = new ChromeDriver(opt);
                return driver;
            case "firefox":
                driver = new FirefoxDriver();
                return driver;
            case "edge":
                driver = new EdgeDriver();
                return driver;
            case "internetexplorer":
                driver = new InternetExplorerDriver();
                return driver;
            case "safari":
                driver = new SafariDriver();
                return driver;
            default:
                throw new BrowserException();
        }
    }
}
