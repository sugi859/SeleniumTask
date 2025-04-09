package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        driver.findElement(By.id("datepicker")).click();

        driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
        driver.findElement(By.xpath("//a[text()='22']")).click();

        String selectedDate = driver.findElement(By.id("datepicker")).getAttribute("value");
        System.out.println("Selected Date: " + selectedDate);

        driver.quit();
    }
}