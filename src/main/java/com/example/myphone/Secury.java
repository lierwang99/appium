package com.example.myphone;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.Base;

import io.appium.java_client.android.AndroidDriver;

public class Secury {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<?> driver = Base.getDriver("com.huawei.systemmanager", ".mainscreen.MainScreenActivity");
		//多属性xpth
		driver.findElement(By.xpath("//*[@class='android.widget.RelativeLayout'][@bounds='[702,1374][1020,1704]']")).click();

		System.out.println("successful");
	}
}
