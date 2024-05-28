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

public class Hw3TestLocators {

    public static class Urls1 {
        public static final String googleSearch = "https://www.google.com/search";
        public static final String guinnessPage = "https://www.guinnessworldrecords.com/account/register?";
        public static final String alertsDemo = "https://www.hyrtutorials.com/p/alertsdemo.html";
        public static final String w3schools = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";
    }

    public static class LocatorsGoogle1 {
        public static final By link1 = By.xpath("//h3[@class='LC20lb MBeuO DKV0Md' and contains(text(), 'Create account')]");
        public static final By link2 = By.xpath("//h3[contains(text(), 'AlertsDemo')]");
        public static final By clearButton = By.xpath("//span[@class='ExCKkf z1asCe rzyADb']");
        public static final By textArea1 = By.xpath("//textarea[@class='gLFyf' and @id='APjFqb' and @name='q']");
        public static final By textArea2 = By.xpath("//*[@id='APjFqb']");
    }

    public static class LocatorsW3Schools1 {
        public static final By firstNameW3 = By.name("fname");
        public static final By lastNameW3 = By.name("lname");
        public static final By submitButton = By.xpath("/html/body/form/input[3]");
        public static final By noteText = By.xpath("//p[a[@href='/php/default.asp']]");
    }

    public static class LocatorsGuinness1 {
        public static final By lastNameG = By.id("LastName");
        public static final By firstNameG = By.id("FirstName");
        public static final By birthDay = By.id("DateOfBirthDay");
        public static final By birthMonth = By.id("DateOfBirthMonth");
        public static final By birthYear = By.id("DateOfBirthYear");
        public static final By countrySelector = By.id("Country");
        public static final By stateSelector = By.id("State");
        public static final By emailAddress = By.id("EmailAddress");
        public static final By emailAddressConfirm = By.id("ConfirmEmailAddress");
        public static final By password = By.id("Password");
        public static final By passwordConfirm = By.id("ConfirmPassword");
        public static final By passwordText = By.xpath("//span[contains(text(), 'do not match.')]");
    }

}


