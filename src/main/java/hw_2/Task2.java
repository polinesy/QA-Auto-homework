package hw_2;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Task2 {
    /*
    https://demo.guru99.com/test/drag_drop.html
    Написати програму, яка автоматизуватиме сценарій показаний на відео "Сценарій для автоматизії.mov". (https://drive.google.com/file/d/16Qzzmm-F5U_P1PVf28TSoEBux-2TRkKM/view)
    Після виконання сценарію відео вивести в консоль теуст кнопки "Perfect!"
     */

    private static final String  mainUrl = "https://demo.guru99.com/test/drag_drop.html";

    private static class Locators {
        private static final By accountFirst = By.xpath("//*[@id='bank']/li");
        private static final By accountSecond = By.xpath("//*[@id='loan']/li");
        private static final By amountFirst = By.xpath("//*[@id='amt7']/li");
        private static final By amountSecond = By.xpath("//*[@id='shoppingCart4']/div");
        private static final By button5000First = By.xpath("//*[@id='fourth']/a");
        private static final By button5000Second = By.xpath("//*[@id='fourth']/a");
        private static final By buttonBank = By.xpath("//*[@id='credit2']/a");
        private static final By buttonSales = By.xpath("//*[@id='credit1']/a");

    }

    public static void dragNDrop(By source, By target, WebDriver driver){
        new Actions(driver).dragAndDrop(driver.findElement(source),
                driver.findElement(target)).perform();
    }

        public static void main(String[] args) {
            WebDriver driver = DriverInit.setUpDriver();
            driver.get(mainUrl);

            Actions actions = new Actions(driver);
            Task2.dragNDrop(Locators.button5000First, Locators.amountFirst, driver);
            Task2.dragNDrop(Locators.button5000Second, Locators.amountSecond, driver);
            Task2.dragNDrop(Locators.buttonBank, Locators.accountFirst, driver);
            Task2.dragNDrop(Locators.buttonSales, Locators.accountSecond, driver);

            driver.quit();




        }

    }



