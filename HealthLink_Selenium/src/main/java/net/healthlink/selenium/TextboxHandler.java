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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to textbox
 *
 * @author jaspal
 */
public class TextboxHandler {
    
    private final ExtentTest extentLogger;
    
    public TextboxHandler(ExtentTest extentLogger) {
        this.extentLogger = extentLogger;
    }
    
    private int webDriverWait_visibilityOfElementLocated = 5;
    private int webDriverWait_textToBePresentInElementValue = 5;
    
    private HandleElements handleElements = new HandleElements();
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Fill value in text box.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object
     * @param value Text to be filled in textbox
     */
    public void fillValue(String elementName, By elementLocator, String value) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                webElement.clear();
                webElement.sendKeys(value);
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Fill value ("+value+") in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be filled in textbox &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Value filled successfully");
                }
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Fill value ("+value+") in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be filled in textbox &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to fill value</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Fill value ("+value+") in ("+elementName+")   Failure:- Unable to fill value, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Fill value ("+value+") in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be filled in textbox &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Fill value ("+value+") in ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                webElement.clear();
                webElement.sendKeys(value);
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Fill value ("+value+") in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be filled in textbox &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", value filled successfully in first found element");
                }
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Fill value ("+value+") in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be filled in textbox &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to fill value in first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Fill value ("+value+") in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to fill value in first found element, Exception occured: " + throwable.getMessage());
            }
        }
    }
    
    /**
     * Clear value from text box.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object
     */
    public void clearValue(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        int elementCount = handleElements.getElementCount(elementLocator);
    
        if (elementCount == 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                webElement.clear();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Clear value from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be cleared from textbox &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Value cleared successfully");
                }
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Clear value from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be cleared from textbox &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to clear value</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Clear value from ("+elementName+")   Failure:- Unable to clear value, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Clear value from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be cleared from textbox &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Clear value from ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                webElement.clear();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Clear value from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be cleared from textbox &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", value cleared successfully from first found element");
                }
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Clear value from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be cleared from textbox &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to clear value from first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Clear value from ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to clear value in first found element, Exception occured: " + throwable.getMessage());
            }
        }
    }
    
    /**
     * Verify value in text box equals.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object
     * @param expectedValue Expected text in textbox
     */
    public void verifyValueEquals(String elementName, By elementLocator, String expectedValue) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        String actualValue;
        boolean gotValue;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_textToBePresentInElementValue);
                webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(elementLocator, expectedValue));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if value not contains expected value
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actualValue = webElement.getAttribute("value");
                gotValue = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be: "+expectedValue+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get value from textbox</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());        
                }
                throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- Unable to get value from textbox, Exception occured: " + throwable.getMessage());
            }          
            if(gotValue) {
                if(actualValue.trim().equals(expectedValue.trim())) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be: "+expectedValue+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Value is: "+actualValue);
                    }
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be: <mark>"+expectedValue+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Value is: <mark>"+actualValue+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }
                    throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- Actual value is: "+actualValue+", which is not equal to expected value: "+expectedValue);
                }
            } 
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be: <mark>"+expectedValue+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_textToBePresentInElementValue);
                webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(elementLocator, expectedValue));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if value not contains expected value
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actualValue = webElement.getAttribute("value");
                gotValue = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be: "+expectedValue+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to get value from first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to get value from first found element, Exception occured: " + throwable.getMessage());
            }
            if(gotValue) {
                if(actualValue.trim().equals(expectedValue.trim())) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be: "+expectedValue+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", value in first found element is: "+actualValue);
                    }
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should be: <mark>"+expectedValue+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", value in first found element is: <mark>"+actualValue+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }
                    throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", actual value in first found element is: "+actualValue+", which is not equal to expected value: "+expectedValue);
                }
            }
        }
    }
    
    /**
     * Verify value in text box contains.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object
     * @param expectedValue Expected partial text in textbox
     */
    public void verifyValueContains(String elementName, By elementLocator, String expectedValue) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        String actualValue;
        boolean gotValue;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {            
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_textToBePresentInElementValue);
                webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(elementLocator, expectedValue));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if value not contains expected value
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actualValue = webElement.getAttribute("value");
                gotValue = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should contains: "+expectedValue+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get value from textbox</mark> " + extentLogger.addScreenCapture(screenshotManager.getFullScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- Unable to get value from textbox, Exception occured: " + throwable.getMessage());
            }
            if(gotValue) {
                if(actualValue.trim().contains(expectedValue.trim())) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should contains: "+expectedValue+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Value is: "+actualValue);
                    }
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should contains: <mark>"+expectedValue+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Value is: <mark>"+actualValue+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }
                    throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- Actual value is: "+actualValue+", which does not contains expected value: "+expectedValue);
                }
            } 
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should contains: <mark>"+expectedValue+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_textToBePresentInElementValue);
                webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(elementLocator, expectedValue));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if value not contains expected value
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actualValue = webElement.getAttribute("value");
                gotValue = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should contains: "+expectedValue+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to get value from first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to get value from first found element, Exception occured: " + throwable.getMessage());
            }
            if(gotValue) {
                if(actualValue.trim().contains(expectedValue.trim())) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should contains: "+expectedValue+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", value in first found element is: "+actualValue);
                    }
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should contains: <mark>"+expectedValue+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", value in first found element is: <mark>"+actualValue+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }
                    throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", actual value in first found element is: "+actualValue+", which does not contains expected value: "+expectedValue);
                }
            }
        }
    }
    
    /**
     * Verify value in text box with regular expression.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object
     * @param expectedRegEx Regular expression of expected text in textbox
     */
    public void verifyValueWithRegEx(String elementName, By elementLocator, String expectedRegEx) {
        WebElement webElement = null;
        String actualValue;
        boolean gotValue;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                actualValue = webElement.getAttribute("value");
                gotValue = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get value from textbox</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- Unable to get value from textbox, Exception occured: " + throwable.getMessage());
            }
            if(gotValue) {
                if(actualValue.trim().matches(expectedRegEx.trim())) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Value is: "+actualValue);
                    }
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Value is: <mark>"+actualValue+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }
                    throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- Actual value is: "+actualValue+", which does not match with regular expression: "+expectedRegEx);
                }
            } 
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                actualValue = webElement.getAttribute("value");
                gotValue = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to get value from first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to get value from first found element, Exception occured: " + throwable.getMessage());
            }
            if(gotValue) {
                if(actualValue.trim().matches(expectedRegEx.trim())) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", value in first found element is: "+actualValue);
                    }
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify value in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Value should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", value in first found element is: <mark>"+actualValue+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }
                    throw new RuntimeException("Step:- Verify value in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", actual value in first found element is: "+actualValue+", which does not match with regular expression: "+expectedRegEx);
                }
            }
        }
    }

}
