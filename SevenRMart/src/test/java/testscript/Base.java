package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void initialiseBrowser(String browser) throws Exception {
    
        if (browser.equalsIgnoreCase("Chrome")) {
            
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
           
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Invalid Browser: " + browser);
        }

        
        driver.get("https://groceryapp.uniqassosiates.com/admin/login");

      
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void driverQuit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
