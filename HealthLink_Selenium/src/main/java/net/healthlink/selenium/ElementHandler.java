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
 * This class contains all methods related to element
 *
 * @author jaspal
 */
public class ElementHandler {
    
private final ExtentTest extentLogger;
    
    public ElementHandler(ExtentTest extentLogger) {
        this.extentLogger = extentLogger;
    }
    
    private int webDriverWait_numberOfElementsToBe0 = 15;
    private int webDriverWait_visibilityOfElementLocated = 5;
    private int webDriverWait_invisibilityOfElementLocated = 15;
    
    private HandleElements handleElements = new HandleElements();
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Verify element present on the page.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void verifyElementPresent(String elementName, By elementLocator) {
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify element present ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be present on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Element present");
            }         
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element present ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be present on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }       
            throw new RuntimeException("Step:- Verify element present on page ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify element present ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be present on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements present with locator: "+elementLocator);
            }         
        }
    }
    
    /**
     * Verify element not present on the page.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void verifyElementNotPresent(String elementName, By elementLocator) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_numberOfElementsToBe0);
            webDriverWait.until(ExpectedConditions.numberOfElementsToBe(elementLocator, 0));
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify element not present ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should not be present on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Element is not present");
            }
        }
        catch (Throwable throwable ) {
            int elementCount = handleElements.getElementCount(elementLocator);
            WebElement webElement = handleElements.extractElement(elementLocator);
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element not present ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should not be present on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" element(s) present with locator: "+elementLocator+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
            }   
            throw new RuntimeException("Step:- Verify element not present ("+elementName+")   Failure:- "+elementCount+" element(s) present with locator: "+elementLocator+", Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Verify element displayed on the page.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void verifyElementDisplayed(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement;
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
                webElement.isDisplayed();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify element displayed ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be displayed on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Element displayed successfully");
                } 
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element displayed ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be displayed on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>No element displayed with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify element displayed ("+elementName+")   Failure:- No element displayed with locator: "+elementLocator+", Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element displayed on page ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be displayed &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }       
            throw new RuntimeException("Unable to find element with locator: "+elementLocator);
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
                webElement.isDisplayed();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify element displayed ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be displayed on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements displayed with locator: "+elementLocator);
                } 
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element displayed ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be displayed on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", but first found element is not displayed</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()) + throwable.getMessage());
                }   
                throw new RuntimeException("Step:- Verify element displayed ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", but first found element is not displayed, Exception occured: " + throwable.getMessage());
            }
        }
    }
       
    /**
     * Verify element should be invisible.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void verifyElementInvisible(String elementName, By elementLocator) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_invisibilityOfElementLocated);
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify element invisible ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be invisible &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Element is invisible");
            }
        }
        catch (Throwable throwable ) {
            int elementCount = handleElements.getElementCount(elementLocator);
            WebElement webElement = handleElements.extractElement(elementLocator);
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element invisible ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be invisible &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" element(s) visible with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Verify element invisible ("+elementName+")   Failure:- "+elementCount+" element(s) visible with locator: "+elementLocator+", Exception occured: " + throwable.getMessage());
        }   
    }
    
    /**
     * Verify element enabled.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void verifyElementEnabled(String elementName, By elementLocator) {
        WebElement webElement = null;
        boolean enabledStatus = false;
        boolean gotEnabledStatus;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                enabledStatus = webElement.isEnabled();
                gotEnabledStatus = true;
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element enabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be enabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get enable status from element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify element enabled ("+elementName+")   Failure:- Unable to get enable status from element, Exception occured: " + throwable.getMessage());
            }
            if(gotEnabledStatus) {
                if(enabledStatus == true) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify element enabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be enabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Element is enabled");
                    }
                }
                else if(enabledStatus == false) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element enabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be enabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Element is not enabled" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                        throw new RuntimeException("Step:- Verify element enabled ("+elementName+")   Failure:- Element is not enabled");
                    }
                }
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element enabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be enabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }       
            throw new RuntimeException("Step:- Verify element enabled ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                enabledStatus = webElement.isEnabled();
                gotEnabledStatus = true;
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element enabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be enabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get enable status from element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify element enabled ("+elementName+")   Failure:- Unable to get enable status from element, Exception occured: " + throwable.getMessage());
            }
            if(gotEnabledStatus) {
                if(enabledStatus == true) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify element enabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be enabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found element is enabled");
                    }
                }
                else if(enabledStatus == false) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element enabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be enabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found element is not enabled" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                        throw new RuntimeException("Step:- Verify element enabled ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", first found element is not enabled");
                    }
                }
            }   
        }
    }
    
    /**
     * Verify element disabled.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void verifyElementDisabled(String elementName, By elementLocator) {
        WebElement webElement = null;
        boolean enabledStatus = true;
        boolean gotEnabledStatus;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                enabledStatus = webElement.isEnabled();
                gotEnabledStatus = true;
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element disabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be disabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get disable status from element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify element disabled ("+elementName+")   Failure:- Unable to get disable status from element, Exception occured: " + throwable.getMessage());
            }
            if(gotEnabledStatus) {
                if(enabledStatus == false) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify element disabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be disabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Element is disabled");
                    }
                }
                else if(enabledStatus == true) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element disabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be disabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Element is not disabled" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                        throw new RuntimeException("Step:- Verify element disabled ("+elementName+")   Failure:- Element is not disabled");
                    }
                }
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element disabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be disabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }       
            throw new RuntimeException("Step:- Verify element disabled ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                enabledStatus = webElement.isEnabled();
                gotEnabledStatus = true;
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element disabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be disabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get disable status from element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify element disabled ("+elementName+")   Failure:- Unable to get disable status from element, Exception occured: " + throwable.getMessage());
            }
            if(gotEnabledStatus) {
                if(enabledStatus == false) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify element disabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be disabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found element is disabled");
                    }
                }
                else if(enabledStatus == true) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify element disabled ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be disabled &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found element is not disabled" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                        throw new RuntimeException("Step:- Verify element disabled ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", first found element is not disabled");
                    }
                }
            }   
        }
    }

}
