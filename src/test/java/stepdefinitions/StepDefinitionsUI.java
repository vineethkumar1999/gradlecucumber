package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class StepDefinitionsUI {
    WebDriver driver;
    @Before("@UITest")
    public void setupWebDriver() {
        System.out.println("Reached Before in UI");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\talar\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe"); // Set path for Firefox driver
        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Given("Simple Test")
    public void simpleTest() {
        System.out.println("Reached Just Print");
    }

    @Given("I am on the Google search page")
    public void I_visit_google() {
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void search_for(String query) {
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.clear();
        element.sendKeys(query);
        // Now submit the form. WebDriver will find the form for us from the element
        element.sendKeys(Keys.ENTER);
    }

    @Then("the page title should start with {string}")
    public void checkTitle(String titleStartsWith) {
        // Google's search is rendered dynamically with JavaScript
        // Wait for the page to load timeout after ten seconds
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(titleStartsWith);
            }
        });
    }

    @Then("I click on website")
    public void iclicksite(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait up to 10 seconds

        // Wait for element to be clickable and then send Enter key
        WebElement searchElement = wait.until(ExpectedConditions.elementToBeClickable(By.className("zgAlFc")));
        searchElement.click();

        // Wait for the target element to be clickable and then click
        WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/span[text()='Automation Exercise']")));
        targetElement.click();
    }

    @After("@UITest")
    public void closeBrowser() {
        System.out.println("Reached UI After Method");
        driver.quit();
    }
}