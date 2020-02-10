package com.example.myphone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.Base;

import io.appium.java_client.android.AndroidDriver;

public class Wechat {

	public static void main(String[] args) throws InterruptedException, IOException {
		AndroidDriver<WebElement> driver = Base.getDriver("com.tencent.mm", ".ui.LauncherUI");
		Thread.sleep(10000);
		Base.scrollTo(driver, 5, 8, 5, 2, 10, 3000);
		Thread.sleep(3000);
		String zr = "//*[@text='曾容'][@resource-id='com.tencent.mm:id/b6e']";
		Base.clickXpath(driver, zr);
		Thread.sleep(1000);
		String input = "//*[@class='android.widget.EditText'][@resource-id='com.tencent.mm:id/ami']";
		Base.clickXpath(driver, input);
		Thread.sleep(2000);
//		String[] arr= new String[] {"one","two","three","four","five","six","seven","eight","nine","ten"};
//		for(int x=0;x<arr.length;x++) {
//			Base.sendKeys(driver, input, arr[x]);
//			String send = "//*[@class='android.widget.Button'][@resource-id='com.tencent.mm:id/amp']";
//			Thread.sleep(500);
//			Base.clickXpath(driver, send);
//			Thread.sleep(1000);
//		}
		String inpexpression = "//*[@class='android.widget.ImageButton'][@resource-id='com.tencent.mm:id/amk']";
		Base.clickXpath(driver, inpexpression);
		String ss = "//*[@resource-id='com.tencent.mm:id/yw']";
		String pageSource = driver.getPageSource();
		
//		byte[] byArr = pageSource.getBytes();
//		FileOutputStream out = new FileOutputStream("c:/read.text");
//		out.write(byArr);
//		
//		out.flush();
//		out.close();

		String[] srcArr = Base.regexExtract(pageSource, "content-desc=\".{1,25}\" checkable=(\"false\")?");
		System.out.println(srcArr.length);
		for(int x=0;x<srcArr.length;x++) {
			srcArr[x] = Base.substring(srcArr[x], 14, 19);
		}
		Base.pr(srcArr);
		pageSource = pageSource.replaceAll(">", ">99999");
		String[] sp = pageSource.split("99999");
//		for(int x=0;x<sp.length;x++) {
//			boolean flag = Base.writeIn(sp[x], "c:/scc.txt");
//			System.out.println(flag);
//		}
//		FileWriter writ = new FileWriter("c:/rd.csv");
//		writ.append(csq)
//		
		List<WebElement> eles = driver.findElements(By.xpath(ss));
		int i = 0;
		String send = null;
//		for(WebElement ele :eles) {
//			ele.click();
			
			send = "//*[@class='android.widget.Button'][@resource-id='com.tencent.mm:id/amp']";
//			Base.clickXpath(driver, send);
			Thread.sleep(5000);
//			driver.findElement(By.xpath(input)).clear();
//			i++;
//			if(i==5) {
//				Base.sendKeys(driver, input, "发送完毕,准备关机！");
//				Base.clickXpath(driver, send);
//				Thread.sleep(3000);
//				break;
//			}
//		}
//		Base.clickXpath(driver, send);
//		System.out.println("成功！");
//		 try {
//	            Runtime.getRuntime().exec("shutdown -s -t 60");//其实就这一句 shutdown -r是重启
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
	}
	
}
