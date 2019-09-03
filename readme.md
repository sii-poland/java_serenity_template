# ScreenPlay pattern example

This example shows the way of UI tests implementation using ScreenPlay pattern with Serenity BDD framework written in Java.

## Screenplay pattern benefits

1. Using SOLID principles in test development:
	- Single responsibility principle;
	- Open-closed principle;
2. Easy to read test cases right in the test class;
3. Easy to maintain and extend test framework;
4. Focus on business actions rather that on pages.


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