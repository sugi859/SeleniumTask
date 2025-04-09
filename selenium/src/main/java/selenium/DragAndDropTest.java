package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        new Actions(driver).dragAndDrop(source, target).perform();

        String dropText = target.getText();
        String dropColor = target.getCssValue("background-color");

        if (dropText.equals("Dropped!")) {
            System.out.println("Drag and drop successful. Color: " + dropColor);
        } else {
            System.out.println("Drag and drop failed.");
        }

        driver.quit();
    }
}