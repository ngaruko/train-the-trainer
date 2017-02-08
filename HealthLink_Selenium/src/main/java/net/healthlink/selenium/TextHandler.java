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

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to text
 *
 * @author jaspal
 */
public class TextHandler {
    
private final ExtentTest extentLogger;
    
    public TextHandler(ExtentTest extentLogger) {
        this.extentLogger = extentLogger;
    }
    
    private int webDriverWait_textToBePresentInElementLocated = 5;
    private int webDriverWait_textMatches = 5;
    
    private HandleElements handleElements = new HandleElements();
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Get the text from an element and match it with the expected text.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object
     * @param expectedText Expected text in the element
     */
    public void verifyTextInElementEquals(String elementName, By elementLocator, String expectedText) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        String actualText;
        boolean gotText;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_textToBePresentInElementLocated);
                webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocator, expectedText));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element does not contains expected text
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actualText = webElement.getText();
                gotText = true;
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get text from element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify available text   Failure:- Unable to get text from element, Exception occured: " + throwable.getMessage());
            }
            if(gotText) {
                if(actualText.trim().equals(expectedText.trim())) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Text is: "+actualText);
                    }
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Text is: <mark>"+actualText+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }
                    throw new RuntimeException("Step:- Verify available text   Failure:- Actual available text is: "+actualText+", which is not equal to expected text: "+expectedText);
                }
            }           
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Verify available text   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_textToBePresentInElementLocated);
                webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocator, expectedText));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element does not contains expected text
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actualText = webElement.getText();
                gotText = true;
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", unable to get text from first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify available text   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to get text from first found element, Exception occured: " + throwable.getMessage());
            }
            if(gotText) {
                if(actualText.trim().equals(expectedText.trim())) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", text in first found element is: "+actualText);
                    }
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", text in first found element is: <mark>"+actualText+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }
                    throw new RuntimeException("Step:- Verify available text   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", actual available text in first found element is: "+actualText+", which is not equal to expected text: "+expectedText);
                }
            }        
        }
    }
    
    /**
     * Get the text from an element and verify it should contains expected text.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object
     * @param expectedText Expected partial text in the element
     */
    public void verifyTextInElementContains(String elementName, By elementLocator, String expectedText) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        String actualText;
        boolean gotText;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_textToBePresentInElementLocated);
                webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocator, expectedText));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element does not contains expected text
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actualText = webElement.getText();
                gotText = true;
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should contains: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get text from element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify available text   Failure:- Unable to get text from element, Exception occured: " + throwable.getMessage());
            }
            if(gotText) {
                if(actualText.trim().contains(expectedText.trim())) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should contains: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Text is: "+actualText);
                    }
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should contains: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Text is: <mark>"+actualText+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }
                    throw new RuntimeException("Step:- Verify available text   Failure:- Actual available text is: "+actualText+", which does not contains expected text: "+expectedText);
                }
            }           
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should contains: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Verify available text   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_textToBePresentInElementLocated);
                webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocator, expectedText));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element does not contains expected text
            }
            try {
                webElement = handleElements.extractElement(elementLocator);
                actualText = webElement.getText();
                gotText = true;
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should contains: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", unable to get text from first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify available text   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to get text from first found element, Exception occured: " + throwable.getMessage());
            }
            if(gotText) {
                if(actualText.trim().contains(expectedText.trim())) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should contains: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+"</mark> elements found with locator: "+elementLocator+", text in first found element is: "+actualText);
                    }
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should contains: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", text in first found element is: <mark>"+actualText+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }
                    throw new RuntimeException("Step:- Verify available text   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", actual available text in first found element is: "+actualText+", which does not contains expected text: "+expectedText);
                }
            }           
        }
    }
    
    /**
     * Get the text from an element and match it with expected regular expression.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object
     * @param expectedRegEx Regular expression of expected text in the element
     */
    public void verifyTextInElementWithRegEx(String elementName, By elementLocator, String expectedRegEx) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        String actualText = null;
        Pattern patternExpectedRegEx = Pattern.compile(expectedRegEx);
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {               
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_textMatches);
                webDriverWait.until(ExpectedConditions.textMatches(elementLocator, patternExpectedRegEx));
                webElement = handleElements.extractElement(elementLocator);
                actualText = webElement.getText();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Text is: "+actualText);
                }
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    webElement = handleElements.extractElement(elementLocator);
                    actualText = webElement.getText();
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Text is: <mark>"+actualText+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify available text   Failure:- Actual available text is: "+actualText+", which does not match expected regular expression: "+expectedRegEx+", Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Verify available text   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_textMatches);
                webDriverWait.until(ExpectedConditions.textMatches(elementLocator, patternExpectedRegEx));
                webElement = handleElements.extractElement(elementLocator);
                actualText = webElement.getText();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", text in first found element is: "+actualText);
                }
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    webElement = handleElements.extractElement(elementLocator);
                    actualText = webElement.getText();
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify available text &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", text in first found element is: <mark>"+actualText+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify available text   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", actual available text in first found element is: "+actualText+", which does not match with expected regular expression: "+expectedRegEx+", Exception occured: " + throwable.getMessage());
            }      
        }
    }
    
    /**
     * Verify text present on the page.
     * 
     * @param expectedText Expected text.
     */
    public void verifyTextPresentOnPage(String expectedText) {
        By element = By.xpath("//*[text()='"+expectedText+"']");
        int elementCount = handleElements.getElementCount(element);
        if (elementCount == 1) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify text present ("+expectedText+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be present on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Text is present on page");
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify text present ("+expectedText+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be present on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Text is not present on page</mark>");
            }
            throw new RuntimeException("Step:- Verify text present ("+expectedText+")   Failure:- Text is not present on page");
        }
        else if (elementCount > 1) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify text present ("+expectedText+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be present on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Text present on page "+elementCount+" times");
            }
        }
    }
    
    /**
     * Verify partial text present on the page.
     * 
     * @param expectedText Expected partial text.
     */
    public void verifyPartialTextPresentOnPage(String expectedText) {
        By element = By.xpath("//*[contains(text(),'"+expectedText+"')]");
        int elementCount = handleElements.getElementCount(element);
        if (elementCount == 1) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify partial text present ("+expectedText+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be present on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Text is present on page");
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify partial text present ("+expectedText+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be present on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Text is not present on page</mark>");
            }
            throw new RuntimeException("Step:- Verify partial text present ("+expectedText+")   Failure:- Text is not present on page");
        }
        else if (elementCount > 1) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify partial text present ("+expectedText+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Text should be present on page &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Text present on page "+elementCount+" times");
            }
        }
    }

}
