import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task3 {
    public Integer makeInt(String s1) {
        StringBuilder sb = new StringBuilder();
        String[] splitted = s1.split(",");
        for (int i = 0; i < splitted.length; i++) {
            sb.append(splitted[i]);
        }
        String withoutComma = sb.toString();
        return Integer.parseInt(withoutComma);
    }
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", ".//exefile/chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        //For Maximize
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.goibibo.com/");
        driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Delhi");
        Actions act = new Actions(driver);
        WebElement elec = driver.findElement(By.cssSelector("div[class='dib marginL10 pad0 textOverflow width90']"));
        act.moveToElement(elec).click(elec).perform();
        driver.findElement(By.id("gosuggest_inputDest")).sendKeys("Mumbai");
        WebElement elec2 = driver.findElement(By.cssSelector("div[class='dib marginL10 pad0 textOverflow width90']"));
        act.moveToElement(elec2).click(elec2).perform();
        driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
        WebElement elec4 = driver.findElement(By.xpath("//div[text()='25']"));
        act.moveToElement(elec4).click(elec4).perform();

        driver.findElement(By.xpath("//input[@placeholder='Return'] ")).click();
        WebElement elec3 = driver.findElement(By.xpath("//div[text()='26']"));
        act.moveToElement(elec3).click(elec3).perform();
        driver.findElement(By.id("pax_label")).click();

        for (int i = 0; i < 2; i++) {
            driver.findElement(By.id("adultPaxPlus")).click();
        }

        for (int i = 0; i < 1; i++) {
            driver.findElement(By.id("childPaxPlus")).click();
        }

        WebElement dropdown = driver.findElement(By.id("gi_class"));
        Select SelectGirls = new Select(dropdown);
        SelectGirls.selectByVisibleText("Business");


        driver.findElement(By.id("gi_search_btn")).click();


        WebElement e = driver.findElement(By.xpath("//span[text()='Price']"));
        act.moveToElement(e).perform();

          WebElement slider=driver.findElement(By.xpath("//div[@id=\"sliderFO\"]//div[@class=\"fltSld-handle fltSld-handle-1 \"]"));
          Task3 task3=new Task3();
        // act.clickAndHold(slider);
        for(int i=0;i<=500;i++){
            act.dragAndDropBy(slider,-i,0).perform();
            String s1 = driver.findElement(By.xpath("(//span[@id=\'fareMax\'])[1]")).getText();
            Integer value = task3.makeInt(s1);
            if(value<=180000){
                break;
            }


        }
        //act.dragAndDropBy(slider,-90,0).perform();


       // String s2 = driver.findElement(By.xpath("(//span[@id='fareMax'])[2]")).getText();


         WebElement slider2=driver.findElement(By.xpath("//div[@id=\"sliderFR\"]//div[@class=\"fltSld-handle fltSld-handle-1 \"]"));
        Task3 task32=new Task3();

        for(int j=0;j<=500;j++){
            act.dragAndDropBy(slider2,-j,0).perform();
            String s2 = driver.findElement(By.xpath("(//span[@id=\'fareMax\'])[2]")).getText();
            Integer value = task32.makeInt(s2);
            if(value<=150000){
                break;
            }


        }
        //  act.clickAndHold(slider2);
        //   act.dragAndDropBy(slider2,-60,0).perform();


    }


}
