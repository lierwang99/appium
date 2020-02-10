package com.example.myphone;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.Base;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Photo {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<WebElement> driver = Base.getDriver("com.android.gallery3d", "com.huawei.gallery.app.GalleryMain");
		driver.findElement(By.id("head_tab_two")).click();
		driver.findElement(By.xpath("//*[@bounds='[0,216][1080,468]'][@index='0']")).click();
//		int size = driver.getWindowHandles().size();
//		System.out.println(size);
		Thread.sleep(3000);
		TouchAction<?> tAction = new TouchAction<>(driver);
		PointOption<?> pt = PointOption.point(150, 380);
		tAction.tap(pt).perform();

		Thread.sleep(2000);
//		swipeLeft(driver);
//		Thread.sleep(2000);
		PointOption<?> pointA = PointOption.point(500,100);
		
		PointOption<?> pointB = PointOption.point(500,300);
		PointOption<?> pointC = PointOption.point(500,1500);
		PointOption<?> pointD = PointOption.point(500,1700);
//		Base.tap(driver,400, 800);
//		Thread.sleep(5000);
//		Base.tap(driver,100, 800);
//		Thread.sleep(5000);
//		Base.tap(driver,660, 1000);
//		Thread.sleep(5000);
//		Base.tap(driver,1000, 1000);
		
		Base.complexOperationTwo(driver, 3000, pointA,pointB,pointC);
//		Base.complexOperation(driver, 3000, pointA,pointB,pointC,pointD);
//		int i = 0;
//		while (i < 10) {
//			Base.scrollTo(driver, 950, 500, 50, 500, 1000, 1500);
//			i++;
//		}
		
		
//		int x = driver.manage().window().getSize().width/2;
//		int y = driver.manage().window().getSize().height*99/100;
//		tAction.tap(PointOption.point(x, y)).perform();
//		driver.pressKey(KeyEvent.KEYCODE_HOME);
//		driver.pressKeyCode(3);
		
//		Base.killSession(driver);
		
//		driver.startActivity(activity);
		
//		AndroidDriver<?> driver2 = Base.getDriver("com.android.systemui", ".recent.RecentsActivity");
//		driver2.findElement(By.id("clear_all_recents_image_button")).click();

		System.out.println("成功！");

	}



}
