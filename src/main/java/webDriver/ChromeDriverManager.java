package webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends AbstractWebDriverManger {

    @Override
    public WebDriver newDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}