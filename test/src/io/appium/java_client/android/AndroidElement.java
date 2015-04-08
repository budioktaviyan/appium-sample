package io.appium.java_client.android;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;

public class AndroidElement extends MobileElement implements
		FindsByAndroidUIAutomator {
	
	@Override
	public WebElement findElementByAndroidUIAutomator(String using) {
		return findElement("-android uiautomator", using);
	}

	@Override
	public List<WebElement> findElementsByAndroidUIAutomator(String using) {
		return findElements("-android uiautomator", using);
	}

}
