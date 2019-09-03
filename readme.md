# ScreenPlay pattern example

This example shows the way of UI tests implementation using ScreenPlay pattern with Serenity BDD framework written in Java.

## Screenplay pattern benefits

1. Using SOLID principles in test development:
	- Single responsibility principle;
	- Open-closed principle;
2. Easy to read test cases right in the test class;
3. Easy to maintain and extend test framework;
4. Focus on business actions rather that on pages.

## Project's structure

 - *src\main\java\questions*: classes describes elemants and conditions which can be chacked during the test;
 - *src\main\java\tasks*: classes describes autonomous actions user can perform on the UI (business actions);
 - *src\main\java\ui*: classes for UI elements which are used in tasks; 
 - *src\main\java\webDriver*: package for webDriver's managers;
 - *src\test\java\features*: package with tests.
 
## Test Implementation

 - New test's implementation is to be placed in *src\test\java\features* package;
 - Test class should have annotation ```@RunWith(SerenityRunner.class)```;
 - Test class should have exemplar of ```Actor``` class, playing the role of the user interacting with UI;

## How to run the tests

To run the tests on the particular browser you can use maven:

For IE: ``` mvn clean verify -Dwebdriver.driver=provided -Dwebdriver.provided.type=ie -Dwebdriver.provided.ie=webDriver.IeDriverManager``` 

For Chrome: ``` mvn clean verify -Dwebdriver.driver=provided -Dwebdriver.provided.type=chrome -Dwebdriver.provided.chrome=webDriver.ChromeDriverManager``` 

For FireFox: ``` mvn clean verify -Dwebdriver.driver=provided -Dwebdriver.provided.type=firefox -Dwebdriver.provided.firefox=webDriver.FireFoxDriverManager```

or

you can run ``` mvn clean verify``` with serenity.properties file, where needed parameters will be uncommented,
for example:
```
webdriver.driver = provided
webdriver.provided.type = chrome
webdriver.provided.chrome = webDriver.ChromeDriverManager
```

## Test report

The test report is being generated after ``` verify``` maven command has finished. Test report is locaten in the file ```\target\site\serenity\index.html``` 