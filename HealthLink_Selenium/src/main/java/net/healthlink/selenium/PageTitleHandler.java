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

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to page title
 *
 * @author jaspal
 */
public class PageTitleHandler {
    
private final ExtentTest extentLogger;
    
    public PageTitleHandler(ExtentTest extentLogger) {
        this.extentLogger = extentLogger;
    }
    
    private int webDriverWait_titleIs = 15;
    private int webDriverWait_titleContains = 15;
    
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Verify page title equals.
     * 
     * @param expectedTitle Expected title (text) of the page..
     */
    public void verifyPageTitleEquals(String expectedTitle) {
        String actualTitle;
        boolean gotActualTitle;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_titleIs);
            webDriverWait.until(ExpectedConditions.titleIs(expectedTitle));
        }
        catch (Throwable throwable ) {
            // After wait, go forward if actual title not contains expected title
        }
        
        try {
            actualTitle = HealthlinkSelenium.driver.getTitle();
            gotActualTitle = true;
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify current page title &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page title should be: <mark>"+expectedTitle+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get page title</mark> " + extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }    
            throw new RuntimeException("Step:- Verify current page title   Failure:- Unable to get page title, Exception occured: " + throwable.getMessage());
        }
        if(gotActualTitle) {
            if(actualTitle.trim().equals(expectedTitle.trim())) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify current page title &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page title should be: "+expectedTitle+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page title is: "+actualTitle);
                }       
            }
            else {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify current page title &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page title should be: <mark>"+expectedTitle+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page title is: <mark>"+actualTitle+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
                }
                throw new RuntimeException("Step:- Verify current page title   Failure:- Actual title is: "+actualTitle+", which is not equal to expected title: "+expectedTitle);
            }
        }
    }

    /**
     * Verify page title contains.
     * 
     * @param expectedTitle Expected title (partial text) of the page..
     */
    public void verifyPageTitleContains(String expectedTitle) {
        String actualTitle;
        boolean gotActualTitle;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_titleContains);
            webDriverWait.until(ExpectedConditions.titleContains(expectedTitle));
        }
        catch (Throwable throwable ) {
            // After wait, go forward if actual title not contains expected title
        }
        try {
            actualTitle = HealthlinkSelenium.driver.getTitle();
            gotActualTitle = true;
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify current page title &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page title should contains: <mark>"+expectedTitle+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get page title</mark> " + extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }   
            throw new RuntimeException("Step:- Verify current page title   Failure:- Unable to get page title, Exception occured: " + throwable.getMessage());
        }
        if(gotActualTitle) {
            if(actualTitle.trim().contains(expectedTitle.trim())) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify current page title &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page title should contains: "+expectedTitle+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page title is: "+actualTitle);
                }
            }
            else {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify current page title &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page title should contains: <mark>"+expectedTitle+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page title is: <mark>"+actualTitle+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
                }
                throw new RuntimeException("Step:- Verify current page title   Failure:- Actual title is: "+actualTitle+", which does not contains expected title: "+expectedTitle);
            }
        }
    }
    
    /**
     * Verify page title equals regular expression.
     * 
     * @param expectedRegEx Regular expression of expected title of the page..
     */
    public void verifyPageTitleWithRegEx(String expectedRegEx) {
        String actualTitle;
        boolean gotActualTitle;
        try {
            actualTitle = HealthlinkSelenium.driver.getTitle();
            gotActualTitle = true;
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify current page title &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page title should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get page title</mark> " + extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            } 
            throw new RuntimeException("Step:- Verify current page title   Failure:- Unable to get page title, Exception occured: " + throwable.getMessage());
        }
        if(gotActualTitle) {
            if(actualTitle.trim().matches(expectedRegEx)) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify current page title &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page title should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page title is: "+actualTitle);
                }
            }
            else {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify current page title &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page title should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page title is: <mark>"+actualTitle+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
                }
                throw new RuntimeException("Step:- Verify current page title   Failure:- Actual title is: "+actualTitle+", which does not match with regular expression: "+expectedRegEx);
            }
        }
    }

}
