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

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to navigate and url
 *
 * @author jaspal
 */
public class UrlHandler {
    
    private int webDriverWait_urlContains = 15;
    private int webDriverWait_urlMatches = 15;
    
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Launch application on the basis of given URL.
     * 
     * @param appURL URL needs to be launched.
     */
    public void launchApp(String appURL) {
        try {
            HealthlinkSelenium.driver.get(appURL);
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Launch application ("+appURL+") &nbsp;&nbsp;&nbsp; <b>Expected - </b> Application should launch in the browser &nbsp;&nbsp;&nbsp; <b>Actual - </b> Application launched successfully");
            }   
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Launch application ("+appURL+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Application should launch in the browser &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to launch application</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Launch application ("+appURL+")   Failure:- Unable to launch application, Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Navigate to URL.
     * 
     * @param url URL where needs to be navigated.
     */
    public void navigateToUrl(String url) {
        try {
            HealthlinkSelenium.driver.navigate().to(url);
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Navigate to URL ("+url+") &nbsp;&nbsp;&nbsp; <b>Expected - </b> User should navigate to new URL &nbsp;&nbsp;&nbsp; <b>Actual - </b> User navigated to new URL successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Navigate to URL ("+url+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> User should navigate to new URL &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to navigate to new URL</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Navigate to URL ("+url+")   Failure:- Unable to navigate to new URL, Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Perform navigate back.
     */
    public void navigateBack() {
        try {
            HealthlinkSelenium.driver.navigate().back();
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Navigate back &nbsp;&nbsp;&nbsp; <b>Expected - </b> Page should navigated back &nbsp;&nbsp;&nbsp; <b>Actual - </b> Page navigated back successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Navigate back &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page should navigated back &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to navigate back</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Navigate back   Failure:- Unable to navigate back, Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Perform navigate forward.
     */
    public void navigateForward() {
        try {
            HealthlinkSelenium.driver.navigate().forward();
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Navigate forward &nbsp;&nbsp;&nbsp; <b>Expected - </b> Page should navigated forward &nbsp;&nbsp;&nbsp; <b>Actual - </b> Page navigated forward successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Navigate forward &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page should navigated forward &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to navigate forward</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Navigate forward   Failure:- Unable to navigate forward, Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Refresh page.
     */
    public void refreshPage() {
        try {
            HealthlinkSelenium.driver.navigate().refresh();
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Refresh page &nbsp;&nbsp;&nbsp; <b>Expected - </b> Page should refreshed &nbsp;&nbsp;&nbsp; <b>Actual - </b> Page refreshed successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Refresh page &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page should refreshed &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to refresh page</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Refresh page   Failure:- Unable to refresh page, Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Verify page URL equals.
     * 
     * @param expectedUrl Expected URL of the page.
     */
    public void verifyPageUrlEquals(String expectedUrl) {
        String actualURL;
        boolean gotActualUrl;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_urlContains);
            webDriverWait.until(ExpectedConditions.urlContains(expectedUrl));
        }
        catch (Throwable throwable ) {
            // After wait, go forward if actual url not contains expected url
        }
        try {
            actualURL = HealthlinkSelenium.driver.getCurrentUrl();
            gotActualUrl = true;
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify current page URL &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page URL should be: <mark>"+expectedUrl+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get page URL</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Verify current page URL   Failure:- Unable to get page URL, Exception occured: " + throwable.getMessage());
        }
        if(gotActualUrl) {
            if(actualURL.trim().equals(expectedUrl.trim())) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify current page URL &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page URL should be: "+expectedUrl+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page URL is: "+actualURL);
                }
            }
            else {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify current page URL &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page URL should be: <mark>"+expectedUrl+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page URL is: <mark>"+actualURL+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
                }
                throw new RuntimeException("Step:- Verify current page URL   Failure:- Actual URL is: "+actualURL+", which is not equal to expected URL: "+expectedUrl);
            }
        }
    }
    
    /**
     * Verify page URL contains.
     * 
     * @param expectedUrl Expected partial URL of the page.
     */
    public void verifyPageUrlContains(String expectedUrl) {
        String actualURL;
        boolean gotActualUrl;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_urlContains);
            webDriverWait.until(ExpectedConditions.urlContains(expectedUrl));
        }
        catch (Throwable throwable ) {
            // After wait, go forward if actual url not contains expected url
        }
        try {
            actualURL = HealthlinkSelenium.driver.getCurrentUrl();
            gotActualUrl = true;
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify current page URL &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page URL should contains: <mark>"+expectedUrl+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get page URL</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Verify current page URL   Failure:- Unable to get page URL, Exception occured: " + throwable.getMessage());
        }
        if(gotActualUrl) {
            if(actualURL.trim().contains(expectedUrl.trim())) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify current page URL &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page URL should contains: "+expectedUrl+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page URL is: "+actualURL);
                }
            }
            else {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify current page URL &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page URL should contains: <mark>"+expectedUrl+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page URL is: <mark>"+actualURL+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
                }
                throw new RuntimeException("Step:- Verify current page URL   Failure:- Actual URL is: "+actualURL+", which does not contains expected URL: "+expectedUrl);
            }
        }
    }
    
    /**
     * Verify page URL with regular expression.
     * 
     * @param expectedRegEx Regular expression of expected URL of the page.
     */
    public void verifyPageUrlWithRegEx(String expectedRegEx) {
        String actualURL;
        boolean gotActualUrl;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_urlMatches);
            webDriverWait.until(ExpectedConditions.urlMatches(expectedRegEx));
        }
        catch (Throwable throwable ) {
            // After wait, go forward if actual url does not match with expected regular expression
        }
        try {
            actualURL = HealthlinkSelenium.driver.getCurrentUrl();
            gotActualUrl = true;
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify current page URL &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page URL should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get page URL</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Verify current page URL   Failure:- Unable to get page URL, Exception occured: " + throwable.getMessage());
        }
        if(gotActualUrl) {
            if(actualURL.trim().matches(expectedRegEx.trim())) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify current page URL &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page URL should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page URL is: "+actualURL);
                }
            }
            else {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify current page URL &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page URL should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page URL is: <mark>"+actualURL+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
                }
                throw new RuntimeException("Step:- Verify current page URL   Failure:- Actual URL is: "+actualURL+", which does not match with regular expression: "+expectedRegEx);
            }
        }
    }

}
