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

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to keyboard actions
 *
 * @author jaspal
 */
public class KeyboardActionHandler {
    
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Press key from keyboard.
     * 
     * @param key Key needs to be pass, For example: Keys.ENTER
     */
    public void pressKeyboardKey(Keys key) {
        try {
            Keyboard keyboard = ((HasInputDevices) HealthlinkSelenium.driver).getKeyboard();
            keyboard.pressKey(key);
            System.out.println(key.name());
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Press key from keyboard ("+key.name()+") &nbsp;&nbsp;&nbsp; <b>Expected - </b> Key should be pressed &nbsp;&nbsp;&nbsp; <b>Actual - </b> Key pressed successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Press key from keyboard ("+key.name()+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Key should be pressed &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to press key</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Press key from keyboard ("+key.name()+")   Failure:- Unable to press enter, Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Press two keys together from keyboard.
     * 
     * @param key Key needs to be pass, For example: Keys.CONTROL
     * @param character Char as a key needs to be pass, For example: 'c'
     */
    public void pressKeyboardKeys(Keys key, char character) {
        try {
            String charToString = Character.toString(character);
            Keyboard keyboard = ((HasInputDevices) HealthlinkSelenium.driver).getKeyboard();
            keyboard.sendKeys(key, charToString);
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Press two keys together from keyboard ("+key.name()+", "+character+") &nbsp;&nbsp;&nbsp; <b>Expected - </b> Keys should be pressed &nbsp;&nbsp;&nbsp; <b>Actual - </b> Keys pressed successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Press two keys together from keyboard ("+key.name()+", "+character+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Keys should be pressed &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to press keys</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Press two keys together from keyboard ("+key.name()+", "+character+")   Failure:- Unable to press keys, Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Press three keys together from keyboard.
     * 
     * @param key1 Key needs to be pass, For example: Keys.CONTROL
     * @param key2 Key needs to be pass, For example: Keys.SHIFT
     * @param character Char as a key needs to be pass, For example: 'p'
     */
    public void pressKeyboardKeys(Keys key1, Keys key2, char character) {
        try {
            String charToString = Character.toString(character);
            Keyboard keyboard = ((HasInputDevices) HealthlinkSelenium.driver).getKeyboard();
            keyboard.sendKeys(key1, key2, charToString);
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Press three keys together from keyboard ("+key1.name()+", "+key2.name()+", "+character+") &nbsp;&nbsp;&nbsp; <b>Expected - </b> Keys should be pressed &nbsp;&nbsp;&nbsp; <b>Actual - </b> Keys pressed successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Press three keys together from keyboard ("+key1.name()+", "+key2.name()+", "+character+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Keys should be pressed &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to press keys</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Press three keys together from keyboard ("+key1.name()+", "+key2.name()+", "+character+")   Failure:- Unable to press keys, Exception occured: " + throwable.getMessage());
        }
    }

}
