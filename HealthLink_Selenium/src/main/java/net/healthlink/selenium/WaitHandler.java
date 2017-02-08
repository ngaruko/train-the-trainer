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
 * This class contains method related to wait
 *
 * @author jaspal
 */
public class WaitHandler {
    
private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Wait (stop execution) as per provided time.
     * 
     * @param waitTimeInMilliseconds Time for wait in milliseconds.
     */
    public void wait(int waitTimeInMilliseconds) {
        try {
            Thread.sleep(waitTimeInMilliseconds);
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.INFO, "<b>Step - </b> Wait ("+waitTimeInMilliseconds+" Milliseconds) &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script should wait as per given time &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> Script stoped execution as per given time");
            }
        }
        catch (Throwable throwable ) {
            if(HealthlinkSelenium.extentReport != null) {
                HealthlinkSelenium.extentLogger.log(LogStatus.ERROR, "<b>Step - </b> Wait ("+waitTimeInMilliseconds+" Milliseconds) &nbsp;&nbsp;&nbsp;&nbsp; <b>Expected - </b> Script should wait as per given time &nbsp;&nbsp;&nbsp;&nbsp; <b>Actual - </b> <mark>Unable to implement wait</mark> " + HealthlinkSelenium.extentLogger.addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
            }
            throw new RuntimeException("Step:- Wait ("+waitTimeInMilliseconds+" Milliseconds)   Failure:- Unable to implement wait, Exception occured: " + throwable.getMessage());
        }
    }

}
