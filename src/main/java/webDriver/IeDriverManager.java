package webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IeDriverManager extends AbstractWebDriverManger {

    @Override
    public WebDriver newDriver() {
        WebDriverManager.iedriver().setup();
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("ignoreProtectedModeSettings",true);
        capabilities.setCapability("ignoreZoomSetting",true);
        capabilities.setCapability("nativeEvents", true);
        capabilities.setCapability("acceptSslCerts", true);
        return new InternetExplorerDriver(capabilities);
    }
}
