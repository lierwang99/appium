package com.example.myphone;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.Base;

import io.appium.java_client.android.AndroidDriver;

public class Camera {

	public static void main(String[] args) {
		try {
			AndroidDriver<?> driver = Base.getDriver("com.huawei.camera", "com.huawei.camera");
			driver.findElement(By.id("shutter_button")).click();
			System.out.println("成功！");
			driver.closeApp();
		} catch (MalformedURLException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
