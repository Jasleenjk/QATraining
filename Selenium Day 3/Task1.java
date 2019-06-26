
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", ".//exefile/chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Jasleen/Downloads/webpage.html");
        driver.findElement(By.id("user")).sendKeys("Jasleen");
        driver.findElement(By.id("female")).click();
        String Text =driver.findElement(By.linkText("FACEBOOK")).getText();
        System.out.println("GetText : "+Text);
       String Placeholder= driver.findElement(By.id("pwd")).getAttribute("Placeholder");
        System.out.println("PlaceHolder : "+Placeholder);
       Dimension Size = driver.findElement(By.id("pwd")).getSize();
        System.out.println("Size : "+Size);
        Point Location = driver.findElement(By.id("pwd")).getLocation();
        System.out.println(Location);
      String FontSize= driver.findElement(By.xpath("//h1[contains(text(),' Automation')]")).getCssValue("font-size");
        System.out.println("FontSize: "+FontSize);
     boolean Enabled=driver.findElement(By.xpath("//input[@value='LOGIN']")).isEnabled();
        System.out.println(Enabled);
        boolean Displayed= driver.findElement(By.xpath("//input[@type='button']")).isDisplayed();
        System.out.println(Displayed);
        boolean Selected =driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).isSelected();
        System.out.println(Selected);






    }
}