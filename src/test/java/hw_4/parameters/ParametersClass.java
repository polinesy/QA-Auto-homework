package hw_4.parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import waiters.CustomWaiters;

public class ParametersClass {

    static WebDriver driver;
    static CustomWaiters waiters;

    static Actions actions;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        waiters = new CustomWaiters(driver);
        actions = new Actions(driver);
    }
    @AfterClass
    public void close() {
        driver.quit();
    }

    @Test
    @Parameters("searchWord")
    public void testSearch(String searchWord){
        driver.get("https://www.foxtrot.com.ua/");

        waiters.waitForVisibility(By.xpath("//input[@type='search' " +
                "and contains(@class, 'header-search__field')]")).sendKeys(searchWord);
        actions.sendKeys(Keys.ENTER).perform();

        WebElement searchResult = waiters.waitForVisibility(driver.findElement(By.xpath("//div[@class='page__title']/h1[contains(text(), 'Знайдено по запиту')]")));
        String searchResultText = searchResult.getText();

        if (searchResultText.contains(searchWord)) {
            System.out.println("Результати пошуку для '" + searchWord + "' знайдено успішно.");
        } else {
            System.out.println("Результати пошуку для '" + searchWord + "' не знайдено.");
        }

    }

}
