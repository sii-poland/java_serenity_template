package webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IeDriverManager extends AbstractWebDriverManger {

    @Override
    public WebDriver newDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }
}
