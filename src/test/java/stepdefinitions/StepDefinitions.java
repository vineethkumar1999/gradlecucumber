package stepdefinitions;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Vineeth
 *
 */
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

    @When("I run the step {string}")
    public void whenRunStepwithstring(String msg) {
        System.out.println("Reached When"+msg);
    }

   @Then("I see the output")
    public void thenSeeOutput() {
        System.out.println("Reached Then");
    }

    @Then("I see the output2")
    public void thenSeeOutput2() {
        System.out.println("Reached Then2");
    }

    @After
    public void endsetup(){
        System.out.println("Reached End Setup");
    }

//    @BeforeStep
//    public void beforestep(Scenario scenario)
//    {
//        System.out.println("Before step in scenario: " + scenario.getName());
//        System.out.println("Line Number: " + scenario.getLine());
//    }

    @BeforeStep("@test")
    public void beforestepwithtag()
    {
        System.out.println("Before step in scenario: test");
    }

    @AfterStep("@test")
    public void afterstep(Scenario scenario)
    {
        System.out.println("After step in scenario: test");
        System.out.println("Before step in scenario: " + scenario.getName());
    }
}
