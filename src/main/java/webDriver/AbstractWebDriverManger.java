package webDriver;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

public abstract class AbstractWebDriverManger implements DriverSource {

    @Override
    public abstract WebDriver newDriver();

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
