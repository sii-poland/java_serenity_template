# ScreenPlay pattern example

This example shows the way of UI tests implementation using ScreenPlay pattern with Serenity BDD framework.

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

