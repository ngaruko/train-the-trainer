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

import net.healthlink.selenium.HealthlinkSelenium;

/**
 * This class stored all locators (elements) and methods of 'Healthlink Contact Us' page.
 *
 * @author jaspal
 */
public class HealthlinkForgotPasswordPage {
    
    private HealthlinkSelenium healthlinkSelenium = new HealthlinkSelenium();

    public void verifyPageTitle(String expectedTitle) {
        healthlinkSelenium.pageTitleHandler().verifyPageTitleEquals(expectedTitle);
    }

    public void verifyPageURL(String expectedURL) {
        healthlinkSelenium.urlHandler().verifyPageUrlEquals(expectedURL);
    }

}
