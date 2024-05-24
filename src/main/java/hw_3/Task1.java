package hw_3;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Task1 {

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

   /* private static class LocatorsW3Schools {
        private static final By firstName = By.xpath("//textarea[@id='APjFqb']");
    }*/

    // шаг 1 - открываем все вкладки
    public static void openAllPages (WebDriver driver, WebElement textArea1, WebElement textArea2, WebElement link1, WebElement link2) {
        Actions actions = new Actions(driver);
        driver.get(Urls.googleSearch);
        textArea1 = driver.findElement(LocatorsGoogle.textArea1);
        textArea2 = driver.findElement(LocatorsGoogle.textArea2);
        link1 = driver.findElement(LocatorsGoogle.link1);
        link2 = driver.findElement(LocatorsGoogle.link2);
        //ищем по ссылке
        actions.sendKeys(textArea1, Urls.guinnessPage).sendKeys(Keys.ENTER).perform();

        // открываем вкладку 1 в новом окне
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            // Для MacOS используем клавишу Command
            actions.keyDown(Keys.COMMAND).click(link1).keyUp(Keys.COMMAND).perform();
        } else {
            // Для Windows и других используем клавишу Control
            actions.keyDown(Keys.CONTROL).click(link1).keyUp(Keys.CONTROL).perform();
        }

        //ищем по второй ссылке
        driver.findElement(LocatorsGoogle.clearButton).click();
        actions.sendKeys()





        //actions.

    }



}
