package hw_1;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Task4 {
    /*Написати програму, яка повторює дію на відео "HW_AUTOMATION_LESSON_3_UPDATE.mp4" (
    https://drive.google.com/file/d/1KgKqGuhvfArTH47iWvI5SCx2sKHdIte0/view).

    http://www.automationpractice.pl/index.php

    k.1 = "Printed Chiffon Dress"
    k.2 = "Faded Short"
    */

    private static class CurrentStrings{
        private static final String mainUrl = "http://www.automationpractice.pl/index.php";
        private static final String textOne = "Printed Chiffon Dress";
        private static final String textTwo = "Faded Short";

    }

    private static class Locators {
    private static final By searchField = By.xpath("//*[@id='search_query_top']");
    private static final By searchButton = By.xpath("//*[@id='searchbox']/button");
    private static final By firstDressButton = By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a");
    private static final By secondDressButton = By.xpath("///*[@id='center_column']/ul/li/div/div[2]/div[2]/a");
    private static final By cartButtonFirst = By.xpath("//*[@id='add_to_cart']/button/span");
    private static final By continueShoppingButton = By.xpath("////div[4]/span/span");
    private static final By womenButton = By.xpath("//*[@id='block_top_menu']/ul/li[1]/a");
    private static final By cartButtonSecond = By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a");
    private static final By sizeElement = By.id("group_1");


        public static void main(String[] args) {
            //вызывыем драйвер, открываем страницу
            WebDriver driver = DriverInit.setUpDriver();
            driver.get(CurrentStrings.mainUrl);

            //вводим поиск
            WebElement searchField = driver.findElement(Locators.searchField);
            searchField.sendKeys(CurrentStrings.textOne);
            WebElement searchButton = driver.findElement(Locators.searchButton);
            searchButton.click();

            //переходим на платье
            WebElement firstDressButton = driver.findElement(Locators.firstDressButton);
            firstDressButton.click();

            //селектор размера
            WebElement sizeElement = driver.findElement(Locators.sizeElement);
            Select sizeSelect = new Select(sizeElement);
            sizeSelect.selectByVisibleText("M");

            // добавляем в корзину
            WebElement addToCartButton = driver.findElement(Locators.cartButtonFirst);
            addToCartButton.click();

            // возвращаемся к покупкам
            WebElement continueShoppingButton = driver.findElement(Locators.continueShoppingButton);
            continueShoppingButton.click();

            // нажимаем вумен
            WebElement womenButton = driver.findElement(Locators.womenButton);
            womenButton.click();

            //второй поиск
            searchField.sendKeys(CurrentStrings.textTwo);
            searchButton.click();

            //второе платье в корзину
            WebElement secondDressButton = driver.findElement(Locators.secondDressButton);
            secondDressButton.click();
            addToCartButton.click();
            continueShoppingButton.click();

            //переходим в корзину
            WebElement cartButtonSecond = driver.findElement(Locators.cartButtonSecond);
            cartButtonSecond.click();

            driver.quit();


        }







}






}
