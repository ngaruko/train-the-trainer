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

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * This class consolidates all handlers
 *
 * @author jaspal
 */
public class HealthlinkSelenium {
    
    public static ExtentReports extentReport;
    public static ExtentTest extentLogger;
    public static WebDriver driver;
    
    private final AlertHandler alertHandler = new AlertHandler();
    private final BrowserHandler browserHandler = new BrowserHandler();
    private final CheckboxHandler checkboxHandler = new CheckboxHandler();
    private final CookiesHandler cookiesHandler = new CookiesHandler();
    private final DropdownHandler dropdownHandler = new DropdownHandler(extentLogger);
    private final ElementHandler elementHandler = new ElementHandler(extentLogger);
    private final FrameHandler frameHandler = new FrameHandler();
    private final KeyboardActionHandler keyboardActionHandler = new KeyboardActionHandler();
    private final MouseActionHandler mouseActionHandler = new MouseActionHandler(extentLogger);    
    private final PageTitleHandler pageTitleHandler = new PageTitleHandler(extentLogger);
    private final ScrollHandler scrollHandler = new ScrollHandler();
    private final TextboxHandler textboxHandler = new TextboxHandler(extentLogger);
    private final TextHandler textHandler = new TextHandler(extentLogger);
    private final UrlHandler urlHandler = new UrlHandler();
    private final WaitHandler waitHandler = new WaitHandler();
    private final WindowHandler windowHandler = new WindowHandler();
    
    
    public AlertHandler alertHandler() {
        return alertHandler;
    }
    
    public BrowserHandler browserHandler() {
        return browserHandler;
    }
    
    public CheckboxHandler checkboxHandler() {
        return checkboxHandler;
    }
    
    public CookiesHandler cookiesHandler() {
        return cookiesHandler;
    }
    
    public DropdownHandler dropdownHandler() {
        return dropdownHandler;
    }
    
    public ElementHandler elementHandler() {
        return elementHandler;
    }
    
    public FrameHandler frameHandler() {
        return frameHandler;
    }
    
    public KeyboardActionHandler keyboardActionHandler() {
        return keyboardActionHandler;
    }
    
    public MouseActionHandler mouseActionHandler() {
        return mouseActionHandler;
    }
    
    public PageTitleHandler pageTitleHandler() {
        return pageTitleHandler;
    }
    
    public ScrollHandler scrollHandler() {
        return scrollHandler;
    }
    
    public TextboxHandler textboxHandler() {
        return textboxHandler;
    }
    
    public TextHandler textHandler() {
        return textHandler;
    }
    
    public UrlHandler urlHandler() {
        return urlHandler;
    }
    
    public WaitHandler waitHandler() {
        return waitHandler;
    }
    
    public WindowHandler windowHandler() {
        return windowHandler;
    }
    
    
    /**
     * Configure extent result report including logger, step description, expected result, actual result and failure screenshot.
     * 
     * @param scenarioName Name of the scenario (test case).
     */
    public void configureExtentResultReport(String scenarioName) {
        if(extentReport == null) {
            extentReport = new ExtentReports("detailResultReport.html");  
            URL url = getClass().getResource("extent-config.xml");
            extentReport.loadConfig(new File(url.getPath()));
        }
        if(extentReport != null) {
            extentLogger = extentReport.startTest(scenarioName);
        }
    }
    
    /**
     * End extent result report.
     * 
     * @param scenarioName Name of the scenario (test case).
     */
    public void endExtentResultReport() {
        if(extentReport != null) {
            extentReport.endTest(extentLogger);
            extentReport.flush();  
        }
    }
    
    /**
     * Get WebDriver object.
     */
    public WebDriver getDriver() {
        return driver;
    }

}
