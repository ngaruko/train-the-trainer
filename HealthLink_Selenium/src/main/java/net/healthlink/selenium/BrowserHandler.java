/*
 * Copyright (c) 2016 HealthLink Limited.
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 *
 */
package net.healthlink.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to browser
 *
 * @author jaspal
 */
public class BrowserHandler {
    
private int pageLoadTimeout = 60;
    
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Launch browser.
     * 
     * Make sure, before calling this method the driver of a particular browser should be available within the project under 'browser driver' folder.
     * 
     * @param browserName Name of the browser which needs to be launched. Options include: firefox, chrome, ie, edge and safari.
     */
    public void launchBrowser(String browserName) {
        if (browserName.toLowerCase().contains("firefox") || browserName.toLowerCase().contains("chrome") || browserName.toLowerCase().contains("ie") || browserName.toLowerCase().contains("edge") || browserName.toLowerCase().contains("safari")) {
            try {
                if(browserName.toLowerCase().contains("firefox")) {
                    System.setProperty("webdriver.gecko.driver","browser driver\\geckodriver.exe");
                    HealthlinkSelenium.driver = new FirefoxDriver();
                }
                else if(browserName.toLowerCase().contains("chrome")) {
                    System.setProperty("webdriver.chrome.driver","browser driver\\chromedriver.exe");
                    HealthlinkSelenium.driver = new ChromeDriver();
                }
                else if(browserName.toLowerCase().contains("ie")) {
                    System.setProperty("webdriver.ie.driver","browser driver\\IEDriverServer.exe");
                    HealthlinkSelenium.driver = new InternetExplorerDriver();
                }
                else if(browserName.toLowerCase().contains("edge")) {
                    System.setProperty("webdriver.edge.driver","browser driver\\MicrosoftWebDriver.exe");
                    HealthlinkSelenium.driver = new EdgeDriver();
                }
                else if(browserName.toLowerCase().contains("safari")) {
                    HealthlinkSelenium.driver = new SafariDriver();
                }
                HealthlinkSelenium.driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Launch browser window ("+browserName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Browser should launched &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Browser launched successfully");
                }
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Launch browser window ("+browserName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Browser should launched &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to launch browser</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage()); 
                }
                throw new RuntimeException("Step:- Launch browser window ("+browserName+")   Failure:- Unable to launch browser, Exception occured: " + throwable.getMessage());
            }
        }
        else {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.WARNING, "<b>Step - </b> Launch browser window ("+browserName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Browser should launched &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Browser options are 'firefox, chrome, ie, edge or safari', one needs to be pass as a parameter</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot())); 
            }
            throw new RuntimeException("Step:- Launch browser window ("+browserName+")   Failure:- Browser options are 'firefox, chrome, ie, edge or safari', one needs to be pass as a parameter");
        }
    }

    /**
     * Quit all browser windows and session.
     */
    public void quitBrowser() {
        try {
            if(HealthlinkSelenium.driver != null) {
                HealthlinkSelenium.driver.quit();
            }
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Quit browser window and session &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Browser should quit &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Browser quit successfully");
            }   
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Quit browser window and session &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Browser should quit &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to quit browser</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }           
            throw new RuntimeException("Step:- Quit browser window and session   Failure:- Unable to quit browser, Exception occured: " + throwable.getMessage());
        }
    }

    /**
     * Close one browser window (active window).
     */
    public void closeBrowser() {
        try {
            HealthlinkSelenium.driver.close();
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Close browser window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Browser should be closed &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Browser closed successfully");
            }
            
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Close browser window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Browser should be closed &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to close browser</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }           
            throw new RuntimeException("Step:- Close browser window   Failure:- Unable to close browser, Exception occured: " + throwable.getMessage());
        }
    }

    /**
     * Maximize browser window.
     */
    public void maximizeBrowser() {
        try {
            HealthlinkSelenium.driver.manage().window().maximize();
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Maximize browser window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Browser window should be maximized &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Browser window maximized successfully");
            }           
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Maximize browser window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Browser window should be maximized &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to maximize browser window</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }           
            throw new RuntimeException("Step:- Maximize browser window   Failure:- Unable to maximize browser window, Exception occured: " + throwable.getMessage());
        }
    }

}
