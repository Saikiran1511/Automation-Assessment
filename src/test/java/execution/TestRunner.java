package execution;

import base.TestBase;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

@CucumberOptions
            (
                    features = {"src/test/resources/features/"},
                    glue = {"stepdefinitions"},
                    tags = "@UIAssessment",
                    dryRun = false,
                    monochrome = true,
                    plugin = {"pretty","html:Output/cucumber-reports/Report.html"}
            )


public class TestRunner extends AbstractTestNGCucumberTests {

        TestBase testBase = new TestBase();

    @BeforeSuite
        public void configRead() throws IOException {
            testBase.readExecutionProperties();
        }

    @AfterSuite
        public void close() {
            testBase.quitBrowser();
        }

}
