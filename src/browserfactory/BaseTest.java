package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest
{
    public WebDriver driver;
    public String browser="Chrome";
    public String baseUrl="https://demo.nopcommerce.com/";

    public void setUpBrowser()
    {
        // Launch the browser
        if(browser.equalsIgnoreCase("Chrome"))
        {
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Edge"))
        {
            driver=new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox"))
        {
            driver=new FirefoxDriver();
        }
        else
        {
            System.out.println("Enter only Firefox, Chrome or Edge browser for testing");
        }

        // Open URL
        driver.get(baseUrl);

        // Maximize the browser screen
        driver.manage().window().maximize();

        // Implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    // Close all browser open by Selenium
    public void closeBrowser()
    {
        driver.quit();
    }
}
