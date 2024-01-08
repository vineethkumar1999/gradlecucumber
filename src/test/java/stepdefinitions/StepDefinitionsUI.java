package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class StepDefinitionsUI {
    WebDriver driver;

    @Before("@UITest3")
    public void setupWebDriver() {
        System.out.println("Reached Before in UI");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\talar\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe"); // Set path for Firefox driver
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

    @When("I click on Products")
    public void productAction(){
        Actions act = new Actions(driver);
        driver.manage().window().maximize();
        WebElement e = driver.findElement(By.xpath("//a[text()=' Products']"));
        act.moveToElement(e).click().perform();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement kidsplus = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='Kids']/preceding-sibling::div//a"))));
        act.moveToElement(kidsplus).doubleClick().perform();
    }

    @When("I search for {string} in amazon")
    public void searchamazon(String item){
        WebElement e = driver.findElement(By.id("twotabsearchtextbox"));
        e.sendKeys(item);
        e.sendKeys(Keys.ENTER);
    }

    @Then("Click on first item and open in new tab")
    public void opentab()
    {
           Actions act = new Actions(driver);
           WebElement item = driver.findElement(By.xpath("//a/span[contains(@class,'a-size-medium a-color-base a-text-normal') and starts-with(text(),'Soundcore Anker Life Q20')]"));
           item.click();
           driver.navigate().refresh();
           driver.navigate().back();
           driver.navigate().forward();
    }
    @After("@UITest")
    public void closeBrowser() {
        System.out.println("Reached UI After Method");
        driver.quit();
    }

    @Given("I navigate to {string}")
    public void iNavigate(String url)
    {
        System.out.println(url);
        driver.get(url);
    }

    @When("I click on Click me Web element")
    public void clickme()
    {
        driver.findElement(By.id("button1")).click();
        driver.manage().window().maximize();
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Window Handles Size is" +windowHandles.size());
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.findElement(By.id("button1")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.id("button2")).click();
        windowHandles = driver.getWindowHandles();
        System.out.println("Window Handles Size is" +windowHandles.size());
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        Actions act = new Actions(driver);
        act.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).perform();
        act.moveToElement(driver.findElement(By.id("double-click"))).doubleClick().perform();
        act.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Hover Over Me First!')]"))).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Link 1")));
        link1.click();
        alert = driver.switchTo().alert();
        alert.accept();
        act.moveToElement(driver.findElement(By.id("click-box"))).clickAndHold().release().perform();
        driver.get("https://webdriveruniversity.com/File-Upload/index.html");
        driver.findElement(By.id("myFile")).sendKeys("E:\\GitLocal\\gradlecucumber\\buildwithoutUI.txt");
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