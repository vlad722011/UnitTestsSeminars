package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSeleniumTask04 {
    @Test
    public  void browserTest () throws InterruptedException {
        System.setProperty("webdriver.geckodriver-v0.33.0-linux64",
                "/home/vlad/Downloads/geckodriver-v0.33.0-linux64/geckodriver");

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com/");

        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.sendKeys("https://www.selenium.dev");
        searchBox.submit();

        boolean isFind = false;

        List<WebElement> searchResult = webDriver.findElements(By.cssSelector("div"));
        for (WebElement element: searchResult) {
            if(element.getText().contains("https://www.selenium.dev")){
                isFind = true;
                break;
            }
        }
        webDriver.quit();
        assertTrue(isFind);
    }
}
