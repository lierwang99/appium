package com.example.myphone;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;


public class CalculatorTest {

    @SuppressWarnings("static-access")
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        //com.android.calculator2  应用的包名称
        capabilities.setCapability("appPackage", "com.android.calculator2");
        //活动的项目
        capabilities.setCapability("appActivity", ".Calculator");

        @SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("9")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.name("+")).click();
        driver.findElement(By.name("8")).click();
        driver.findElement(By.name("=")).click();
        Thread.sleep(2000);

        String result = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
        System.out.println(result);


        driver.quit();
    }

}