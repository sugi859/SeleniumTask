package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Switch to top frame
        driver.switchTo().frame("frame-top");

        // Switch to left frame and verify
        driver.switchTo().frame("frame-left");
        System.out.println("Left frame text: " + driver.findElement(By.tagName("body")).getText());

        // Switch to middle frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        System.out.println("Middle frame text: " + driver.findElement(By.id("content")).getText());

        // Switch to right frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println("Right frame text: " + driver.findElement(By.tagName("body")).getText());

        // Switch to bottom frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println("Bottom frame text: " + driver.findElement(By.tagName("body")).getText());

        // Verify title (though the page has no title in HTML)
        driver.switchTo().defaultContent();
        System.out.println("Page title: " + driver.getTitle());

        driver.quit();
    }
}
