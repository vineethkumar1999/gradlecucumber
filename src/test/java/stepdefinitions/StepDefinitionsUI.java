package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Random;
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
    public void iclicksite() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait up to 10 seconds

        // Wait for element to be clickable and then send Enter key
        WebElement searchElement = wait.until(ExpectedConditions.elementToBeClickable(By.className("zgAlFc")));
        searchElement.click();

        // Wait for the target element to be clickable and then click
        WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/span[text()='Automation Exercise']")));
        targetElement.click();
    }

    @When("I click on login or Signup")
    public void signup() {
        driver.findElement(By.linkText("Signup / Login")).click();
    }

    @Then("I fill name and email")
    public void signupform1() {
        Random rand = new Random();
        driver.findElement(By.xpath("//form/input[@name='name']")).sendKeys("Test" + rand.nextInt(1000));
        driver.findElement(By.xpath("//form[@action='/signup']/input[@name='email']")).sendKeys("TestingABC" + rand.nextInt(1000) + "@gmail.com");
        driver.findElement(By.xpath("//form[@action='/signup']/button")).click();
    }

    @Then("I fill the signupform")
    public void signupform2() {
        Random rand = new Random();
        WebElement radio = driver.findElement(By.xpath("//input[@type='radio'][@value='Mr']"));
        radio.click();
        if (radio.isSelected())
            System.out.println("Radio Button clicked");
        driver.findElement(By.id("password")).sendKeys("Test@123");
        WebElement days = driver.findElement(By.id("days"));
        Select s = new Select(days);
        s.selectByValue("31");
        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByIndex(12);
        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByVisibleText("1982");
        driver.findElement(By.xpath("//input[@type=\"checkbox\" and contains(@id,'news')]")).click();
        driver.findElement(By.id("first_name")).sendKeys("TestUser");
        driver.findElement(By.id("last_name")).sendKeys("TestLast");
        driver.findElement(By.id("address1")).sendKeys("Address");
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByIndex(4);
        driver.findElement(By.id("state")).sendKeys("state");
        driver.findElement(By.id("city")).sendKeys("city");
        driver.findElement(By.id("zipcode")).sendKeys("56220");
        driver.findElement(By.id("mobile_number")).sendKeys("8888888888");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cont = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Continue"))));
        cont.click();
    }

    @After("@UITest")
    public void closeBrowser() {
        System.out.println("Reached UI After Method");
        driver.quit();
    }
    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "name");
            } catch (Exception e) {
                System.err.println("Exception while taking screenshot: " + e.getMessage());
            }
        }
    }
}