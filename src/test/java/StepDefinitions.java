import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    @Before
    public void setup(){
        System.out.println("Reached Start Setup");
    }
    @Given("I have a sample step")
    public void givenSampleStep() {
        System.out.println("Reached Given");
    }

    @When("I run the step")
    public void whenRunStep() {
         System.out.println("Reached When");
    }

    @Then("I see the output")
    public void thenSeeOutput() {
        System.out.println("Reached Then");
    }

    @After
    public void endsetup(){
        System.out.println("Reached End Setup");
    }
}
