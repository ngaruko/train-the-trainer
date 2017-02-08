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
import java.util.Properties;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.healthlink.selenium.HealthlinkSelenium;
import net.healthlink.registration.pages.HealthlinkContactUsPage;
import net.healthlink.registration.pages.HealthlinkForgotPasswordPage;
import net.healthlink.registration.pages.HealthlinkLoginPage;
import net.healthlink.registration.pages.HealthlinkRegistrationPage;
import net.healthlink.registration.pages.HealthlinkUserDashboardPage;

/**
 * The class contains login steps
 *
 * @author jaspal
 */
public class HealthlinkLoginSteps {
    
private HealthlinkSelenium healthlinkSelenium = new HealthlinkSelenium();
    
    private HealthlinkLoginPage loginPage = new HealthlinkLoginPage();
    private HealthlinkUserDashboardPage userDashboardPage = new HealthlinkUserDashboardPage();
    private HealthlinkContactUsPage contactUsPage = new HealthlinkContactUsPage();
    private HealthlinkRegistrationPage registrationPage = new HealthlinkRegistrationPage();
    private HealthlinkForgotPasswordPage forgotPasswordPage = new HealthlinkForgotPasswordPage();
    
    @Given("^I am on HealthLink Login page$")
    public void i_am_on_HealthLink_Login_page() throws Throwable {
        Properties properties = new Properties();
        FileInputStream fileInputStream=new FileInputStream("src\\test\\resources\\propertyFiles\\BrowserAndUrls.properties");
        properties.load(fileInputStream);
        healthlinkSelenium.urlHandler().launchApp(properties.getProperty("healthlinkLoginURL"));
        properties.clear();
        fileInputStream.close();
    }
    
    @Then("^I should see all required elements$")
    public void i_should_see_all_required_elements() throws Throwable {
        loginPage.verifyAllElementsDisplayed();
    }
    
    @When("^I login with valid Username: \"([^\"]*)\" and Password: \"([^\"]*)\"$")
    public void i_login_with_valid_Username_and_Password(String username, String password) throws Throwable {
        loginPage.loginToHealthlink(username,password);
    }

    @Then("^I should see user dashboarh page$")
    public void i_should_see_user_dashboarh_page() throws Throwable {
        userDashboardPage.verifyLogoutLinktextAvailable();
    }
    
    @When("^I click on Remember me checkbox$")
    public void i_click_on_Remember_me_checkbox() throws Throwable {
        loginPage.checkRememberMeCheckbox();
    }

    @When("^I logged out$")
    public void i_logged_out() throws Throwable {
        userDashboardPage.clickLogoutLinktext();
    }

    @Then("^At login page I should see username: \"([^\"]*)\" in enter username textbox$")
    public void at_login_page_i_should_see_username_in_enter_username_textbox(String expectedValue) throws Throwable {
        loginPage.verifyValueInEnterUsernameTextbox(expectedValue);
    }
    
    @When("^I login with invalid Username: \"([^\"]*)\" and Password: \"([^\"]*)\"$")
    public void i_login_with_invalid_Username_and_Password(String username, String password) throws Throwable {
        loginPage.loginToHealthlink(username,password);
    }
    
    @Then("^I should see error message \"([^\"]*)\" or \"([^\"]*)\" and captcha image$")
    public void i_should_see_error_message_or_and_captcha_image(String errorMessage, String errorMessage2) throws Throwable {
        loginPage.loginFailErrorMessage(errorMessage,errorMessage2);
    }
    
    @When("^I click on Contact Us linktext$")
    public void i_click_on_Contact_Us_linktext() throws Throwable {
        loginPage.clickAndSwitchToContactUs();
    }

    @Then("^I should see Contect US page in a new browser window$")
    public void i_should_see_Contect_US_page_in_a_new_browser_window() throws Throwable {
        contactUsPage.verifyPageTitle("Contact Us » HealthLink");
    }
    
    @When("^I click on Create account linktext$")
    public void i_click_on_Create_account_linktext() throws Throwable {
        loginPage.clickCreateAccount();
    }

    @Then("^I should see Registration page$")
    public void i_should_see_Registration_page() throws Throwable {
        registrationPage.verifyPageTitle("Home");
    }
    
    @When("^I click on Forgotten password/username linktext$")
    public void i_click_on_Forgotten_password_username_linktext() throws Throwable {
        loginPage.clickForgottenPasswordUsername();
    }

    @Then("^I should see forgot password page$")
    public void i_should_see_forgot_password_page() throws Throwable {
        forgotPasswordPage.verifyPageTitle("Forgot Password");
    }

}
