package com.example.myphone;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class PhoneTest {

    @SuppressWarnings("static-access")
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "huawei-nem_al10-FDGNW17225010260");
//        capabilities.setCapability("udid", "FDGNW17225010260");
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
//        driver.findElement(By.name("delete")).click();
        driver.findElement(By.name("加")).click();
        driver.findElement(By.name("8")).click();
        driver.findElement(By.name("等于")).click();
//        driver.findElement(by)
        Thread.sleep(2000);

        String result = driver.findElement(By.className("android.widget.EditText")).getText();
        System.out.println(result);


        driver.quit();
    }
}
