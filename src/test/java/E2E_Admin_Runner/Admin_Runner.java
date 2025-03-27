package E2E_Admin_Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/E2E_Admin_features",
        glue = "E2E_Admin_Steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"})

public class Admin_Runner extends AbstractTestNGCucumberTests {

}
