package com.example.myphone;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.Base;

import io.appium.java_client.android.AndroidDriver;

public class ShortMessages {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<WebElement> driver = Base.getDriver("com.android.mms", ".ui.ConversationList");
		Thread.sleep(3000);
		Base.scrollTo(driver, 5, 9, 5, 1, 10, 2000);
//		Base.scrollByJs(driver);
//		driver.close();
		Thread.sleep(7000);
		String landlord = "//*[@index='8'][@class='android.widget.FrameLayout']";
		Base.clickXpath(driver, landlord);
		Thread.sleep(4000);
		String mess = "//*[@resource-id='com.android.mms:id/text_view']";
		List<WebElement> eleList = driver.findElements(By.xpath(mess));
		int i = 1;
		for(WebElement ele : eleList) {
			
			String text = ele.getText();
			System.out.println("内容  "+i++ +" ："+text);
			
		}
		
		
	}

}
