package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features/testcase5.feature",
glue = "Stepsdef",
tags = "@Regression or @HappyScenario",
plugin = {"pretty","html:target/Reports/loginReport.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
