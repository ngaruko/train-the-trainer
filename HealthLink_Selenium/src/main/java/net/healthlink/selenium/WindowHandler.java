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

import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to browser window
 *
 * @author jaspal
 */
public class WindowHandler {
    
    private int webDriverWait_numberOfWindowsToBe = 5;
    
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Switch the script focus to another window and also verify expected number of windows.
     * 
     * @param expectedNumberOfWindows Expected number of windows.
     */
    public void switchToWindow(int expectedNumberOfWindows) {
        int numberOfWindows;
        if(expectedNumberOfWindows > 1) {
            try {
                WebDriverWait wait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_numberOfWindowsToBe);
                wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
                String activeWindow = HealthlinkSelenium.driver.getWindowHandle();
                Set<String> allWindows = HealthlinkSelenium.driver.getWindowHandles();
                numberOfWindows = HealthlinkSelenium.driver.getWindowHandles().size();
                for(String windowHandles: allWindows) {
                    if(!windowHandles.equals(activeWindow)) {
                        HealthlinkSelenium.driver.switchTo().window(windowHandles);
                    }
                }
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Switch to another window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script focus should switched to another window &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Number of window(s) is/are: "+numberOfWindows+", script focus switched to another window");
                }
            }
            catch(Throwable throwable ) {
                numberOfWindows = HealthlinkSelenium.driver.getWindowHandles().size();
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Switch to another window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script focus should switched to another window &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Number of window(s) is/are: <mark>"+numberOfWindows+"</mark> which is/are not equal to: <mark>"+expectedNumberOfWindows+"</mark>" + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
                }           
                throw new RuntimeException("Step:- Switch to another window   Failure:- Number of window(s) is/are: "+numberOfWindows+" which is/are not equal to: "+expectedNumberOfWindows+", Exception occured: " + throwable.getMessage());
            }
        }
        else if(expectedNumberOfWindows <= 1) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.WARNING, "<b>Step - </b> Switch to another window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script focus should switched to another window &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Number of windows should be more than 1 to switch, please pass expectedNumberOfWindows more than 1</mark>" + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
            }           
            throw new RuntimeException("Step:- Switch to another window   Failure:- Number of windows should be more than 1 to switch, please pass expectedNumberOfWindows more than 1");
        }
    }
                
    /**
     * Switch the script focus to another window and close existing window and also verify expected number of windows.
     * 
     * @param expectedNumberOfWindows Expected number of windows.
     */
    public void switchToWindowAndCloseExistingOne(int expectedNumberOfWindows) {
        int numberOfWindows = 0;
        if(expectedNumberOfWindows > 1) {
            try {
                WebDriverWait wait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_numberOfWindowsToBe);
                wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
                String activeWindow = HealthlinkSelenium.driver.getWindowHandle();
                Set<String> allWindows = HealthlinkSelenium.driver.getWindowHandles();
                numberOfWindows = HealthlinkSelenium.driver.getWindowHandles().size();
                HealthlinkSelenium.driver.close();
                for(String windowHandles: allWindows) {
                    if(!windowHandles.equals(activeWindow)) {
                        HealthlinkSelenium.driver.switchTo().window(windowHandles);
                    }
                }
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Switch to another window and close existing window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script focus should switched to another window and close existing window &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Number of window(s) is/are: "+numberOfWindows+", script focus switched to another window and existing window has been closed");
                }
            }
            catch(Throwable throwable ) {
                if(numberOfWindows == 0) {
                    numberOfWindows = HealthlinkSelenium.driver.getWindowHandles().size();
                }
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Switch to another window and close existing window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script focus should switched to another window and close existing window &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Number of window(s) is/are: <mark>"+numberOfWindows+"</mark> which is/are not equal to: <mark>"+expectedNumberOfWindows+"</mark>" + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
                }
                throw new RuntimeException("Step:- Switch to another window and close existing window   Failure:- Number of window(s) is/are: "+numberOfWindows+" which is/are not equal to: "+expectedNumberOfWindows+", Exception occured: " + throwable.getMessage());
            }
        }
        else if(expectedNumberOfWindows <= 1) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.WARNING, "<b>Step - </b> Switch to another window and close existing window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script focus should switched to another window and close existing window &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Number of windows should be more than 1 to switch, please pass expectedNumberOfWindows more than 1</mark>" + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()));
            }
            throw new RuntimeException("Step:- Switch to another window and close existing window   Failure:- Number of windows should be more than 1 to switch, please pass expectedNumberOfWindows more than 1");
        }
    }
    
    /**
     * Switch the script focus to another window.
     */
    public void switchToWindow() {
        try {
            int numberOfWindows = HealthlinkSelenium.driver.getWindowHandles().size();
            if(numberOfWindows > 1) {
                String activeWindow = HealthlinkSelenium.driver.getWindowHandle();
                Set<String> allWindows = HealthlinkSelenium.driver.getWindowHandles();
                for(String windowHandles: allWindows) {
                    if(!windowHandles.equals(activeWindow)) {
                        HealthlinkSelenium.driver.switchTo().window(windowHandles);
                    }
                }
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Switch to another window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script focus should switched to another window &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Script focus switched to another window");
                }
            }
            else if(numberOfWindows == 1) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Switch to another window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script focus should switched to another window &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Another window not exist, window count is 1 and script focus is on same window");
                }
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Switch to another window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script focus should switched to another window &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to switch to another window</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }           
            throw new RuntimeException("Step:- Switch to another window   Failure:- Unable to switch to another window, Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Switch the script focus to another window and close existing window.
     */
    public void switchToWindowAndCloseExistingOne() {
        try {           
            int numberOfWindows = HealthlinkSelenium.driver.getWindowHandles().size();
            if(numberOfWindows > 1) {
                String activeWindow = HealthlinkSelenium.driver.getWindowHandle();
                Set<String> allWindows = HealthlinkSelenium.driver.getWindowHandles();
                HealthlinkSelenium.driver.close();
                for(String windowHandles: allWindows) {
                    if(!windowHandles.equals(activeWindow)) {                   
                        HealthlinkSelenium.driver.switchTo().window(windowHandles);
                    }
                }
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Switch to another window and close existing window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script focus should switched to another window and close existing window &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Script focus switched to another window and existing window has been closed");
                }
            }
            else if(numberOfWindows == 1) {
                if(HealthlinkSelenium.extentReport != null) {
                    HealthlinkSelenium.extentLogger.log(LogStatus.PASS, "<b>Step - </b> Switch to another window and close existing window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script focus should switched to another window and close existing window &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Another window not exist, window count is 1 and script focus is on same window");
                }
            }           
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Switch to another window and close existing window &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script focus should switched to another window and close existing window &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to switch to window</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }           
            throw new RuntimeException("Step:- Switch to another window and close existing window   Failure:- Unable to switch to window, Exception occured: " + throwable.getMessage());
        }
    }

}
