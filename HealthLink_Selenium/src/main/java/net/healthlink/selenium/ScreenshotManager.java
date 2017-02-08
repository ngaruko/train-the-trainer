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

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

/**
 * This class contains all methods to capture screenshot
 *
 * @author jaspal
 */
public class ScreenshotManager {
    
    private String fileName;    
    public ScreenshotManager() {
        // Below code will get the current date to put as a screenshot name
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String tempDate = dateFormat.format(date);
        String newFileName1 = tempDate.replace("/","_");
        String newFileName2 = newFileName1.replace(" ","-");
        fileName = newFileName2.replace(":",".");
    }
    
    public String getScreenshot() {
        try {
            // This code will capture screenshot of current window
            File scrFile = ((TakesScreenshot)HealthlinkSelenium.driver).getScreenshotAs(OutputType.FILE);
            // Set screenshot destination
            String screenshotDestination = "detailResultReportScreenshots\\Image"+fileName+".png";
            // This will store screenshot on Specific location
            FileUtils.copyFile(scrFile, new File(screenshotDestination),true);
            return screenshotDestination;
        }
        catch(Throwable throwable ) {
            System.out.println(throwable.getMessage());
            return throwable.getMessage();
        }
    }

    public String getFullScreenshot() {
        try {
            // This code will capture screenshot of current screen
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            // Set screenshot destination
            String screenshotDestination = "detailResultReportScreenshots\\Image"+fileName+".png";
            // This will store screenshot on Specific location
            ImageIO.write(image, "png", new File(screenshotDestination));
            return screenshotDestination;
        }
        catch(Throwable throwable ) {
            System.out.println(throwable.getMessage());
            return throwable.getMessage();
        }
    }


    boolean webElementHighlighted;
    public String getScreenshotWithHighlightElement(WebElement webElement) {
        JavascriptExecutor je = (JavascriptExecutor)HealthlinkSelenium.driver;
//        try {
//            je.executeScript("arguments[0].scrollIntoView(true);",webElement);
//        }
//        catch(Throwable throwable ) {
//            System.out.println(throwable.getMessage());
//        }
        try {
            je.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", webElement);
            webElementHighlighted = true;
        }
        catch(Throwable throwable ) {
            System.out.println(throwable.getMessage());
        }
        try {
            // This code will capture screenshot of current window
            File scrFile = ((TakesScreenshot)HealthlinkSelenium.driver).getScreenshotAs(OutputType.FILE);
            // Set screenshot destination
            String screenshotDestination = "detailResultReportScreenshots\\"+fileName+".png";
            // This will store screenshot on Specific location
            FileUtils.copyFile(scrFile, new File(screenshotDestination),true);
            if(webElementHighlighted) {
                try {
                    je.executeScript("arguments[0].setAttribute('style','border: 2px solid none')", webElement);
                }
                catch(Throwable throwable ) {
                    System.out.println(throwable.getMessage());
                }
            }
            return screenshotDestination;
        }
        catch(Throwable throwable ) {
            System.out.println(throwable.getMessage());
            return throwable.getMessage();
        }
    }

    public String getFullScreenshotWithHighlightElement(WebElement webElement) {
        JavascriptExecutor je = (JavascriptExecutor)HealthlinkSelenium.driver;
        try {
            je.executeScript("arguments[0].scrollIntoView(true);",webElement);
        }
        catch(Throwable throwable ) {
            System.out.println(throwable.getMessage());
        }
        try {
            je.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", webElement);
            webElementHighlighted = true;
        }
        catch(Throwable throwable ) {
            System.out.println(throwable.getMessage());
        }
        try {
            // This code will capture screenshot of current screen
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            // Set screenshot destination
            String screenshotDestination = "detailResultReportScreenshots\\"+fileName+".png";
            // This will store screenshot on Specific location
            ImageIO.write(image, "png", new File(screenshotDestination));
            if(webElementHighlighted) {
                try {
                    je.executeScript("arguments[0].setAttribute('style','border: 2px solid none')", webElement);
                }
                catch(Throwable throwable ) {
                    System.out.println(throwable.getMessage());
                }
            }
            return screenshotDestination;
        }
        catch(Throwable throwable ) {
            System.out.println(throwable.getMessage());
            return throwable.getMessage();
        }
    }

}
