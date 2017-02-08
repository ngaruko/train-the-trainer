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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to frame
 *
 * @author jaspal
 */
public class FrameHandler {
    
private int webDriverWait_frameToBeAvailableAndSwitchToIt = 15;
    
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Switch to frame by using id or name.
     * 
     * @param frameIdOrName Name or id of the frame.
     */
    public void switchToFrame(String frameIdOrName) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_frameToBeAvailableAndSwitchToIt);
            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIdOrName));
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Switch to frame ("+frameIdOrName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Frame should come in focus &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Frame came in focus successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Switch to frame ("+frameIdOrName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Frame should come in focus &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to switch to frame</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Switch to frame ("+frameIdOrName+")   Failure:- Unable to switch to frame, Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Switch to frame using element locator.
     * 
     * @param frameLocator Location of the frame using a By object.
     */
    public void switchToFrame(By frameLocator) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_frameToBeAvailableAndSwitchToIt);
            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Switch to frame ("+frameLocator+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Frame should come in focus &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Frame came in focus successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Switch to frame ("+frameLocator+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Frame should come in focus &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to switch to frame</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Switch to frame ("+frameLocator+")   Failure:- Unable to switch to frame, Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Switch to frame using index number.
     * 
     * @param frameIndex Index of the frame.
     */
    public void switchToFrame(int frameIndex) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_frameToBeAvailableAndSwitchToIt);
            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Switch to frame ("+frameIndex+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Frame should come in focus &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Frame came in focus successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Switch to frame ("+frameIndex+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Frame should come in focus &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to switch to frame</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Switch to frame ("+frameIndex+")   Failure:- Unable to switch to frame, Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Switch to default frame.
     */
    public void switchToDefaultFrame() {
        try {
            HealthlinkSelenium.driver.switchTo().defaultContent();
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Switch to default frame &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Default frame should come in focus &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Default frame came in focus successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Switch to default frame &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Default frame should come in focus &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to switch to default frame</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Switch to default frame   Failure:- Unable to switch to default frame, Exception occured: " + throwable.getMessage());
        }
    }

}
