package com.cucumber.junit.hooks;

import com.cucumber.junit.driver.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {

    @Before
    public void setupDriver() {
        DriverManager.setupDriver();
    }

    //if I have just one scenario for 1 session
    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }

//    if I have more than 1 scenario for 1 session
//    @After(order=5)
//    public void cleanSession(){
//        DriverManager.getDriver().manage().deleteAllCookies();
//    }
}
