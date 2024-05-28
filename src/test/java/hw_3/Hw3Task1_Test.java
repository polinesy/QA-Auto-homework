package hw_3;

import driver_init.DriverInit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import waiters.CustomWaiters;

public class Hw3Task1_Test {

    static WebDriver driver;
    static CustomWaiters waiters;
    static Actions actions;

    @BeforeClass
    public void setUp(){
        driver = DriverInit.setUpDriver();
        waiters = new CustomWaiters(driver);
        actions = new Actions(driver);
    }

    @AfterClass
    public void stopDriver(){
        driver.quit();
    }

    @Test
    public void testOpenWindows (){
        driver.get(Hw3Task1addition.Urls1.googleSearch);
        WebElement textArea1 = waiters.waitForVisibility(driver.findElement(Hw3Task1addition.LocatorsGoogle1.textArea1));
        actions.sendKeys(textArea1, Hw3Task1addition.Urls1.guinnessPage).sendKeys(Keys.ENTER).perform();
        WebElement link1 = waiters.waitForVisibility(driver.findElement(Hw3Task1addition.LocatorsGoogle1.link1));

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            actions.keyDown(Keys.COMMAND).click(link1).keyUp(Keys.COMMAND).perform();
        } else {
            actions.keyDown(Keys.CONTROL).click(link1).keyUp(Keys.CONTROL).perform();
        }

        WebElement textArea2 = waiters.waitForVisibility(driver.findElement(Hw3Task1addition.LocatorsGoogle1.textArea2));

        driver.findElement(Hw3Task1addition.LocatorsGoogle1.clearButton).click();
        actions.sendKeys(textArea2, Hw3Task1addition.Urls1.alertsDemo).sendKeys(Keys.ENTER).perform();

        WebElement link2 = driver.findElement(Hw3Task1addition.LocatorsGoogle1.link2);


        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            actions.keyDown(Keys.COMMAND).click(link2).keyUp(Keys.COMMAND).perform();
        } else {
            actions.keyDown(Keys.CONTROL).click(link2).keyUp(Keys.CONTROL).perform();
        }

    }

    @Test (dependsOnMethods = {"testOpenWindows"})
    public void sendNameSchools(){
        driver.get(Hw3Task1addition.Urls1.w3schools);

        try {
            waiters.clickableStateOfElement(By.id("accept-choices")).click();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }



    }








}
