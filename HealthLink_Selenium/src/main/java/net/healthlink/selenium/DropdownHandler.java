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

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to dropdown
 *
 * @author jaspal
 */
public class DropdownHandler {
    
    private int webDriverWait_visibilityOfElementLocated = 5;

    private final ExtentTest extentLogger;
    
    public DropdownHandler(ExtentTest extentLogger) {
        this.extentLogger = extentLogger;
    }
    
    private HandleElements handleElements = new HandleElements();
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Select option from dropdown by visible text.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     * @param visibleText Visible text (option) in dropdown list.
     */
    public void selectOption(String elementName, By elementLocator, String visibleText) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;
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
                select = new Select(webElement);
                select.selectByVisibleText(visibleText);
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Select option ("+visibleText+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be selected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Option selected successfully");
                }
                
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Select option ("+visibleText+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be selected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to select option</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }               
                throw new RuntimeException("Step:- Select option ("+visibleText+") from ("+elementName+")   Failure:- Unable to select option, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Select option ("+visibleText+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be selected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }           
            throw new RuntimeException("Step:- Select option ("+visibleText+") from ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
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
                select = new Select(webElement);
                select.selectByVisibleText(visibleText);
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Select option ("+visibleText+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be selected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", option selected successfully in first found element");
                }               
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Select option ("+visibleText+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be selected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to select option in first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }                
                throw new RuntimeException("Step:- Select option ("+visibleText+") from ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to select option in first found element, Exception occured: " + throwable.getMessage());
            }
        }
    }
    
    /**
     * Select option from dropdown by index number.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     * @param index Index number of option in dropdown list.
     */
    public void selectOption(String elementName, By elementLocator, int index) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;
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
                select = new Select(webElement);
                select.selectByIndex(index);
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Select option by index number ("+index+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be selected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Option selected successfully");
                }                
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Select option by index number ("+index+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be selected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to select option</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }               
                throw new RuntimeException("Step:- Select option by index number ("+index+") from ("+elementName+")   Failure:- Unable to select option, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Select option by index number ("+index+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be selected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }           
            throw new RuntimeException("Step:- Select option by index number ("+index+") from ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
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
                select = new Select(webElement);
                select.selectByIndex(index);
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Select option by index number ("+index+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be selected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", option selected successfully in first found element");
                }               
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Select option by index number ("+index+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be selected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to select option in first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }            
                throw new RuntimeException("Step:- Select option by index number ("+index+") from ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to select option in first found element, Exception occured: " + throwable.getMessage());
            }
        }
    }
    
    /**
     * Deselect option from dropdown by visible text.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     * @param visibleText Visible text (option) in dropdown list.
     */
    public void deselectOption(String elementName, By elementLocator, String visibleText) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;
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
                select = new Select(webElement);
                select.deselectByVisibleText(visibleText);
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Deselect option ("+visibleText+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be deselected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Option deselected successfully");
                }              
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Deselect option ("+visibleText+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be deselected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to deselect option</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }               
                throw new RuntimeException("Step:- Deselect option ("+visibleText+") from ("+elementName+")   Failure:- Unable to deselect option, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Deselect option ("+visibleText+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be deselected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }       
            throw new RuntimeException("Step:- Deselect option ("+visibleText+") from ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
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
                select = new Select(webElement);
                select.deselectByVisibleText(visibleText);
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Deselect option ("+visibleText+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be deselected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", option deselected successfully in first found element");
                }
                
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Deselect option ("+visibleText+") from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be deselected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to deselect option in first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }        
                throw new RuntimeException("Step:- Deselect option ("+visibleText+") from ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to deselect option in first found element, Exception occured: " + throwable.getMessage());
            }
        }
    }
    
    /**
     * Deselect all options from dropdown.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void deselectAllOptions(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;
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
                select = new Select(webElement);
                select.deselectAll();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Deselect all options from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Options should be deselected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Options deselected successfully");
                }          
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Deselect all options from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Options should be deselected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to deselect options</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }       
                throw new RuntimeException("Step:- Deselect all options from ("+elementName+")   Failure:- Unable to deselect options, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Deselect all options from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Options should be deselected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }       
            throw new RuntimeException("Step:- Deselect all options from ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
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
                select = new Select(webElement);
                select.deselectAll();
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.PASS, "<b>Step - </b> Deselect all options from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Options should be deselected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", options deselected successfully in first found element");
                }    
            } catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Deselect all options from ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Options should be deselected in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to deselect options in first found element</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }     
                throw new RuntimeException("Step:- Deselect all options from ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to deselect options in first found element, Exception occured: " + throwable.getMessage());
            }
        }
    }
    
    /**
     * Verify selected option in dropdown equals.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     * @param expectedText Expected selected option (visible text) in dropdown list.
     */
    public void verifySelectedOptionEquals(String elementName, By elementLocator, String expectedText) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;
        WebElement selectedOptionPath;
        String actualSelectedOption;
        boolean gotSelectedOption;
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
                select = new Select(webElement);
                selectedOptionPath = select.getFirstSelectedOption();
                actualSelectedOption = selectedOptionPath.getText();
                gotSelectedOption = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should be: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get selected option from dropdown</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }   
                throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- Unable to get selected option from dropdown, Exception occured: " + throwable.getMessage());
            }
            if(gotSelectedOption) {
                if(actualSelectedOption.trim().equals(expectedText)) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should be: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Selected option in dropdown is: " + actualSelectedOption);
                    }
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should be: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Selected option in dropdown is: <mark>"+actualSelectedOption+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }
                    throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- Actual selected option is: "+actualSelectedOption+", which is not equal to expected option: "+expectedText);
                }
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should be: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
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
                select = new Select(webElement);
                selectedOptionPath = select.getFirstSelectedOption();
                actualSelectedOption = selectedOptionPath.getText();
                gotSelectedOption = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should be: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to get selected option from dropdown</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }        
                throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to get selected option from dropdown, Exception occured: " + throwable.getMessage());
            }
            if(gotSelectedOption) {
                if(actualSelectedOption.trim().equals(expectedText)) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should be: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", selected option in first found element is: "+actualSelectedOption);
                    }                   
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should be: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", selected option in first found element is: <mark>"+actualSelectedOption+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }               
                    throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", actual selected option in first found element is: "+actualSelectedOption+", which is not equal to expected option: "+expectedText);
                }
            }           
        }
    }
    
    /**
     * Verify selected option in dropdown contains.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     * @param expectedText Expected selected option (partial visible text) in dropdown list.
     */
    public void verifySelectedOptionContains(String elementName, By elementLocator, String expectedText) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;
        WebElement selectedOptionPath;
        String actualSelectedOption;
        boolean gotSelectedOption;
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
                select = new Select(webElement);
                selectedOptionPath = select.getFirstSelectedOption();
                actualSelectedOption = selectedOptionPath.getText();
                gotSelectedOption = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should contains: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get selected option from dropdown</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }          
                throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- Unable to get selected option from dropdown, Exception occured: " + throwable.getMessage());
            }
            if(gotSelectedOption) {
                if(actualSelectedOption.trim().contains(expectedText)) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should contains: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Selected option in dropdown is: " + actualSelectedOption);
                    }       
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should contains: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Selected option in dropdown is: <mark>"+actualSelectedOption+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }           
                    throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- Actual selected option is: "+actualSelectedOption+", which does not contains expected option: "+expectedText);
                }
            }           
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should contains: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }           
            throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
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
                select = new Select(webElement);
                selectedOptionPath = select.getFirstSelectedOption();
                actualSelectedOption = selectedOptionPath.getText();
                gotSelectedOption = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should contains: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to get selected option from dropdown</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }               
                throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to get selected option from dropdown, Exception occured: " + throwable.getMessage());
            }
            if(gotSelectedOption) {
                if(actualSelectedOption.trim().contains(expectedText)) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should contains: "+expectedText+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", selected option in first found element is: "+actualSelectedOption);
                    }       
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should contains: <mark>"+expectedText+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", selected option in first found element is: <mark>"+actualSelectedOption+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }               
                    throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", actual selected option in first found element is: "+actualSelectedOption+", which does not contains expected option: "+expectedText);
                }
            }           
        }
    }
    
    /**
     * Verify selected option in dropdown with regular expression.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     * @param expectedRegEx Regular expression of selected option (visible text) in dropdown list.
     */
    public void verifySelectedOptionWithRegEx(String elementName, By elementLocator, String expectedRegEx) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;
        WebElement selectedOptionPath;
        String actualSelectedOption;
        boolean gotSelectedOption;
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
                select = new Select(webElement);
                selectedOptionPath = select.getFirstSelectedOption();
                actualSelectedOption = selectedOptionPath.getText();
                gotSelectedOption = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get selected option from dropdown</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- Unable to get option from dropdown, Exception occured: " + throwable.getMessage());
            }
            if(gotSelectedOption) {
                if(actualSelectedOption.trim().matches(expectedRegEx)) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Selected option in dropdown is: " + actualSelectedOption);
                    }           
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Selected option in dropdown is: <mark>"+actualSelectedOption+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }           
                    throw new RuntimeException("Actual selected option is: "+actualSelectedOption+", which does not match with expected regular expression: "+expectedRegEx);
                }
            }           
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
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
                select = new Select(webElement);
                selectedOptionPath = select.getFirstSelectedOption();
                actualSelectedOption = selectedOptionPath.getText();
                gotSelectedOption = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark> "+elementCount+" elements found with locator: "+elementLocator+", unable to get selected option from first found dropdown</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }     
                throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to get selected option from dropdown, Exception occured: " + throwable.getMessage());
            }
            if(gotSelectedOption) {
                if(actualSelectedOption.trim().matches(expectedRegEx)) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should match with regular expression: "+expectedRegEx+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", selected option in first found element is: "+actualSelectedOption);
                    }
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify selected option in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Selected option should match with regular expression: <mark>"+expectedRegEx+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", selected option in first found element is: <mark>"+actualSelectedOption+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                    }       
                    throw new RuntimeException("Step:- Verify selected option in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", actual selected option in first found element is: "+actualSelectedOption+", which does not match with expected regular expression: "+expectedRegEx);
                }
            }
        }
    }
    
    /**
     * Verify all options in dropdown.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     * @param expectedNumberOfOptions Expected number of options in drondown list.
     * 
     * @param expectedOptions Expected options (visible text) in dropdown list. (Need to be pass as an array).
     * For example,
     * String[] expectedOptions = {"Month", "Jan", "Feb", "Mar"};
        healthlinkSelenium.dropdownHandler().verifyOptions("Month dropdown", By.id("month"), 4, expectedOptions);
     */
    public void verifyOptions(String elementName, By elementLocator, int expectedNumberOfOptions, String[] expectedOptions) {
        WebElement webElement = null;
        Select select;
        List<WebElement> dropdownOptions = null;
        boolean gotOptions;
        boolean verifiedOptionsCount = false;
        int actualNumberOfOptions;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                select = new Select(webElement);
                dropdownOptions = select.getOptions();
                gotOptions = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify options in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> All required options should be available in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to get options from dropdown</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify options in ("+elementName+")   Failure:- Unable to get options from dropdown, Exception occured: " + throwable.getMessage());
            }
            if (gotOptions) {
                actualNumberOfOptions = dropdownOptions.size();
                if (actualNumberOfOptions == expectedNumberOfOptions) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify number of options in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Number of options in dropdown should be: "+expectedNumberOfOptions+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Number of options are: "+actualNumberOfOptions);
                    }
                    verifiedOptionsCount = true;
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify number of options in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Number of options in dropdown should be: <mark>"+expectedNumberOfOptions+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Number of options are: <mark>"+actualNumberOfOptions+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                        throw new RuntimeException("Step:- Verify number of options in ("+elementName+")   Failure:- Actual number of options are: "+actualNumberOfOptions+", which are not equal to expected number of options: "+expectedNumberOfOptions);
                    }
                }
            }
            if (verifiedOptionsCount) {
                for(int i=0; i<expectedOptions.length; i++) {
                    if(expectedOptions[i].equals(dropdownOptions.get(i).getText())) {
                        if(HealthlinkSelenium.extentReport != null) {
                            extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify options in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be available in dropdown: "+expectedOptions[i]+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Option available in dropdown");
                        }
                    }
                    else {
                        if(HealthlinkSelenium.extentReport != null) {
                            extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify options in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be available in dropdown: <mark>"+expectedOptions[i]+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Available option is: <mark>" +dropdownOptions.get(i).getText()+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                        }
                        throw new RuntimeException("Step:- Verify options in ("+elementName+")   Failure:- Option: '"+dropdownOptions.get(i).getText()+"' is available in dropdown, instead of: '"+expectedOptions[i]+"'");
                    }
                }
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify options in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> All required options should be available in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Verify options in ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                select = new Select(webElement);
                dropdownOptions = select.getOptions();
                gotOptions = true;
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Verify options in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> All required options should be available in dropdown &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to get options from first found dropdown</mark> " + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Verify options in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", unable to get options from first found dropdown, Exception occured: " + throwable.getMessage());
            }
            if (gotOptions) {
                actualNumberOfOptions = dropdownOptions.size();
                if (actualNumberOfOptions == expectedNumberOfOptions) {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify number of options in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Number of options in dropdown should be: "+expectedNumberOfOptions+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", number of options in first found dropdown are: "+actualNumberOfOptions);
                    }
                    verifiedOptionsCount = true;
                }
                else {
                    if(HealthlinkSelenium.extentReport != null) {
                        extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify number of options in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Number of options in dropdown should be: <mark>"+expectedNumberOfOptions+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+"</mark> elements found with locator: "+elementLocator+", number of options in first found dropdown are: <mark>"+actualNumberOfOptions+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                        throw new RuntimeException("Step:- Verify number of options in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", actual number of options in first found dropdown are: "+actualNumberOfOptions+", which are not equal to expected number of options: "+expectedNumberOfOptions);
                    }
                }
            }
            if (verifiedOptionsCount) {
                for(int i=0; i<expectedOptions.length; i++) {
                    if(expectedOptions[i].equals(dropdownOptions.get(i).getText())) {
                        if(HealthlinkSelenium.extentReport != null) {
                            extentLogger.log(LogStatus.PASS, "<b>Step - </b> Verify options in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be available in dropdown: "+expectedOptions[i]+" &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", option is available in first found dropdown");
                        }
                    }
                    else {
                        if(HealthlinkSelenium.extentReport != null) {
                            extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Verify options in ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Option should be available in dropdown: <mark>"+expectedOptions[i]+"</mark> &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", available option in first found dropdown is: <mark>" +dropdownOptions.get(i).getText()+"</mark>" + extentLogger.addScreenCapture(screenshotManager.getScreenshotWithHighlightElement(webElement)));
                        }
                        throw new RuntimeException("Step:- Verify options in ("+elementName+")   Failure:- "+elementCount+" elements found with locator: "+elementLocator+", Option: '"+dropdownOptions.get(i).getText()+"' is available in first found dropdown, instead of: '"+expectedOptions[i]+"'");
                    }
                }
            }
        }       
    }

}
