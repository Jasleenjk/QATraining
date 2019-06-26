
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Task2 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", ".//exefile/chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        //For Maximize
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.in/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        String title=driver.getTitle();
        System.out.println("Title :"+title);
       String CurrentUrl= driver.getCurrentUrl();
        System.out.println("Current URL :"+CurrentUrl);
      String PageSource= driver.getPageSource();
        System.out.println("PageSource"+PageSource);
       String WindowHandle= driver.getWindowHandle();
        System.out.println("WindowHandle :"+WindowHandle);

        driver.findElement(By.xpath("//a[@class='desktop-main'][text()='Kids']")).click();
        Set<String> sessions=driver.getWindowHandles();
        Iterator<String> itr=sessions.iterator();
        String parentID=itr.next();
        System.out.println(parentID);
        String childID=itr.next();
        System.out.println(childID);
        driver.switchTo().window(childID);
        driver.close();


        //for pause of time

        Thread.sleep(01750);

        //to minimize
        Dimension dimension = new Dimension(400, 700);
        driver.manage().window().setSize(dimension);
        driver.quit();


    }

}


