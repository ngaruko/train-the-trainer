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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains method related to scroll
 *
 * @author jaspal
 */
public class ScrollHandler {
    
    private HandleElements handleElements = new HandleElements();
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Scroll to element.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object
     */
    public void scrollToElement(String elementName, By elementLocator) {
        WebElement webElement;
        JavascriptExecutor javascriptExecutor;
        int elementCount = handleElements.getElementCount(elementLocator);
        if (elementCount == 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                javascriptExecutor = (JavascriptExecutor) HealthlinkSelenium.driver;
                javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Scroll to element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page should scrolled to element &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Page scrolled to element successfully");
                }           
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Scroll to element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page should scrolled to element &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to scroll to element</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshot()) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Scroll to element ("+elementName+")   Failure:- Unable to scroll to element, Exception occured: " + throwable.getMessage());
            }
        }
        else if (elementCount == 0) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Scroll to element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page should scrolled to element &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to find element with locator: "+elementLocator+"</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshot()));
            }
            throw new RuntimeException("Step:- Scroll to element ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }
        else if (elementCount > 1) {
            try {
                webElement = handleElements.extractElement(elementLocator);
                javascriptExecutor = (JavascriptExecutor) HealthlinkSelenium.driver;
                javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Scroll to element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page should scrolled to element &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> "+elementCount+" elements found with locator: "+elementLocator+", page scrolled successfully to first found element");
                }    
            }
            catch (Throwable throwable ) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Scroll to element ("+elementName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Page should scrolled to element &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>"+elementCount+" elements found with locator: "+elementLocator+", unable to scroll to first found element</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshot()) + throwable.getMessage());
                }   
                throw new RuntimeException("Step:- Scroll to element ("+elementName+")   Failure:- Unable to scroll to element, Exception occured: " + throwable.getMessage());
            }
        }
    }

}
