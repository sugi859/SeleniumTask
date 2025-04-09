package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaSearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.wikipedia.org");
        driver.findElement(By.id("searchInput")).sendKeys("Artificial Intelligence");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Wait for the page to load
        Thread.sleep(2000); 

        // Click on History section in Table of Contents (optional: scroll into view)
        WebElement historyLink = driver.findElement(By.xpath("//span[text()='History']/ancestor::a"));
        historyLink.click();

        // Print the section heading
        WebElement sectionHeading = driver.findElement(By.id("History"));
        System.out.println("Section Title: " + sectionHeading.getText());

        driver.quit();
    }
}