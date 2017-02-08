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

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to cookies
 *
 * @author jaspal
 */
public class CookiesHandler {
    
private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Delete all cookies.
     */
    public void deleteAllCookies() {
        try {
            HealthlinkSelenium.driver.manage().deleteAllCookies();
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Delete all cookies &nbsp;&nbsp;&nbsp; <b>Expected - </b> All cookies should be deleted &nbsp;&nbsp;&nbsp; <b>Actual - </b> All cookies deleted successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Delete all cookies &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> All cookies should be deleted &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to delete cookies</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Delete all cookies   Failure:- Unable to delete cookies, Exception occured: " + throwable.getMessage());
        }
    }
    
    /**
     * Delete cookie by name.
     * 
     * @param cookieName Name of the cookie.
     */
    public void deleteCookie(String cookieName) {
        try {
            HealthlinkSelenium.driver.manage().deleteCookieNamed(cookieName);
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Delete cookie ("+cookieName+") &nbsp;&nbsp;&nbsp; <b>Expected - </b> Cookie should be deleted &nbsp;&nbsp;&nbsp; <b>Actual - </b> Cookie deleted successfully");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.FAIL, "<b>Step - </b> Delete cookie ("+cookieName+") &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Cookie should be deleted &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to delete cookie</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Delete cookie   Failure:- Unable to delete cookie named: "+cookieName+", Exception occured: " + throwable.getMessage());
        }
    }

}
