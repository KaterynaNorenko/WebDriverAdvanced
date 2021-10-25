package com.cucumber.junit.util;

import org.openqa.selenium.JavascriptExecutor;

import static com.cucumber.junit.driver.DriverManager.getDriver;


public class JsExecutorManager {

	public static <T> T executeJsScript(String script, Object... objects) {
		return (T) ((JavascriptExecutor) getDriver()).executeScript(script, objects);
	}
}