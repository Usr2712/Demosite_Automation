package Factory;


import ReaderFiles.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;


public class DriverFactory {

    private static ConfigReader configReader;
    static Properties prop;

    public static WebDriver driver;


        public static void init_driver(String browser) {


        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\chromedriver\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();

        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }


    }

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static WebDriver getDriver() {

        configReader = new ConfigReader();
        prop = configReader.init_prop();
        init_driver(prop.getProperty("browser"));
        return driver;
    }
}