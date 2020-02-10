package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Base {
	public static AndroidDriver<WebElement> getDriver(String appPackage, String appActivity)
			throws InterruptedException, MalformedURLException {
//	System.setProperty("","");

		DesiredCapabilities capabilities = new DesiredCapabilities();
//    capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.2");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "FDGNW17225010260");
//    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "huawei-nem_al10-FDGNW17225010260");
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0");
		// com.android.calculator2 应用的包名称
		capabilities.setCapability("appPackage", appPackage);
		// 活动的项目
		capabilities.setCapability("appActivity", appActivity);
		// 解决输入中文问题
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");

		AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		// 解锁
		driver.unlockDevice();
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public static void clickId(AndroidDriver<WebElement> driver, String elementId) {
		driver.findElement(By.id(elementId)).click();
	}

	public static void clickXpath(AndroidDriver<WebElement> driver, String elementXpath) {
		driver.findElement(By.xpath(elementXpath)).click();
	}

	public static void stopApp() {
		try {
			AndroidDriver<WebElement> driver = getDriver("com.android.systemui", ".recent.RecentsActivity");
			driver.findElement(By.id("clear_all_recents_image_button")).click();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void scrollTo(AndroidDriver<WebElement> driver, int startX, int startY, int endX, int endY,
			int denominator, int duration) throws InterruptedException {
		Dimension size = driver.manage().window().getSize();
		System.out.println("宽：" + size.width);
		System.out.println("高：" + size.height);

		int x1 = size.width * startX / denominator;// 水平方向的起点
		int x2 = size.width * endX / denominator;// 水平方向的终点

		int y1 = size.height * startY / denominator; // 垂直方向上的起点
		int y2 = size.height * endY / denominator; // 垂直方向的终点

		PointOption<?> pointA = PointOption.point(x1, y1);
		PointOption<?> pointB = PointOption.point(x2, y2);
		Duration time = Duration.ofMillis(duration);
		WaitOptions waitOptions = WaitOptions.waitOptions(time);
		TouchAction<?> tAction = new TouchAction<>(driver);
		tAction.press(pointA).waitAction(waitOptions).moveTo(pointB).release().perform();

	}

	// 利用js滚动
	public static void scrollByJs(AndroidDriver<WebElement> driver) {
		String js = "scrollTo(0,10000)";
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		jsDriver.executeScript(js);
	}

	public static void killSession(AndroidDriver<WebElement> driver) {
		Map<String, Integer> map = new HashMap<>();
		map.put("newCommandTimeout", 0);
		driver.getCapabilities().merge(new DesiredCapabilities(map));
	}

	// 利用坐标点击
	public static void tap(AndroidDriver<WebElement> driver, int x, int y) {
		TouchAction<?> tAction = new TouchAction<>(driver);
		PointOption<?> point = PointOption.point(x, y);
		tAction.tap(point).perform();
	}

	public static void sendKeys(AndroidDriver<WebElement> driver, String eleXpath, String keys) {
		driver.findElement(By.xpath(eleXpath)).sendKeys(keys);
	}

	// 多手势
	@SuppressWarnings("rawtypes")
	public static void complexOperation(AndroidDriver<WebElement> driver, int delaytime, PointOption... options) {

		MultiTouchAction multiAction = new MultiTouchAction(driver);
		WaitOptions time = WaitOptions.waitOptions(Duration.ofMillis(delaytime));
		if (options != null) {
//			ArrayList<TouchAction> arrayList = new ArrayList<>();
			int len = options.length;
			int times = len / 2;
			for (int x = 0; x < times; x++) {
				TouchAction touchAction = new TouchAction(driver);
				int one = 2 * x;
				int two = 2 * x + 1;
				System.out.println("one:" + one);
				System.out.println("two" + two);
//				touchAction.press(options[2 * x]).waitAction(time).moveTo(options[(2 * x + 1)]).release();
				touchAction = touchAction.press(options[one]).waitAction(time).moveTo(options[two]).release();
				multiAction.add(touchAction);
//				arrayList.add(touchAction);

			}
//			Object[] array = arrayList.toArray();
//			for(int x=0;x<array.length;x++) {
//				multiAction.add((TouchAction)array[x]);
//			}
			multiAction.perform();
		}
	}

	@SuppressWarnings("rawtypes")
	public static void complexOperationTwo(AndroidDriver<WebElement> driver, int delaytime, PointOption optionA,
			PointOption optionB, PointOption optionC) {

		MultiTouchAction multiAction = new MultiTouchAction(driver);
		WaitOptions time = WaitOptions.waitOptions(Duration.ofMillis(delaytime));

		TouchAction touchActionA = new TouchAction(driver);
		TouchAction touchActionB = new TouchAction(driver);
		touchActionA = touchActionA.tap(optionA).release();
		touchActionB = touchActionB.press(optionB).waitAction(time).moveTo(optionC).release();
		multiAction.add(touchActionA).add(touchActionB).perform();
	}

	public static boolean writeIn(String source, String filePath) {
		boolean flag = false;
		BufferedWriter bw = null;

//		Scanner sc = new Scanner(new FileReader(filePath));
//		String line = null;

		try {
			// 表示不覆盖
			Writer fwriter = new FileWriter(filePath, true);
			bw = new BufferedWriter(fwriter);
//			while((sc.hasNextLine()&&(line=sc.nextLine())!=null)){
//			    if(!sc.hasNextLine()) {
//			    	bw.append(source);
//					flag = true;
//			    }
//			}

			bw.append(source);
			bw.newLine();
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;

	}

	public static String[] regexExtract(String str,String regex) {
		// 将正则表达式转成正则对象
		Pattern pattern = Pattern.compile(regex);
		// 正则对象与字符串匹配
		Matcher matcher = pattern.matcher(str);
		// 匹配成功后打印出找到的结果              
		ArrayList<String> list = new ArrayList<String>();
		while(matcher.find()){
			String group = matcher.group();
			list.add(group);
		}
		String[] arr = new String[list.size()];
		return	list.toArray(arr);
	}
	public static void pr(Object[] objArr) {
		for(int x=0;x<objArr.length;x++) {
			System.out.println(objArr[x]);
		}
	}
	
	public static String substring(String str,int before,int after) {
		str = str.substring(before);
		str = str.substring(0, str.length()-after);
		return str ; 
	}

}
