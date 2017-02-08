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

/**
 * This class contains methods to extract element and get element count.
 *
 * @author jaspal
 */
public class HandleElements {
    
    private int webDriverWait_presenceOfElementLocated = 15;
    
    public int getElementCount(By elementLocator) {
        try {
            WebDriverWait wait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_presenceOfElementLocated);
            wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        }
        catch (Throwable throwable) {
            // After wait, go forward if element is not present
        }
        int elementCount = HealthlinkSelenium.driver.findElements(elementLocator).size();
        return elementCount;
    }
    
    public WebElement extractElement(By elementLocator) {
        WebElement webElement = HealthlinkSelenium.driver.findElement(elementLocator);
        return webElement;
    }

}
