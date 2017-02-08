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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to mouse action
 *
 * @author jaspal
 */
public class MouseActionHandler {
    
private final ExtentTest extentLogger;
    
    public MouseActionHandler(ExtentTest extentLogger) {
        this.extentLogger = extentLogger;
    }
    
    private int webDriverWait_elementToBeClickable = 5;
    private int webDriverWait_visibilityOfElementLocated = 5;
    
    private HandleElements handleElements = new HandleElements();
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Click on element.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void click(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementToBeClickable);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not clickable
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                webElement.click();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Element clicked successfully");
                }
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to click on element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Click on element ("+elementName+")   Failure:- Unable to click on element, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Click on element ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementToBeClickable);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not clickable
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                webElement.click();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found element clicked successfully");
                }    
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", Unable to click on first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }   
                throw new RuntimeException("Step:- Click on element ("+elementName+")   Failure:- Unable to click on element, Exception occured: " + throwable.getMessage());
            }
        }
    }
    
    /**
     * Move mouse cursor on element.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void moveMouse(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Actions actions;
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
                actions = new Actions(HealthlinkSelenium.driver);
                actions.moveToElement(webElement).perform();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Move mouse on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Mouse should moved on element &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Mouse moved on element successfully");
                }
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Move mouse on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Mouse should moved on element &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to move mouse on element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Move mouse on element ("+elementName+")   Failure:- Unable to move mouse on element, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Move mouse on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Mouse should moved on element &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Move mouse on element ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        if (elementCount > 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actions = new Actions(HealthlinkSelenium.driver);
                actions.moveToElement(webElement).perform();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Move mouse on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Mouse should moved on element &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", mouse moved on first found element successfully");
                }  
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Move mouse on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Mouse should moved on element &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to move mouse on first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Move mouse on element ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to move mouse on first found element, Exception occured: " + throwable.getMessage());
            }
        }        
    }
    
    /**
     * Right click on element.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void rightClick(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Actions actions;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementToBeClickable);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not clickable
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actions = new Actions(HealthlinkSelenium.driver);
                actions.contextClick(webElement).perform();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Right click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be right clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Element right clicked successfully");
                }
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Right click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be right clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to righ click on element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Right click on element ("+elementName+")   Failure:- Unable to right click on element, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Right click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be right clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Right click on element ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        if (elementCount > 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementToBeClickable);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not clickable
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actions = new Actions(HealthlinkSelenium.driver);
                actions.contextClick(webElement).perform();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Right click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be right clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found element right clicked successfully");
                }  
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Right click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be right clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to right click on first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Right click on element ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to right click on first found element, Exception occured: " + throwable.getMessage());
            }
        }
    }
    
    /**
     * Double click on element.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void doubleClick(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Actions actions;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementToBeClickable);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not clickable
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actions = new Actions(HealthlinkSelenium.driver);
                actions.doubleClick(webElement).perform();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Double click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be double clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Element double clicked successfully");
                }
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Double click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be double clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to double click on element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Double click on element ("+elementName+")   Failure:- Unable to double click on element, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Double click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be double clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Double click on element ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        if (elementCount > 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementToBeClickable);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not clickable
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actions = new Actions(HealthlinkSelenium.driver);
                actions.doubleClick(webElement).perform();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Double click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be double clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found element double clicked successfully");
                }  
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Double click on element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Element should be double clicked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to double click on first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Double click on element ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to double click on first found element, Exception occured: " + throwable.getMessage());
            }
        }
    }

}
