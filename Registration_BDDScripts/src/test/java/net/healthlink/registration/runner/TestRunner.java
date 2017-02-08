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
package net.healthlink.registration.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * This is a runner class to run the test scripts
 *
 * @author jaspal
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue={"net.healthlink.registration.steps"},
        plugin={"html:target/cucumber-html-report"}
        // tags={"@checkCode"}
        )

public class TestRunner {

}
