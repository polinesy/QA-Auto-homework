package hw_1;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task3 {

    /*
    Написати метод який виводить повідомлення про ID елемента, значення тега елемента, значення класу елемента,
    значення атрибута name елемента, тексту даного елемента, а також координати центру контейнера даного елемента.
     */

    public static void GetInfoOfElement (WebElement element){
        String id = element.getAttribute("id");
        String tagName = element.getTagName();
        String classValue = element.getAttribute("class");
        String nameAttribute = element.getAttribute("name");
        String text = element.getText();
        int centerX = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int centerY = element.getLocation().getY() + element.getSize().getHeight() / 2;

        System.out.println("ID елемента: " + id);
        System.out.println("Тег елемента: " + tagName);
        System.out.println("Клас елемента: " + classValue);
        System.out.println("Значення атрибута name: " + nameAttribute);
        System.out.println("Текст елемента: " + text);
        System.out.println("Координати центру контейнера: (" + centerX + ", " + centerY + ")");
    }

    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get("http://www.automationpractice.pl/index.php");

        WebElement element1 = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));

        Task3.GetInfoOfElement(element1);

        driver.quit();

    }


}

