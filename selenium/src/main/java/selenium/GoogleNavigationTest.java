package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleNavigationTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver(); // Launch Chrome
        driver.manage().window().maximize(); // Maximize window

        driver.get("https://www.google.com"); // Navigate to Google
        System.out.println("Current URL: " + driver.getCurrentUrl()); // Print URL

        driver.navigate().refresh(); // Reload the page
        driver.quit(); // Close the browser
    }
}