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

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to alert
 *
 * @author jaspal
 */
public class AlertHandler {
    
    private int webDriverWait_alertIsPresent = 5;
    
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Switch to alert, verify text equals and accept it.
     * 
     * @param expectedText Expected text on alert.
     */
    public void verifyAlertTextEqualsAndAcceptIt(String expectedText) {
        Alert alert;
        String actualAlertText;
        boolean gotAlertText;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_alertIsPresent);
            webDriverWait.until(ExpectedConditions.alertIsPresent());
        }
        catch (Throwable throwable ) {
            // After wait, go forward if alert is not present
        }
        try {
            alert = HealthlinkSelenium.driver.switchTo().alert();
            actualAlertText = alert.getText();
            gotAlertText = true;
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify alert text and accept it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should be: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get text from alert</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }    
            throw new RuntimeException("Step:- Verify alert text and accept it   Failure:- Unable to get text from alert, Exception occured: " + throwable.getMessage());
        }
        if(gotAlertText) {
            if(actualAlertText.trim().equals(expectedText.trim())) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify alert text and accept it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should be: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Alert text is: "+actualAlertText);
                }       
            }
            else {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify alert text and accept it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should be: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Alert text is: <mark>"+actualAlertText+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
                }
                throw new RuntimeException("Step:- Verify alert text and accept it   Failure:- Actual text on alert is: "+actualAlertText+", which is not equal to expected text: "+expectedText);
            }
        }
        alert.accept(); 
    }
    
    /**
     * Switch to alert, verify text contains and accept it.
     * 
     * @param expectedText Expected partial text on alert.
     */
    public void verifyAlertTextContainsAndAcceptIt(String expectedText) {
        Alert alert;
        String actualAlertText;
        boolean gotAlertText;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_alertIsPresent);
            webDriverWait.until(ExpectedConditions.alertIsPresent());   
        }
        catch (Throwable throwable ) {
            // After wait, go forward if alert is not present
        }
        try {
            alert = HealthlinkSelenium.driver.switchTo().alert();
            actualAlertText = alert.getText();
            gotAlertText = true;
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify alert text and accept it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should contains: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get text from alert</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }    
            throw new RuntimeException("Step:- Verify alert text and accept it   Failure:- Unable to get text from alert, Exception occured: " + throwable.getMessage());
        }
        if(gotAlertText) {
            if(actualAlertText.trim().contains(expectedText.trim())) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify alert text and accept it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should contains: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Alert text is: "+actualAlertText);
                }       
            }
            else {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify alert text and accept it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should contains: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Alert text is: <mark>"+actualAlertText+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
                }
                throw new RuntimeException("Step:- Verify alert text and accept it   Failure:- Actual text on alert is: "+actualAlertText+", which does not contains expected text: "+expectedText);
            }
        }
        alert.accept(); 
    }
    
    /**
     * Switch to alert, verify text with regular expression and accept it.
     * 
     * @param expectedRegEx Regular expression of expected text on alert.
     */
    public void verifyAlertTextWithRegExAndAcceptIt(String expectedRegEx) {
        Alert alert;
        String actualAlertText;
        boolean gotAlertText;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_alertIsPresent);
            webDriverWait.until(ExpectedConditions.alertIsPresent());   
        }
        catch (Throwable t) {
            // After wait, go forward if alert is not present
        }
        try {
            alert = HealthlinkSelenium.driver.switchTo().alert();
            actualAlertText = alert.getText();
            gotAlertText = true;
        }
        catch (Throwable t) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify alert text and accept it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get text from alert</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + t.getMessage());
            }    
            throw new RuntimeException("Step:- Verify alert text and accept it   Failure:- Unable to get text from alert, Exception occured: " + t.getMessage());
        }
        if(gotAlertText) {
            if(actualAlertText.trim().matches(expectedRegEx.trim())) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify alert text and accept it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Alert text is: "+actualAlertText);
                }       
            }
            else {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify alert text and accept it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Alert text is: <mark>"+actualAlertText+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
                }
                throw new RuntimeException("Step:- Verify alert text and accept it   Failure:- Actual text on alert is: "+actualAlertText+", which does not match with regular expression: "+expectedRegEx);
            }
        }
        alert.accept(); 
    }
    
    /**
     * Switch to alert, verify text equals and dismiss it.
     * 
     * @param expectedText Expected text on alert.
     */
    public void verifyAlertTextEqualsAndDismissIt(String expectedText) {
        Alert alert;
        String actualAlertText;
        boolean gotAlertText;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_alertIsPresent);
            webDriverWait.until(ExpectedConditions.alertIsPresent());   
        }
        catch (Throwable t) {
            // After wait, go forward if alert is not present
        }
        try {
            alert = HealthlinkSelenium.driver.switchTo().alert();
            actualAlertText = alert.getText();  
            gotAlertText = true;
        }
        catch (Throwable t) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify alert text and dismiss it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should be: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get text from alert</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + t.getMessage());
            }    
            throw new RuntimeException("Step:- Verify alert text and dismiss it   Failure:- Unable to get text from alert, Exception occured: " + t.getMessage());
        }
        if(gotAlertText) {
            if(actualAlertText.trim().equals(expectedText.trim())) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify alert text and dismiss it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should be: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Alert text is: "+actualAlertText);
                }       
            }
            else {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify alert text and dismiss it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should be: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Alert text is: <mark>"+actualAlertText+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
                }
                throw new RuntimeException("Step:- Verify alert text and dismiss it   Failure:- Actual text on alert is: "+actualAlertText+", which is not equal to expected text: "+expectedText);
            }
        }
        alert.dismiss();
    }
    
    /**
     * Switch to alert, verify text contains and dismiss it.
     * 
     * @param expectedText Expected partial text on alert.
     */
    public void verifyAlertTextContainsAndDismissIt(String expectedText) {
        Alert alert;
        String actualAlertText;
        boolean gotAlertText;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_alertIsPresent);
            webDriverWait.until(ExpectedConditions.alertIsPresent());   
        }
        catch (Throwable throwable ) {
            // After wait, go forward if alert is not present
        }
        try {
            alert = HealthlinkSelenium.driver.switchTo().alert();
            actualAlertText = alert.getText();  
            gotAlertText = true;
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify alert text and dismiss it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should contains: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get text from alert</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }    
            throw new RuntimeException("Step:- Verify alert text and dismiss it   Failure:- Unable to get text from alert, Exception occured: " + throwable.getMessage());
        }
        if(gotAlertText) {
            if(actualAlertText.trim().contains(expectedText.trim())) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify alert text and dismiss it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should contains: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Alert text is: "+actualAlertText);
                }       
            }
            else {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify alert text and dismiss it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should contains: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Alert text is: <mark>"+actualAlertText+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
                }
                throw new RuntimeException("Step:- Verify alert text and dismiss it   Failure:- Actual text on alert is: "+actualAlertText+", which is not equal to expected text: "+expectedText);
            }
        }
        alert.dismiss();
    }
    
    /**
     * Switch to alert, verify text with regular expression and dismiss it.
     * 
     * @param expectedRegEx Regular expression of expected text on alert.
     */
    public void verifyAlertTextWithRegExAndDismissIt(String expectedRegEx) {
        Alert alert;
        String actualAlertText;
        boolean gotAlertText;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_alertIsPresent);
            webDriverWait.until(ExpectedConditions.alertIsPresent());   
        }
        catch (Throwable throwable ) {
            // After wait, go forward if alert is not present
        }
        try {
            alert = HealthlinkSelenium.driver.switchTo().alert();
            actualAlertText = alert.getText();
            gotAlertText = true;
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify alert text and dismiss it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get text from alert</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }    
            throw new RuntimeException("Step:- Verify alert text and dismiss it   Failure:- Unable to get text from alert, Exception occured: " + throwable.getMessage());
        }
        if(gotAlertText) {
            if(actualAlertText.trim().matches(expectedRegEx.trim())) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify alert text and dismiss it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Alert text is: "+actualAlertText);
                }       
            }
            else {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify alert text and dismiss it &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Alert text should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Alert text is: <mark>"+actualAlertText+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
                }
                throw new RuntimeException("Step:- Verify alert text and dismiss it   Failure:- Actual text on alert is: "+actualAlertText+", which does not match with regular expression: "+expectedRegEx);
            }
        }
        alert.dismiss();
    }

}
