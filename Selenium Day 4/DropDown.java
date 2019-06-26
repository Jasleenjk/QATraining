import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown
{
    public static void main(String[] args) throws InterruptedException {
      System.setProperty("webdriver.chrome.driver", ".//exefile/chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Jasleen/Downloads/webpage.html");
        WebElement boys= driver.findElement(By.name("boys"));
        Select SelectBoys = new Select(boys);
        SelectBoys.selectByIndex(5);
        Thread.sleep(2000);

        SelectBoys.selectByVisibleText("Chess");

        Thread.sleep(2000);

        SelectBoys.selectByValue("5");
        Thread.sleep(2000);

        //Select for multiple dropdown
     WebElement girls =driver.findElement(By.name("girls"));
     Select SelectGirls = new Select(girls);
     SelectGirls.selectByValue("1");
        SelectGirls.selectByValue("2");
        SelectGirls.selectByValue("5");
        SelectGirls.selectByValue("3");
        Thread.sleep(2000);
        System.out.println(SelectGirls.getFirstSelectedOption().getText());
        List<WebElement> selectedOptions = SelectGirls.getAllSelectedOptions();
        for(int i=0;i<selectedOptions.size();i++){
            System.out.println(selectedOptions.get(i).getText());
        }


       // System.out.println(SelectGirls.getOptions());
       boolean Value= SelectBoys.isMultiple();
        System.out.println(Value);
        SelectGirls.deselectByIndex(2);
        Thread.sleep(2000);
        SelectGirls.deselectByValue("1");
        Thread.sleep(2000);
        SelectGirls.deselectByVisibleText("Chocklate");
        Thread.sleep(2000);
        SelectGirls.deselectAll();

    }}
