package com.example.myphone;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.Base;

import io.appium.java_client.android.AndroidDriver;

public class Icbc {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<WebElement> driver = Base.getDriver("com.sc.icbc", ".MainActivity");
		Thread.sleep(2000);
		Base.tap(driver, 900, 1740);
		Thread.sleep(2000);
//		String source = driver.getPageSource();
//		String replaceAll = source.replaceAll(">", ">9999");
//		String[] split = replaceAll.split("9999");
//		for(int x=0;x<split.length;x++) {
//			System.out.println(split[x]);
//		}
//		String first = driver.getWindowHandle();
//		System.out.println("登录页面："+first);
//		System.out.println("有几个handle："+driver.getWindowHandles().size());
		//
		String phoneXpath = "//*[@resource-id='com.sc.icbc:id/etMobile'][@bounds='[191,710][1032,830]']";
		String passwd = "//*[@resource-id=\"com.sc.icbc:id/etPwd\"]";
		String login = "//*[@class='android.widget.TextView'][@resource-id='com.sc.icbc:id/tvLogin'][@index='5']";
		Base.sendKeys(driver, phoneXpath, "18512107930");
		Base.sendKeys(driver, passwd, "aaaa11");
		Thread.sleep(2000);
		driver.findElement(By.xpath(login)).click();
		Thread.sleep(8000);
		
		
//		int sec  = driver.getWindowHandles().size();
//		System.out.println(sec);
		String source = driver.getPageSource();
		String replaceAll = source.replaceAll(">", ">9999");
		String[] split = replaceAll.split("9999");
		for(int x=0;x<split.length;x++) {
			System.out.println(split[x]);
		}
	}
	


}
