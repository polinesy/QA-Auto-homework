package hw_3;

import driver_init.DriverInit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import waiters.CustomWaiters;

import java.util.ArrayList;

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
        driver.get(Hw3TestLocators.Urls1.googleSearch);
        WebElement textArea1 = waiters.waitForVisibility(driver.findElement(Hw3TestLocators.LocatorsGoogle1.textArea1));
        actions.sendKeys(textArea1, Hw3TestLocators.Urls1.guinnessPage).sendKeys(Keys.ENTER).perform();
        WebElement link1 = waiters.waitForVisibility(driver.findElement(Hw3TestLocators.LocatorsGoogle1.link1));

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            actions.keyDown(Keys.COMMAND).click(link1).keyUp(Keys.COMMAND).perform();
        } else {
            actions.keyDown(Keys.CONTROL).click(link1).keyUp(Keys.CONTROL).perform();
        }

        WebElement textArea2 = waiters.waitForVisibility(driver.findElement(Hw3TestLocators.LocatorsGoogle1.textArea2));

        driver.findElement(Hw3TestLocators.LocatorsGoogle1.clearButton).click();
        actions.sendKeys(textArea2, Hw3TestLocators.Urls1.alertsDemo).sendKeys(Keys.ENTER).perform();

        WebElement link2 = driver.findElement(Hw3TestLocators.LocatorsGoogle1.link2);


        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            actions.keyDown(Keys.COMMAND).click(link2).keyUp(Keys.COMMAND).perform();
        } else {
            actions.keyDown(Keys.CONTROL).click(link2).keyUp(Keys.CONTROL).perform();
        }

    }

    @Test (dependsOnMethods = {"testOpenWindows"})
    public void sendNameSchools(){
        driver.get(Hw3TestLocators.Urls1.w3schools);

        /*
        try {
            waiters.clickableStateOfElement(By.id("accept-choices")).click();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        //------> у меня все время выдает ошибку локатора на этмо сайте, а куки не появляются
         */

        waiters.switchToFrame(By.xpath("//iframe[@id='iframeResult']"));

        WebElement firstName = driver.findElement(Hw3TestLocators.LocatorsW3Schools1.firstNameW3);
        WebElement lastName = driver.findElement(Hw3TestLocators.LocatorsW3Schools1.lastNameW3);
        WebElement submitButton = driver.findElement(Hw3TestLocators.LocatorsW3Schools1.submitButton);

        firstName.clear();
        firstName.sendKeys("Polina");
        lastName.clear();
        lastName.sendKeys("Sydorenko");
        submitButton.click();

        WebElement noteText = waiters.waitForVisibility(By.xpath("//p[a[@href='/php/default.asp']]"));
        System.out.println(noteText.getText());
        driver.switchTo().defaultContent();
    }

    @Test (dependsOnMethods = {"sendNameSchools"})
    public void fillRegistrationFormGuinness() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (String tab : tabs) {
            driver.switchTo().window(tab);
            if (driver.getCurrentUrl().startsWith("https://www.guinnessworldrecords.com")) {
                try {
                    driver.findElement(By.id("ez-accept-all")).click();
                } catch (NoSuchElementException e) {
                    System.out.println("No cookies button");
                }
            }
        }

        waiters.waitForVisibility(By.xpath("//*[@id='LastName']"));
        driver.findElement(Hw3TestLocators.LocatorsGuinness1.lastNameG).sendKeys("Polina");
        driver.findElement(Hw3TestLocators.LocatorsGuinness1.firstNameG).sendKeys("Sydorenko");
        driver.findElement(Hw3TestLocators.LocatorsGuinness1.birthDay).sendKeys("07");
        driver.findElement(Hw3TestLocators.LocatorsGuinness1.birthMonth).sendKeys("06");
        driver.findElement(Hw3TestLocators.LocatorsGuinness1.birthYear).sendKeys("1997");

        new Select(driver.findElement(Hw3TestLocators.LocatorsGuinness1.countrySelector)).selectByVisibleText("Ukraine");

        driver.findElement(Hw3TestLocators.LocatorsGuinness1.stateSelector).sendKeys("Kyiv");

        driver.findElement(Hw3TestLocators.LocatorsGuinness1.emailAddress).sendKeys("mail@mail.cim");
        driver.findElement(Hw3TestLocators.LocatorsGuinness1.emailAddressConfirm).sendKeys("mail@mail.cim");

        driver.findElement(Hw3TestLocators.LocatorsGuinness1.password).sendKeys("12345");
        driver.findElement(Hw3TestLocators.LocatorsGuinness1.passwordConfirm).sendKeys("1234567");
        actions.sendKeys(Keys.ENTER).perform();

        System.out.println(driver.findElement(Hw3TestLocators.LocatorsGuinness1.passwordText).getText());

    }

    @Test(dependsOnMethods = {"fillRegistrationFormGuinness"})
    public void alertPage(){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        for (String tab : tabs) {
            driver.switchTo().window(tab);
            if (driver.getCurrentUrl().equals("https://www.hyrtutorials.com/p/alertsdemo.html")) {
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());

        waiters.clickableStateOfElement(By.xpath("//button[@id='alertBox' and @onclick='alertFunction()']")).click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        WebElement text1 = waiters.waitForVisibility(By.id("output"));
        System.out.println(text1.getText());


        waiters.clickableStateOfElement(By.id("confirmBox")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
        WebElement text2 = waiters.waitForVisibility(By.id("output"));
        System.out.println(text2.getText());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 100)");


        waiters.clickableStateOfElement(By.id("promptBox")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Final step of this task");
        alert3.accept();
        WebElement text3 = waiters.waitForVisibility(By.id("output"));
        System.out.println(text3.getText());


    }











}
