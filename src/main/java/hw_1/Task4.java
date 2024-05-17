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
    private static final By secondDressButton = By.xpath("//a[contains(text(), 'Faded Short Sleeve T-shirts')]");
    private static final By cartButtonFirst = By.xpath("//*[@id='add_to_cart']/button/span");
    private static final By continueShoppingButton = By.xpath("//span[@title='Continue shopping']");
    private static final By womenButton = By.xpath("//*[@id='block_top_menu']/ul/li[1]/a");
    private static final By cartButtonSecond = By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a");
    private static final By sizeElement = By.id("group_1");


        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = DriverInit.setUpDriver();
            driver.get(CurrentStrings.mainUrl);


            WebElement searchField = driver.findElement(Locators.searchField);
            searchField.sendKeys(CurrentStrings.textOne);
            WebElement searchButton = driver.findElement(Locators.searchButton);
            searchButton.click();


            WebElement firstDressButton = driver.findElement(Locators.firstDressButton);
            firstDressButton.click();


            WebElement sizeElement = driver.findElement(Locators.sizeElement);
            Select sizeSelect = new Select(sizeElement);
            sizeSelect.selectByVisibleText("M");


            WebElement addToCartButton = driver.findElement(Locators.cartButtonFirst);
            addToCartButton.click();
            Thread.sleep(4000);


            WebElement continueShoppingButton = driver.findElement(Locators.continueShoppingButton);
            continueShoppingButton.click();


            WebElement womenButton = driver.findElement(Locators.womenButton);
            womenButton.click();
            Thread.sleep(4000);


            WebElement searchFieldAfterNavigation = driver.findElement(Locators.searchField);
            searchFieldAfterNavigation.sendKeys(CurrentStrings.textTwo);
            WebElement searchButtonAfterNavigation = driver.findElement(Locators.searchButton);
            searchButtonAfterNavigation.click();
            Thread.sleep(4000);


            WebElement secondDressButton = driver.findElement(Locators.secondDressButton);
            secondDressButton.click();
            //addToCartButton.click();
            //continueShoppingButton.click(); ---> на момент создания теста у этого товара не было доступных размеров и цветов
            Thread.sleep(4000);


            WebElement cartButtonSecond = driver.findElement(Locators.cartButtonSecond);
            cartButtonSecond.click();

            driver.quit();


        }







}






}
