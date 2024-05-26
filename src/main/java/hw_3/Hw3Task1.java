package hw_3;

import driver_init.DriverInit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Hw3Task1 {

    private static class Urls {
        private static final String googleSearch = "https://www.google.com/search";
        private static final String guinnessPage = "https://www.guinnessworldrecords.com/account/register?";
        private static final String alertsDemo = "https://www.hyrtutorials.com/p/alertsdemo.html";
        private static final String w3schools = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";
    }
    private static class LocatorsGoogle {
        private static final By link1 = By.xpath("//*[@id='rso']/div[1]/div/div/div/div[1]/div/div/span/a/h3");
        private static final By link2 = By.xpath("//h3[contains(text(), 'AlertsDemo')]");
        private static final By clearButton =  By.xpath("//*[@id='tsf']/div[1]/div[1]/div[2]/div/div[3]/div[1]/div/span/svg");
        private static final By textArea1 = By.xpath("//textarea[@class='gLFyf' and @id='APjFqb' and @name='q']");
        private static final By textArea2 = By.xpath("//*[@id='APjFqb']");
    }
    private static class LocatorsW3Schools {
        private static final By firstNameW3 = By.name("fname");
        private static final By lastNameW3 = By.name("lname");
        private static final By submitButton = By.xpath("/html/body/form/input[3]");
        private static final By noteText = By.xpath("/html/body/div[2]/p");
    }

    private static class LocatorsGuinness{
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
        private static final By passwordText = By.xpath("//span[contains(text(), 'Confirm password' and 'Password' do not match.')]");
    }



    // шаг 1 - открываем все вкладки
    public static void openAllPages (WebDriver driver) {
        Actions actions = new Actions(driver);
        driver.get(Urls.googleSearch);
        WebElement textArea1 = driver.findElement(LocatorsGoogle.textArea1);
        WebElement textArea2 = driver.findElement(LocatorsGoogle.textArea2);
        WebElement link1 = driver.findElement(LocatorsGoogle.link1);
        WebElement link2 = driver.findElement(LocatorsGoogle.link2);
        //ищем по ссылке
        actions.sendKeys(textArea1, Urls.guinnessPage).sendKeys(Keys.ENTER).perform();

        // открываем вкладку 1 в новом окне
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            actions.keyDown(Keys.COMMAND).click(link1).keyUp(Keys.COMMAND).perform();
        } else {
            actions.keyDown(Keys.CONTROL).click(link1).keyUp(Keys.CONTROL).perform();
        }

        //ищем по второй ссылке
        driver.findElement(LocatorsGoogle.clearButton).click();
        actions.sendKeys(textArea2, Urls.alertsDemo).sendKeys(Keys.ENTER).perform();

        //открываем вторую ссылку в новом окне
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            actions.keyDown(Keys.COMMAND).click(link2).keyUp(Keys.COMMAND).perform();
        } else {
            actions.keyDown(Keys.CONTROL).click(link2).keyUp(Keys.CONTROL).perform();
        }

        driver.get(Urls.w3schools);
    }

   // выполняем действия на странице школы
    public static void sendName (WebDriver driver) {

        try {
            driver.findElement(By.id("accept-choices")).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        WebElement firstName = driver.findElement(LocatorsW3Schools.firstNameW3);
        WebElement lastName = driver.findElement(LocatorsW3Schools.lastNameW3);
        WebElement submitButton = driver.findElement(LocatorsW3Schools.submitButton);
        WebElement noteText = driver.findElement(LocatorsW3Schools.noteText);

        driver.switchTo().frame("iframeResult");
        firstName.clear();
        firstName.sendKeys("Polina");
        lastName.clear();
        lastName.sendKeys("Sydorenko");
        submitButton.click();
        System.out.println(noteText.getText());
        driver.switchTo().defaultContent();
    }

    // выполняем действия на странице гиннеса
    public static void fillRegistrationForm (WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        try {
            driver.findElement(By.id("ez-accept-all")).click();
        }catch (NoSuchElementException e){
            System.out.println("No cookies button");
        }

        driver.findElement(LocatorsGuinness.lastNameG).sendKeys("Polina");
        driver.findElement(LocatorsGuinness.firstNameG).sendKeys("Sydorenko");
        driver.findElement(LocatorsGuinness.birthDay).sendKeys("07");
        driver.findElement(LocatorsGuinness.birthMonth).sendKeys("06");
        driver.findElement(LocatorsGuinness.birthYear).sendKeys("1997");

        new Select(driver.findElement(LocatorsGuinness.countrySelector)).selectByVisibleText("Ukraine");

        driver.findElement(LocatorsGuinness.stateSelector).sendKeys("Kyiv");

        driver.findElement(LocatorsGuinness.emailAddress).sendKeys("mail@mail.cim");
        driver.findElement(LocatorsGuinness.emailAddressConfirm).sendKeys("mail@mail.cim");

        driver.findElement(LocatorsGuinness.password).sendKeys("12345");
        driver.findElement(LocatorsGuinness.passwordConfirm).sendKeys("1234567");

        System.out.println(driver.findElement(LocatorsGuinness.passwordText).getText());

    }

    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        openAllPages(driver);
        sendName(driver);
        fillRegistrationForm(driver);
        driver.quit();
    }

}
