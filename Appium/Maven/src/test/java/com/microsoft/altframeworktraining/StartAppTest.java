package com.microsoft.altframeworktraining;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class StartAppTest {
    private AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> startApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "foo");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/john7doe/src/alt-framework-training/Appium/swiftnote.apk");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        URL url = new URL("http://localhost:4723/wd/hub");

        return new AndroidDriver<AndroidElement>(url, capabilities);
    }

    @Test void addNote() {
        driver = startApp();
        driver.findElement(By.name(""));
        driver.findElementByAccessibilityId("New Note");

    }


    @Test
    public void canStartAppInTest() throws MalformedURLException {
        driver = startApp();
    }

    @After
    public void after() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}