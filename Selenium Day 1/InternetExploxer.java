import org.openqa.selenium.WebDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExploxer {


    public static void main(String[] args)  {


         System.setProperty("webdriver.ie.driver", ".//exefile/IEDriverServer.exe");

        WebDriver driver = new InternetExplorerDriver();

        driver.get("http://www.google.com");
    }
}