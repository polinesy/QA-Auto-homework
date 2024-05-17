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
       //выбираем рено
        WebDriver driver = DriverInit.setUpDriver();
        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        WebElement selectCar1 = driver.findElement(By.id("Carlist"));
        Select carlist = new Select(selectCar1);
        carlist.selectByVisibleText("Renault");

        //выводим на экран авто из списка
        System.out.println("Автомобілі доступні для вибору:");
        List<WebElement> allOptions = carlist.getOptions();
        for (WebElement element : allOptions){
            System.out.print(element.getText() + ", ");
        }




        //WebElement selectCar2 = driver.findElement(By.name("FormLB"));
        //Select formLB = new Select(selectCar2);

        //formLB.selectByVisibleText("");









    }





}
