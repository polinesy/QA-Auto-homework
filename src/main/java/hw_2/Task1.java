package hw_2;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task1 {
    /*
    http://only-testing-blog.blogspot.com/2014/01/textbox.html?
    Написати програму, яка реалізує дію, показану на "видео1.mp4".
    Після виконання програми на консолі має виводитись інформація в наступному вигляді:
    Автомобілі доступні для вибору:
    - Volvo, BMW, Opel, Audi, Toyota, Renault, Maruti Car.
    Країни з першої таблиці:
    - USA, Russia, Japan, Mexico, India, Malaysia, Greece.
    Країни з другої таблиці:
    - France, Germany, Italy, Spain.
     */
    public static void main(String[] args) {

        WebDriver driver = DriverInit.setUpDriver();
        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        WebElement selectCar1 = driver.findElement(By.id("Carlist"));
        Select carlist = new Select(selectCar1);
        carlist.selectByVisibleText("Renault");


        System.out.println("Автомобілі доступні для вибору:");
        List<WebElement> allOptions = carlist.getOptions();
        int size = allOptions.size();
        for (int i = 0; i < size; i++) {
            WebElement element = allOptions.get(i);
            if (i == size - 1) {
                System.out.print(element.getText() + ".");
            } else {
                System.out.print(element.getText() + ", ");
            }
        }
        System.out.println();


        WebElement selectCar2 = driver.findElement(By.name("FromLB"));
        Select fromLB = new Select(selectCar2);

        fromLB.selectByVisibleText("France");
        fromLB.selectByVisibleText("Germany");
        fromLB.selectByVisibleText("Italy");
        fromLB.selectByVisibleText("Spain");


        System.out.println("Країни з першої таблиці:");
        List<WebElement> alldeselectedOptions = fromLB.getOptions();
        int size1 = alldeselectedOptions.size();
        for (int i = 0; i < size; i++) {
            WebElement element = alldeselectedOptions.get(i);
            if (i == size - 1) {
                System.out.print(element.getText() + ".");
            } else {
                System.out.print(element.getText() + ", ");
            }
        }
        System.out.println();


        System.out.println("Країни з другої таблиці:");
        List<WebElement> selectedOptions = fromLB.getAllSelectedOptions();
        int size2 = selectedOptions.size();
        for (int i = 0; i < size; i++) {
            WebElement element = allOptions.get(i);
            if (i == size - 1) {
                System.out.print(element.getText() + ".");
            } else {
                System.out.print(element.getText() + ", ");
            }
        }
        driver.quit();


    }
}


