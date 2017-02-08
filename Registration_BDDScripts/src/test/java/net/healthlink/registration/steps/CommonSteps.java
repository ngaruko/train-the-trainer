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
package net.healthlink.registration.steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.healthlink.selenium.HealthlinkSelenium;

/**
 * This class contains common steps. 
 *
 * @author jaspal
 */
public class CommonSteps {
    
    Properties properties;
    FileInputStream fileInputStream;
    public CommonSteps() throws IOException {
        properties = new Properties();
        fileInputStream = new FileInputStream("src\\test\\resources\\propertyFiles\\BrowserAndUrls.properties");
        properties.load(fileInputStream);
    }
    
    private HealthlinkSelenium healthlinkSelenium = new HealthlinkSelenium();   
    
    @Before()
    public void startTest(Scenario scenario) throws IOException {
        healthlinkSelenium.configureExtentResultReport(scenario.getName());
        healthlinkSelenium.browserHandler().launchBrowser(properties.getProperty("browserName"));
        healthlinkSelenium.browserHandler().maximizeBrowser();
        properties.clear();
        fileInputStream.close();
    }
    
    @After()
    public void endTest(Scenario scenario) {
        healthlinkSelenium.browserHandler().quitBrowser();
        healthlinkSelenium.endExtentResultReport();
    }

}
