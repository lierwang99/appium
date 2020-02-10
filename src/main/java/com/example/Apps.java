package com.example;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Apps {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
//		AndroidDriver<WebElement> driver = Base.getDriver("com.huawei.systemmanager", ".mainscreen.MainScreenActivity");
		AndroidDriver<?> driver = Base.getDriver("com.android.contacts", ".activities.DialtactsActivity");
		Thread.sleep(3000);
		System.out.println("11");
//		String cl = "//*[@class='android.widget.TextView'][@text='清理加速']";
		
		String one = "contacts_dialpad_one";
		String two = "contacts_dialpad_two";
		String three = "contacts_dialpad_three";
		String four = "contacts_dialpad_four";
		String five = "contacts_dialpad_five";
		String six = "contacts_dialpad_six";
		String seven = "contacts_dialpad_seven";
		
		String eight = "contacts_dialpad_eight";
		String nine = "contacts_dialpad_nine";
		String zero = "contacts_dialpad_zero";
//		
//		Base.click(driver, one);
//		Base.click(driver, five);
//		Base.click(driver, six);
//		Base.click(driver, nine);
//		Base.click(driver, two);
//		Base.click(driver, one);
//		Base.click(driver, two);
//		Base.click(driver, two);
//		Base.click(driver, nine);
//		Base.click(driver, four);
//		Base.click(driver, one);
		
//		Base.click(driver, "nameDialButton2");
		System.out.println("执行成功");
		driver.quit();
	}

}
