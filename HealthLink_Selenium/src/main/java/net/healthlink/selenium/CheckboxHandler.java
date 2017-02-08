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

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to checkbox
 *
 * @author jaspal
 */
public class CheckboxHandler {
    
    private int webDriverWait_visibilityOfElementLocated = 5;
    private int webDriverWait_elementToBeSelected = 5;
    private int webDriverWait_elementSelectionStateToBeFalse = 5;
    
    private HandleElements handleElements = new HandleElements();
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Check element (checkbox).
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void checkCheckbox(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        boolean selectedStatus;
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
                selectedStatus = webElement.isSelected();
                if(selectedStatus == true) {
                    if(HealthlinkSelenium.extentReport != null) {
                        HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Check checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Checkbox already checked");
                    }                   
                }
                else if(selectedStatus == false) {  
                    webElement.click();
                    if(HealthlinkSelenium.extentReport != null) {
                        HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Check checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Checkbox checked successfully");
                    }                   
                }            
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Check checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to check checkbox</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }               
                throw new RuntimeException("Step:- Check checkbox ("+elementName+")   Failure:- Unable to check checkbox, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Check checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }           
            throw new RuntimeException("Step:- Check checkbox ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
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
                selectedStatus = webElement.isSelected();
                if(selectedStatus == true) {
                    if(HealthlinkSelenium.extentReport != null) {
                        HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Check checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found checkbox is already checked");
                    }                   
                }
                else if(selectedStatus == false) {  
                    webElement.click();
                    if(HealthlinkSelenium.extentReport != null) {
                        HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Check checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Checkbox checked successfully");
                    }                   
                }            
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Check checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to check first found checkbox</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }           
                throw new RuntimeException("Step:- Check checkbox ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to check first found checkbox, Exception occured: " + throwable.getMessage());
            }
        }
    }
    
    /**
     * Uncheck element (checkbox).
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void uncheckCheckbox(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        boolean selectedStatus;
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
                selectedStatus = webElement.isSelected();
                if(selectedStatus == false) {
                    if(HealthlinkSelenium.extentReport != null) {
                        HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Uncheck checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be unchecked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Checkbox already unchecked");
                    }                   
                }
                else if(selectedStatus == true) {   
                    webElement.click();
                    if(HealthlinkSelenium.extentReport != null) {
                        HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Uncheck checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be unchecked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Checkbox unchecked successfully");
                    }                   
                }            
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Uncheck checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be unchecked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to uncheck checkbox</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }               
                throw new RuntimeException("Step:- Uncheck checkbox ("+elementName+")   Failure:- Unable to check checkbox, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Uncheck checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be unchecked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }           
            throw new RuntimeException("Step:- Uncheck checkbox ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
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
                selectedStatus = webElement.isSelected();
                if(selectedStatus == false) {
                    if(HealthlinkSelenium.extentReport != null) {
                        HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Uncheck checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be unchecked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found checkbox is already unchecked");
                    }                   
                }
                else if(selectedStatus == true) {   
                    webElement.click();
                    if(HealthlinkSelenium.extentReport != null) {
                        HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Uncheck checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be unchecked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Checkbox unchecked successfully");
                    }
                }            
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Uncheck checkbox ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be unchecked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to uncheck first found checkbox</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }               
                throw new RuntimeException("Step:- Uncheck checkbox ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to uncheck first found checkbox, Exception occured: " + throwable.getMessage());
            }
        }
    }
    
    /**
     * Verify element (checkbox) is checked.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void verifyCheckboxChecked(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementToBeSelected);
                webDriverWait.until(ExpectedConditions.elementToBeSelected(webElement));
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify checkbox checked ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Checkbox is checked");
                } 
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify checkbox checked ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Checkbox is not checked" + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify checkbox checked ("+elementName+")   Failure:- Checkbox is not checked, Exception occured: " + throwable.getMessage());
            }   
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify checkbox checked ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }           
            throw new RuntimeException("Step:- Verify checkbox checked ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }       
        else if (elementCount > 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementToBeSelected);
                webDriverWait.until(ExpectedConditions.elementToBeSelected(webElement));
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify checkbox checked ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found checkbox is checked");
                } 
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify checkbox checked ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found checkbox is not checked" + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify checkbox checked ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", first found checkbox is not checked, Exception occured: " + throwable.getMessage());
            }
        }
    }
    
    /**
     * Verify element (checkbox) is not checked.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void verifyCheckboxNotChecked(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementSelectionStateToBeFalse);
                webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(webElement, false));
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify checkbox not checked ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should not be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Checkbox is not checked");
                } 
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify checkbox not checked ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should not be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Checkbox is checked" + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify checkbox not checked ("+elementName+")   Failure:- Checkbox is checked, Exception occured: " + throwable.getMessage());
            }   
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify checkbox not checked ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should not be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }           
            throw new RuntimeException("Step:- Verify checkbox not checked ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }       
        else if (elementCount > 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementSelectionStateToBeFalse);
                webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(webElement, false));
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify checkbox not checked ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should not be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found checkbox is not checked");
                } 
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify checkbox not checked ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Checkbox should not be checked &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", first found checkbox is checked" + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify checkbox not checked ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", first found checkbox is checked, Exception occured: " + throwable.getMessage());
            }
        }
    }

}
