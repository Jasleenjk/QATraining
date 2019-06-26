import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WaitStatements {
    public static void main(String[]args) throws InterruptedException
    {
    System.setProperty("webdriver.chrome.driver", ".//exefile/chromedriver.exe");


    WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
    //For Maximize
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       driver.navigate().to("https://www.amazon.in/");
        WebElement element = driver.findElement(By.xpath("//a[text()=\"Today's Deals\"]"));
        element.click();
        driver.findElement(By.xpath("//span[@class='a-button-inner']")).click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"a-size-base s-inline s-access-title a-text-normal\"]"))).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while(((Iterator) it).hasNext()){
            driver.switchTo().window(it.next());
        }

       WebElement dropdown= driver.findElement(By.id("native_dropdown_selected_size_name"));
      Select SelectDD = new Select(dropdown);
        SelectDD.selectByIndex(2);
        //Thread.sleep(2000);
      WebDriverWait Stop=new WebDriverWait(driver,5);
      Stop.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
     WebElement Button =driver.findElement(By.id("add-to-cart-button"));
     Button.click();






    }}
