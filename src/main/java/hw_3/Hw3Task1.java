package hw_3;

import driver_init.DriverInit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import waiters.CustomWaiters;

import java.time.Duration;
import java.util.ArrayList;

public class Hw3Task1 {

    private static class Urls {
        private static final String googleSearch = "https://www.google.com/search";
        private static final String guinnessPage = "https://www.guinnessworldrecords.com/account/register?";
        private static final String alertsDemo = "https://www.hyrtutorials.com/p/alertsdemo.html";
        private static final String w3schools = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";
    }

    private static class LocatorsGoogle {
        private static final By link1 = By.xpath("//h3[@class='LC20lb MBeuO DKV0Md' and contains(text(), 'Create account')]");
        private static final By link2 = By.xpath("//h3[contains(text(), 'AlertsDemo')]");
        private static final By clearButton = By.xpath("//span[@class='ExCKkf z1asCe rzyADb']");
        private static final By textArea1 = By.xpath("//textarea[@class='gLFyf' and @id='APjFqb' and @name='q']");
        private static final By textArea2 = By.xpath("//*[@id='APjFqb']");
    }

    private static class LocatorsW3Schools {
        private static final By firstNameW3 = By.name("fname");
        private static final By lastNameW3 = By.name("lname");
        private static final By submitButton = By.xpath("/html/body/form/input[3]");
        private static final By noteText = By.xpath("/html/body/div[2]/p");
    }

    private static class LocatorsGuinness {
        private static final By lastNameG = By.id("LastName");
        private static final By firstNameG = By.id("FirstName");
        private static final By birthDay = By.id("DateOfBirthDay");
        private static final By birthMonth = By.id("DateOfBirthMonth");
        private static final By birthYear = By.id("DateOfBirthYear");
        private static final By countrySelector = By.id("Country");
        private static final By stateSelector = By.id("State");
        private static final By emailAddress = By.id("EmailAddress");
        private static final By emailAddressConfirm = By.id("ConfirmEmailAddress");
        private static final By password = By.id("Password");
        private static final By passwordConfirm = By.id("ConfirmPassword");
        private static final By passwordText = By.xpath("//span[contains(text(), 'do not match.')]");
    }


    // открываем все вкладки
    public static void openAllPages(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get(Urls.googleSearch);
        WebElement textArea1 = driver.findElement(LocatorsGoogle.textArea1);

        actions.sendKeys(textArea1, Urls.guinnessPage).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        WebElement link1 = driver.findElement(LocatorsGoogle.link1);

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            actions.keyDown(Keys.COMMAND).click(link1).keyUp(Keys.COMMAND).perform();
        } else {
            actions.keyDown(Keys.CONTROL).click(link1).keyUp(Keys.CONTROL).perform();
        }

        WebElement textArea2 = driver.findElement(LocatorsGoogle.textArea2);


        driver.findElement(LocatorsGoogle.clearButton).click();
        actions.sendKeys(textArea2, Urls.alertsDemo).sendKeys(Keys.ENTER).perform();

        WebElement link2 = driver.findElement(LocatorsGoogle.link2);


        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            actions.keyDown(Keys.COMMAND).click(link2).keyUp(Keys.COMMAND).perform();
        } else {
            actions.keyDown(Keys.CONTROL).click(link2).keyUp(Keys.CONTROL).perform();
        }

    }


   // выполняем действия на странице школы
    public static void sendName (WebDriver driver) throws InterruptedException {
        driver.get(Urls.w3schools);

        Thread.sleep(3000);
        /*
        try {
            driver.findElement(By.id("accept-choices")).click();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
         */

        WebElement innerIframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(innerIframe);

        WebElement firstName = driver.findElement(LocatorsW3Schools.firstNameW3);
        WebElement lastName = driver.findElement(LocatorsW3Schools.lastNameW3);
        WebElement submitButton = driver.findElement(LocatorsW3Schools.submitButton);

        firstName.clear();
        firstName.sendKeys("Polina");
        lastName.clear();
        lastName.sendKeys("Sydorenko");
        submitButton.click();
        Thread.sleep(3000);
        WebElement noteText = driver.findElement(LocatorsW3Schools.noteText);
        System.out.println(noteText.getText());
        driver.switchTo().defaultContent();
    }

    // выполняем действия на странице гиннеса
    public static void fillRegistrationForm (WebDriver driver) throws InterruptedException {
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
        CustomWaiters waiters = new CustomWaiters(driver);
        //Thread.sleep(3000);
        waiters.waitForVisibility(driver.findElement(LocatorsGuinness.lastNameG)).sendKeys("Polina");
        driver.findElement(LocatorsGuinness.firstNameG).sendKeys("Sydorenko");
        driver.findElement(LocatorsGuinness.birthDay).sendKeys("07");
        driver.findElement(LocatorsGuinness.birthMonth).sendKeys("06");
        driver.findElement(LocatorsGuinness.birthYear).sendKeys("1997");

        new Select(driver.findElement(LocatorsGuinness.countrySelector)).selectByVisibleText("Ukraine");

        driver.findElement(LocatorsGuinness.stateSelector).sendKeys("Kyiv");

        driver.findElement(LocatorsGuinness.emailAddress).sendKeys("mail@mail.cim");
        driver.findElement(LocatorsGuinness.emailAddressConfirm).sendKeys("mail@mail.cim");

        driver.findElement(LocatorsGuinness.password).sendKeys("12345");
        Actions actions = new Actions(driver);
        driver.findElement(LocatorsGuinness.passwordConfirm).sendKeys("1234567");
        actions.sendKeys(Keys.ENTER).perform();

        System.out.println(driver.findElement(LocatorsGuinness.passwordText).getText());

    }


    //алерты
    public static void alertPage (WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        for (String tab : tabs) {
            driver.switchTo().window(tab);
            if (driver.getCurrentUrl().equals("https://www.hyrtutorials.com/p/alertsdemo.html")) {
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='alertBox' and @onclick='alertFunction()']"))).click();
    Alert alert1 = driver.switchTo().alert();
    alert1.accept();
    WebElement text1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
    System.out.println(text1.getText());


    wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmBox"))).click();
    Alert alert2 = driver.switchTo().alert();
    alert2.dismiss();
    WebElement text2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
    System.out.println(text2.getText());

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 100)");


    wait.until(ExpectedConditions.elementToBeClickable(By.id("promptBox"))).click();
    Alert alert3 = driver.switchTo().alert();
    alert3.sendKeys("Final step of this task");
    alert3.accept();
    WebElement text3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
    System.out.println(text3.getText());

}
        public static void main (String[]args) throws InterruptedException {
            WebDriver driver = DriverInit.setUpDriver();
            openAllPages(driver);
            sendName(driver);
            fillRegistrationForm(driver);
            alertPage(driver);
            driver.quit();
        }

}


