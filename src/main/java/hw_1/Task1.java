package hw_1;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task1 {
    /*1) Написати програму, яка буде відкривати чотири різні сторінки у нових вікнах:
https://zoo.kiev.ua/
https://www.w3schools.com/
https://taxi838.ua/ru/dnepr/
https://klopotenko.com/
Прописати цикл, який перемикатиметься по черзі через всі сторінки,
для кожної сторінки виводити в консоль назву та посилання на цю сторінку.
І закриватиме ту сторінку у назві якої є слово зоопарк.*/

    public static void NewWindowOpen (WebDriver driver, Set<String> urls){
        for (String url: urls){
            Set<String> winHan1 = driver.getWindowHandles();
            ((JavascriptExecutor) driver).executeScript("window.open()");
            Set<String> winHan2 = driver.getWindowHandles();
            winHan2.removeAll(winHan1);
            String windowHandle2 = winHan2.iterator().next();
            driver.switchTo().window(windowHandle2);
            driver.get(url);
        }
    }

    public static void PrintNamesAndUrls (WebDriver driver){
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle: windowHandles){
            driver.switchTo().window(handle);
            String pageTitle = driver.getTitle().toLowerCase();
            System.out.println("Назва сторінки - " + driver.getTitle() + ". Посилання на сторінку - " + driver.getCurrentUrl() + ".");
            if(pageTitle.contains("зоопарк")){
                driver.close();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        Set<String> urls = new HashSet<>(Arrays.asList("https://zoo.kiev.ua/", "https://www.w3schools.com/",
                "https://taxi838.ua/ru/dnepr/", "https://klopotenko.com/"));
        NewWindowOpen(driver, urls);
        Thread.sleep(2000);
        PrintNamesAndUrls(driver);
        driver.quit();


    }
}
