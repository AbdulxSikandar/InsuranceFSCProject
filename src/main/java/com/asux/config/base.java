package com.asux.config;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.asux.utilities.ApachePOIExcelReader;

public class base {
    

    // This is Excel File Path from where we will pick data related to multiple variable
    public static String filePath = "C:\\Users\\speak\\Downloads\\ASU\\asuxdata.xlsx";
        
    //Read data from Sheet 0, Row 2, Cell 2
    public static String BrokerPhone = ApachePOIExcelReader.getdata(filePath, 0, 1, 1);
    public static String url = ApachePOIExcelReader.getdata(filePath, 0, 1, 2);
    public static String Email = ApachePOIExcelReader.getdata(filePath, 0, 1, 3);
    public static String KBO = ApachePOIExcelReader.getdata(filePath, 0, 1, 4);
    public static String date = ApachePOIExcelReader.getdata(filePath, 0, 1, 5);
    public static String Docfilepath = ApachePOIExcelReader.getdata(filePath, 0, 1, 6);


    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            setDriver("Chrome"); // Default to Chrome
        }
        return driver.get();
    }

    public static WebDriver getDriver(String browserName) {
        if (driver.get() == null) {
            setDriver(browserName);
        }
        return driver.get();
    }

    private static void setDriver(String browserName) {
        WebDriver newDriver;
        switch (browserName.toLowerCase()) {
            case "chrome":
                newDriver = new ChromeDriver();
                break;
            case "firefox":
                newDriver = new FirefoxDriver();
                break;
            case "safari":
                newDriver = new SafariDriver();
                break;
            case "edge":
                newDriver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        newDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        newDriver.manage().window().maximize();
        driver.set(newDriver);
    }

    public static void openBrowser(String url) {
        getDriver().get(url);
    }

    public static void openBrowser(String browserName, String url) {
        getDriver(browserName).get(url);
    }

    public static void closeBrowser() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Reset driver instance
        }
    }
}
