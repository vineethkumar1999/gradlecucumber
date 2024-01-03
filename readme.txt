What is Cucumber?
Cucumber is an open-source software testing tool that supports BBD. (Behavior-Driven Development). 
It works with Gherkin because the Gherkin syntax structures plain text so that it can be read by the tool.
Cucumber reads Gherkin tests and validates that the code performs as it should. It does this by working through Gherkin scenarios and steps. (More on this below). 
Cucumber will then create a report showing of each step and scenario was successful or if it fails. 


What is Gherkin?
Gherkin is a language that developers use to define tests in Cucumber. Since this language uses plain English, it’s meant to describe use cases for a software system in a way that can be read and understood by almost anyone.
This syntax promotes behavior-driven development because it allows developers, managers, business analysts and other parties involved to understand the requirements of the project and the life-cycle. 
The language makes it easy to create simple documentation of the code that’s being written.  Gherkin also provides scripts for test automation and supports dozens of languages. 

Feature: here we describe what the document is trying to achieve, which feature and what functionality. 
you can describe in multiple lines, and it essentially acts as documentation.

Background:  ANy methods or variables which need to be available for all the scenarios can be declared here.

Scenario: here we write specific context and what we are trying to achieve

Scenario OutLine: Same as scenario except we can provide multiple lines of input

Given: Here we establish what was already present or what had happend. given so n so is the condition

When: Here we specify any event that is happening. WHen I click on a button

Then: Here we write what we are expecting the system should perform. THis is compared against the actual output

And, But: when we have multiple Given or when ,then we can use these as conjunctions to join.

Setup:

Lets learn cucumber and setup from basics. We are here using gradle, Java and Intellij

1. Open Intellij , Click on New project and create a java project by selecting gradle as build tool.

2. Go to plugins and install Cucumber for Java plugin

3. Build the Project and you will be able to see the folder structure created.

4. Build.gradle in this project will be the initial one, where we will not be using any other dependencies except cucumber.

5. In features we have a sample feature. Step definitions are written in test/java folder.

When the tests are run , cucumber first checks if all the statements have step definitions, if its not found it will throw an exception.

States available for execution: Skipped, Pending, Failed, Undefined, Ambiguous.

Every statement in feature file is called as a step. and each step will have its corresponding step definition. 

cucumber will read the step, get the corresponding step definition and runs it.

We can have tags at feature file level, scenario level, and even at each example in scenario outline.

How to Run: 

We can use java cp to run the tests. but in Intellij you can directly right click on feature file and click on Run.
A configuration will be created on top right corner automatically.

Test will run and you will be able to see the message about scenarios passed in console.

Note that we have not used any Junit/TestNg/Jacoco here. We are going with basics so that we can learn.

In configuration: program arguments you can mention --tags @tagname to run specific scenario.

Tags:  
you can also use --tags "@tag1 and @tag2" to run a scenario that has both tag1 and tag2 tags.

@tag1 or @tag2 to run scenarios that have either tag1 or tag2

@tag1 and not @tag2 to run scenario that has tag1 but not tag2 

You can also Use hooks like @Before, @After, @BeforeStep, @AfterStep, @After("@step1 and not @step2") : COnditional hooks to run your methods
before or after or even after certain step

BeforeStep will run the content before each step in each scenario
AfterStep will run the method content after each step in each scenario
Conditional hooks use them with Before, After, BeforeStep, or AfterStep with ("@tags") to run them only when tags are matched

I have added examples for all these feel free to add the tags in program arguments, run and see the result.


UI Automation:

Now that we have seen how we can write and run tests, lets move ahead and add basic test case where we open browser and search for cheese

Here we are using firefox browser and you have to download corresponding firefox webdriver

We have created a java class for accommodating step definitions of UI functionality.








