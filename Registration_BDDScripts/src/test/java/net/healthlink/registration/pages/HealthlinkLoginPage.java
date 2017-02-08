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
package net.healthlink.registration.pages;

import org.openqa.selenium.By;

import net.healthlink.selenium.HealthlinkSelenium;

/**
 * This class stored all locators (elements) and methods of 'Healthlink Login' page.
 *
 * @author jaspal
 */
public class HealthlinkLoginPage {
    
 // Elements and relevant locators
    private By HealthLink_logo = By.id("portal.logo");
    private By HealthlinkEmail_linktext = By.id("portal.contactus");
    private By ContactUs_linktext = By.id("portal.contactus"); 
    private By LogintoMyHealthLink_text = By.xpath("//label[text()='Log in to MyHealthLink']"); 
    private By EnterUsername_textbox = By.id("username");
    private By EnterPassword_textbox = By.id("password");   
    private By RememberMe_checkbox = By.id("rememberme");
    private By RememberMe_text = By.xpath("//h3[text()='Remember me']");    
    private By Login_button = By.id("btnSubmit");
    private By CreateAccount_linktext = By.id("rego.createAccount");    
    private By ForgottenPasswordUsername_linktext = By.id("portal.forgotPassword");    
    private By LoginError_text = By.id("userErrorLogin");
    private By LoginCaptchaError_text = By.id("captcha-error");
    private By LoginCaptcha_Imame = By.xpath("//img[@alt='captcha']");
    private By Copyright_text = By.id("portal.copyrightLabel");
    
    private HealthlinkSelenium healthlinkSelenium = new HealthlinkSelenium();

    public void verifyPageTitle(String expectedTitle) {
        healthlinkSelenium.pageTitleHandler().verifyPageTitleEquals(expectedTitle);
    }

    public void verifyPageURL(String expectedURL) {
        healthlinkSelenium.urlHandler().verifyPageUrlEquals(expectedURL);
    }

    public void verifyAllElementsDisplayed() {
        healthlinkSelenium.elementHandler().verifyElementDisplayed("HealthLink logo", HealthLink_logo);
        healthlinkSelenium.elementHandler().verifyElementDisplayed("Healthlink Email linktext", HealthlinkEmail_linktext);
        healthlinkSelenium.elementHandler().verifyElementDisplayed("Contact Us linktext", ContactUs_linktext);
        healthlinkSelenium.elementHandler().verifyElementDisplayed("Log in to MyHealthLink text", LogintoMyHealthLink_text);
        healthlinkSelenium.elementHandler().verifyElementDisplayed("Enter Username textbox", EnterUsername_textbox);
        healthlinkSelenium.elementHandler().verifyElementDisplayed("Enter Password textbox", EnterPassword_textbox);
        healthlinkSelenium.elementHandler().verifyElementDisplayed("Remember me checkbox", RememberMe_checkbox);
        healthlinkSelenium.elementHandler().verifyElementDisplayed("Remember me text", RememberMe_text);
        healthlinkSelenium.elementHandler().verifyElementDisplayed("Login button", Login_button);
        healthlinkSelenium.elementHandler().verifyElementDisplayed("Create account linktext", CreateAccount_linktext);       
        healthlinkSelenium.elementHandler().verifyElementDisplayed("Forgotten password/username? linktext", ForgottenPasswordUsername_linktext);
        healthlinkSelenium.elementHandler().verifyElementDisplayed("Copyright text", Copyright_text);
    //    healthlinkSelenium.getAndVerifyText("Copyright text", Copyright_text, "Copyright "+Calendar.getInstance().get(Calendar.YEAR)+" HealthLink");       
    }

    public void loginToHealthlink(String username, String password) {
        healthlinkSelenium.textboxHandler().fillValue("Enter Username textbox", EnterUsername_textbox, username);
        healthlinkSelenium.textboxHandler().fillValue("Enter Password textbox", EnterPassword_textbox, password);
        healthlinkSelenium.mouseActionHandler().click("Login button", Login_button);
    }
    
    public void checkRememberMeCheckbox() {
        healthlinkSelenium.checkboxHandler().checkCheckbox("Remember me checkbox", RememberMe_checkbox);
    }
    
    public void verifyValueInEnterUsernameTextbox(String expectedValue) {
        healthlinkSelenium.textboxHandler().verifyValueEquals("Enter Username textbox", EnterUsername_textbox, expectedValue);
    }

    public void loginFailErrorMessage(String errorMessage, String errorMessage2) {
        try {
            healthlinkSelenium.elementHandler().verifyElementDisplayed("Login Error", LoginError_text);
        }
        catch (Throwable t) {
            healthlinkSelenium.elementHandler().verifyElementDisplayed("Login CaptchaError", By.xpath("//label[text()='"+errorMessage2+"']"));
            healthlinkSelenium.elementHandler().verifyElementDisplayed("Login Captcha Image", LoginCaptcha_Imame);
        }       
    //    healthlinkSelenium.verifyElementDisplayed("Login error",By.xpath("//li[text()='"+errorMessage+"' or text()='"+errorMessage2+"']"));
    }
    
    public void clickAndSwitchToContactUs() {
        healthlinkSelenium.mouseActionHandler().click("Contact Us linktext", ContactUs_linktext);
        healthlinkSelenium.windowHandler().switchToWindow(2);
    }
    
    public void clickCreateAccount() {
        healthlinkSelenium.mouseActionHandler().click("CreateAccount linkText", CreateAccount_linktext);
    }
    
    public void clickForgottenPasswordUsername() {
        healthlinkSelenium.mouseActionHandler().click("Forgotten password/username? linktext", ForgottenPasswordUsername_linktext);
    }

}
