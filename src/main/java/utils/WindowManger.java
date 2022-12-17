package utils;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class WindowManger {
    WebDriver driver;
    WebDriver.Navigation navigation;

    public WindowManger(WebDriver driver) {
        this.driver = driver;
        navigation = driver.navigate();
    }

    public void goBack() {
        navigation.back();
    }

    public void goForward() {
        navigation.forward();
    }

    public void refresh() {
        navigation.refresh();
    }

    public void goTo(String url) {
        navigation.to(url);
    }

    public void switchToTab(String tabTitle) {

        var windows = driver.getWindowHandles();
        for (var window : windows) {
            driver.switchTo().window(window);
            if (tabTitle.equals(driver.getTitle()))
                break;
        }

    }

    public void switchToNewTab() {

        var handles = driver.getWindowHandles();
        handles.forEach(handle -> driver.switchTo().window(handle));
    }
}
