package hw_1;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {
    /* Написати метод до параметрів якого приймаються два ВебЕлементи:
        - метод виводить у консоль інформацію який із двох елементів розташовується вище на сторінці,
        який з елементів розташовується ліворуч на сторінці, а також який із елементів займає велику площу.
        Параметри методу можуть також включати інші аргументи, якщо це необхідно. */

    public static void ArrangementOfElements(WebElement element1, WebElement element2){
        int x1 = element1.getLocation().getX();
        int y1 = element1.getLocation().getY();
        int width1 = element1.getSize().getWidth();
        int height1 = element1.getSize().getHeight();
        int area1 = width1 * height1;

        int x2 = element2.getLocation().getX();
        int y2 = element2.getLocation().getY();
        int width2 = element2.getSize().getWidth();
        int height2 = element2.getSize().getHeight();
        int area2 = width2 * height2;

        if (y1 < y2) {
            System.out.println("Перший елемент розташований вище дрегого.");
        } else if (y1 > y2) {
            System.out.println("Другий елемент розташований вище першого.");
        } else {
            System.out.println("Обидва елементи розташовані на одній висоті.");
        }


        if (x1 < x2) {
            System.out.println("Перший елемент розташований лівіше другого.");
        } else if (x1 > x2) {
            System.out.println("Другий елемент розташований лівіше першого.");
        } else {
            System.out.println("Обидва елементи розташовані на одній ширині.");
        }


        if (area1 > area2) {
            System.out.println("Перший елемент займає більше площу, ніж другий.");
        } else if (area1 < area2) {
            System.out.println("Другий елемент займає більшу площу, ніж перший.");
        } else {
            System.out.println("Обидва елементи займають однакову площу.");
        }

    }


    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get("http://www.automationpractice.pl/index.php");

        WebElement element1 = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        WebElement element2 = driver.findElement(By.xpath("//*[@id='searchbox']/button"));

        Task2.ArrangementOfElements(element1, element2);

        driver.quit();

    }

}
