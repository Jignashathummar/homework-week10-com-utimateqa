package comutimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */
public class Utimateqa {
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;
    static String browser = "Chrome";
    static String homepageUrl = "https://courses.ultimateqa.com/collections";

    public static void main(String[] args) {
        //Launch the Chrome Browser
        if (browser.trim().equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser");
        }
        //Get base URL
        driver.get(baseUrl);

        //Maximise the Browser
        driver.manage().window().maximize();
        String title = driver.getTitle();

        //Get the title of the Page.
        System.out.println("Title: " + title);

        //Get current URL
        System.out.println("The current URL : " + driver.getCurrentUrl());

        //Get Page source
        System.out.println("Page source : " + driver.getPageSource());

        //Sign in link
        driver.findElement(By.linkText("Sign In")).click();

        //Get Current URL
        System.out.println("Get current URL: " + driver.getCurrentUrl());

        //Enter username field
        WebElement email = driver.findElement(By.id("user[email]"));
        email.sendKeys("prime@gmail.com");

        //Enter password field
        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("Prime@123");

        //Click on login button
        WebElement signin = driver.findElement(By.cssSelector("button[class^='button button-primary g-recaptcha']"));
        signin.click();

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Nevigate Base Url
        driver.navigate().back();

        //nevigate to homepage
        driver.get(homepageUrl);

        //Nevigate to baseUrl
        driver.get(baseUrl);
        //Refresh page
        driver.navigate().refresh();

        //browser close
         driver.quit();
    }
}
