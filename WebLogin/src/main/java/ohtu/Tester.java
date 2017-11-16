package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");


        /*
EPÄONNISTUNUT KIRJAUTUMINEN -> OIKEA KÄYTTÄJÄNIMI ja VÄÄRÄ SALASANA
         */
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        System.out.println(driver.getPageSource());
        sleep(1);
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("kazakstan");
        element = driver.findElement(By.name("login"));
        sleep(1);
        System.out.println(driver.getPageSource());
        element.submit();
        System.out.println(driver.getPageSource());
        sleep(1);

        /*
EPÄONNISTUNUT KIRJAUTUMINEN -> EI OLEMASSAOLEVA KÄYTTÄJÄTUNNUS
         */
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        System.out.println(driver.getPageSource());
        sleep(1);
        element = driver.findElement(By.name("username"));
        element.sendKeys("kazakstan");
        System.out.println(driver.getPageSource());
        sleep(1);
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        System.out.println(driver.getPageSource());
        sleep(1);
        element = driver.findElement(By.name("login"));
        element.submit();
        System.out.println(driver.getPageSource());
        sleep(1);

        /*
UUDEN KÄYTTÄJÄN LUONTI
         */
        Random random = new Random();
        String randName = "Anton" + random.nextInt(100000);

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(1);
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys(randName);
        sleep(1);
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana");
        sleep(1);
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana");
        sleep(1);
        System.out.println(driver.getPageSource());
        element.submit();
        System.out.println(driver.getPageSource());

        /*
UUDEN KÄYTTÄJÄN LUONTI JA ULOSKIRJAUTUMINEN
         */
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(3);
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys(randName);
        sleep(3);
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana");
        sleep(3);
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana");
        sleep(3);
        System.out.println(driver.getPageSource());
        element.submit();
        sleep(3);
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(3);
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(3);
        System.out.println(driver.getPageSource());
        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
