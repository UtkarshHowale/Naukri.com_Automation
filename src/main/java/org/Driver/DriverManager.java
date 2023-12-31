package org.CURAHealthcareService.Driver;


import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverManager {

    static WebDriver driver = null;

    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRf) {

        dr.set(driverRf);
    }

    public static WebDriver getDriver() {

        return dr.get();
    }

    public static void Unload() {

        dr.remove();
    }

    @BeforeMethod
    public static void startDriver(String BrowserName) {

        if (getDriver() == null) {

            switch (BrowserName.toLowerCase()) {

                case "chrome":

                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    setDriver(new ChromeDriver(chromeOptions));

                    break;


                case "firefox":

                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    setDriver(new FirefoxDriver(firefoxOptions));

                    break;

                case "edge":

                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    setDriver(new EdgeDriver(edgeOptions));

                    break;

                case "safari":

                    SafariOptions safariOptions = new SafariOptions();
                    safariOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    setDriver(new SafariDriver(safariOptions));

                    break;

            }
        }
    }

    @AfterMethod
    public static void closeDriver() {

        if (getDriver() != null) {

            getDriver().quit();
        }

    }
}
