package com.airsystem.android.appium.runner;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.airsystem.android.appium.utils.Constants;

/**
 * @author Budi Oktaviyan Suryanto (budi.oktaviyan@icloud.com)
 */
public class AppiumTestRunner {
	private WebDriver mWebDriver = null;

	@Before
	public void setup() {
		File appDir = new File("/home/oktav/Downloads/apk/");
		File app = new File(appDir, "AppSample.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.VERSION, "4.2");
		capabilities.setCapability(CapabilityType.PLATFORM, "LINUX");
		capabilities.setCapability(Constants.DEVICE_NAME, "On Android this capability is currently ignored");
		capabilities.setCapability(Constants.PLATFORM_NAME, "Android");
		capabilities.setCapability(Constants.APP, app.getAbsolutePath());
		capabilities.setCapability(Constants.APP_PACKAGE, "com.airsystem.app.sample");
		capabilities.setCapability(Constants.APP_ACTIVITY, "MainActivity");

		try {
			mWebDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		mWebDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}

	@Test
	public void appiumExampleTest() throws Exception {
		// Find button with content-description "NEXT" and click it
		WebElement button = mWebDriver.findElement(By.name("NEXT"));
		button.click();

		// Navigate back to previous screen and find button with content-description "NEXT"
		mWebDriver.navigate().back();
		mWebDriver.findElement(By.name("NEXT"));
	}

	@After
	public void tearDown() {
		if (mWebDriver != null) {
			mWebDriver.quit();
		}
	}
}