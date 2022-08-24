package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    private Properties prop = new Properties();
    public String baseurl = null;
    public String browser = null;
    public static WebDriver driver;


    /**
     * The below method is the consturctor for the driver
     * @param driver
     */
    public TestBase(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public TestBase() {

    }


    /**
     * The below method is used to read the driver from the global properties and pass the url
     */

    public void readExecutionProperties(){

        try {

            FileInputStream fis = null;

            fis = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "properties" + File.separator + "execution.properties");
            prop.load(fis);

            baseurl = prop.getProperty("baseurl");
            browser = prop.getProperty("browser");


            if (browser.equalsIgnoreCase("chrome")) {
                driver = WebDriverManager.chromedriver().create();
                driver.manage().window().maximize();
                driver.get(baseurl);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Below method with quit the driver instance
     */
    public void quitBrowser()
    {
        driver.quit();
    }
}
