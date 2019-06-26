import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TaskAssertion {
    public static void main(String[] args) throws Exception {


        System.setProperty("webdriver.chrome.driver", ".//exefile/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        //For Maximize
        driver.manage().window().maximize();
        driver.get("https://www.irctc.co.in/nget/train-search");

        Actions ac3t = new Actions(driver);
       /* try {
            driver.findElement(By.className("fa fa-window-close pull-right")).click();
        }
        catch (ElementNotVisibleException e){
            System.out.println(e);
        }*/
        String pageTitle = driver.getTitle();

        Assert.assertEquals("IRCTC Next Generation eTicketing System", pageTitle);
        driver.findElement(By.xpath("//input[@placeholder=\"From*\"]")).sendKeys("Delhi");


        Actions act = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='DELHI - DLI']")));
        WebElement field1 = driver.findElement(By.xpath("//span[text()='DELHI - DLI']"));
        act.moveToElement(field1).click(field1).perform();


        driver.findElement(By.xpath("//input[@placeholder=\"To*\"]")).sendKeys("Chandigarh");

        WebDriverWait hold = new WebDriverWait(driver, 10);
        Actions act1 = new Actions(driver);
        hold.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='CHANDIGARH - CDG']")));
        WebElement field2 = driver.findElement(By.xpath("//span[text()='CHANDIGARH - CDG']"));
        act1.moveToElement(field2).click(field2).perform();

        WebDriverWait stop = new WebDriverWait(driver, 10);
        Actions act2 = new Actions(driver);
        stop.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ui-button-icon-left ui-clickable fa fa-fw fa-calendar']")));

        WebElement field3 = driver.findElement(By.xpath("//span[text()='ui-btn']"));
        act1.moveToElement(field3).click(field3).perform();
        WebElement field5 = driver.findElement(By.xpath("//span[@class='fa fa-angle-right']"));
        act1.moveToElement(field5).click(field5).perform();


        WebElement field4 = driver.findElement(By.xpath("(//a[text()='30'])[2]"));
        act1.moveToElement(field4).click(field4).perform();
        driver.findElement(By.xpath("//button[text()='Find trains']")).click();
        Thread.sleep(5000);
        WebElement ver = driver.findElement(By.xpath("(//button[text()='Modify Search'])[1]"));
        Assert.assertTrue(ver.isDisplayed());

        WebElement ver2 = driver.findElement(By.xpath("//label[@class='ng-tns-c13-17 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']"));
        Assert.assertEquals("All Classes", ver2.getText());

        WebElement ver3 = driver.findElement(By.xpath("(//label[text()='DELHI(DLI)'])[1]"));


        Assert.assertEquals("DELHI(DLI)", ver3.getText());
        WebElement sel =driver.findElement(By.xpath("(//input[@id='DLI'])[1]"));
        Assert.assertTrue(sel.isSelected());


        WebElement ver4 = driver.findElement(By.xpath("(//label[text()='CHANDIGARH(CDG)'])[1]"));
        Assert.assertEquals("CHANDIGARH(CDG)", ver4.getText());
        WebElement sel2=driver.findElement(By.xpath("(//input[@id='CDG'])[1]"));
        Assert.assertTrue(sel2.isSelected());


        WebElement ver5 = driver.findElement(By.xpath("//span[text()='30 Jul']"));
        Assert.assertEquals("30 Jul", ver5.getText());


        //10 of 10 trains found


        int Count = 0;
        Count = driver.findElements(By.xpath("//button[text()=\" Check availability & fare \"]")).size();
        String total = driver.findElement(By.xpath("//div[@class='col-md-12 hidden-xs']//b")).getText();
        String count=Integer.toString(Count);
        Assert.assertEquals(total,count+" of "+count+" trains found");

       // List<WebElement> buttonCount = driver.findElements(By.id("heck-availability"));
       // System.out.println("List size is: " +buttonCount.size());



        WebElement button = driver.findElement(By.xpath("//a[text()=' FLIGHTS ']"));
        button.click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while (((Iterator) it).hasNext()) {
            driver.switchTo().window(it.next());
        }


        String pageTitle2 = driver.getTitle();
        System.out.println(pageTitle2);
        Assert.assertEquals("Air Ticket Booking | Book Flight Tickets | Cheap Air Fare - IRCTC Air ",pageTitle2);


    }
}
