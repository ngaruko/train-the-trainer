$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HealthLogin.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Jaspal Aujla"
    }
  ],
  "line": 2,
  "name": "HealthLink login",
  "description": "I want to verify login functionality and other elements on this page",
  "id": "healthlink-login",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3249881399,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "I am on HealthLink Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "HealthlinkLoginSteps.i_am_on_HealthLink_Login_page()"
});
formatter.result({
  "duration": 21432694889,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "All required elements should be displayed at Login page",
  "description": "",
  "id": "healthlink-login;all-required-elements-should-be-displayed-at-login-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I should see all required elements",
  "keyword": "Then "
});
formatter.match({
  "location": "HealthlinkLoginSteps.i_should_see_all_required_elements()"
});
formatter.result({
  "duration": 9692620898,
  "error_message": "org.openqa.selenium.WebDriverException: Tried to run command without establishing a connection\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:49:13 -0700\u0027\nSystem info: host: \u0027qa-jaspal\u0027, ip: \u0027172.25.0.219\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_101\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{rotatable\u003dfalse, raisesAccessibilityExceptions\u003dfalse, marionette\u003dtrue, firefoxOptions\u003d{args\u003d[], prefs\u003d{}}, appBuildId\u003d20160502172042, version\u003d, platform\u003dXP, proxy\u003d{}, specificationLevel\u003d1, acceptSslCerts\u003dfalse, browserVersion\u003d46.0.1, platformVersion\u003d6.1, XULappId\u003d{ec8030f7-c20a-464f-9b0e-13a3a9e97384}, browserName\u003dFirefox, takesScreenshot\u003dtrue, takesElementScreenshot\u003dtrue, platformName\u003dWindows_NT, device\u003ddesktop}]\nSession ID: c156cae4-24a8-409b-9bc9-0d1863f752fe\n*** Element info: {Using\u003did, value\u003dportal.logo}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:127)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:93)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:42)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:163)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:82)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:601)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:393)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementsById(RemoteWebDriver.java:421)\r\n\tat org.openqa.selenium.By$ById.findElements(By.java:210)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:356)\r\n\tat net.healthlink.selenium.HandleElements.getElementCount(HandleElements.java:36)\r\n\tat net.healthlink.selenium.ElementHandler.verifyElementDisplayed(ElementHandler.java:101)\r\n\tat net.healthlink.registration.pages.HealthlinkLoginPage.verifyAllElementsDisplayed(HealthlinkLoginPage.java:53)\r\n\tat net.healthlink.registration.steps.HealthlinkLoginSteps.i_should_see_all_required_elements(HealthlinkLoginSteps.java:54)\r\n\tat ✽.Then I should see all required elements(HealthLogin.feature:9)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 355290710,
  "error_message": "java.lang.NullPointerException\r\n\tat com.relevantcodes.extentreports.ExtentTest.isPathRelative(ExtentTest.java:494)\r\n\tat com.relevantcodes.extentreports.ExtentTest.addScreenCapture(ExtentTest.java:279)\r\n\tat net.healthlink.selenium.BrowserHandler.quitBrowser(BrowserHandler.java:98)\r\n\tat net.healthlink.registration.steps.CommonSteps.endTest(CommonSteps.java:51)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:206)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:46)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\n",
  "status": "failed"
});
formatter.before({
  "duration": 2546942769,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "I am on HealthLink Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "HealthlinkLoginSteps.i_am_on_HealthLink_Login_page()"
});
