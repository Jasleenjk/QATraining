import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FireFox {


        public static void main(String[] args)
        {
            System.setProperty("webdriver.gecko.driver", ".//exefile/IEDriverServer.exe");
            WebDriver driver = new FirefoxDriver();
            driver.get("http://www.google.com");
        }

    }

