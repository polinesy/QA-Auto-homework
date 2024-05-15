package test_for_web;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.lang.Thread;

public class TestForWeb4 {
    public static void main(String[] args)throws InterruptedException {

        WebDriver driver = DriverInit.setUpDriver();
        driver.get("https://www.baeldung.com/rest-assured-tutorial");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=menu-item-17021]/font/font")).click();
        Thread.sleep(4000);
        driver.quit();

    }
}
