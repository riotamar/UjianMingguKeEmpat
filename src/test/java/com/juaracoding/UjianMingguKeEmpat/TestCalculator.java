package com.juaracoding.UjianMingguKeEmpat;

import com.juaracoding.UjianMingguKeEmpat.pages.Calculator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCalculator {
    private static AndroidDriver<MobileElement> driver;
    private Calculator calculator;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel_2_API_25");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @BeforeMethod
    public void pageObject() {
        calculator = new Calculator(driver);
    }

    @Test (priority = 1)
    public void testAdd() {
        calculator.calcAdd();
        System.out.println("Result = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(), "3");
    }

    @Test (priority = 2)
    public void testSubstract() {
        calculator.calcSubstract();
        System.out.println("Result = "+calculator.getTxtResult());
        String actual = calculator.getTxtResult();
        char charActual = actual.charAt(0);
        int cekASCII = (int) charActual;
        System.out.println(cekASCII);
        int cekASCIIFromKeyboardMinus = '-';
        System.out.println(cekASCIIFromKeyboardMinus);
        Assert.assertEquals(actual, "−1");
    }

    @Test (priority = 3)
    public void testMultiply() {
        calculator.calcMultiply();
        System.out.println("Result = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(), "2");
    }

    @Test (priority = 4)
    public void testDivide() {
        calculator.calcDivide();
        System.out.println("Result = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(), "0.5");
    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }
}