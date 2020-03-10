package fr.zenity.desbugs.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        monochrome = false,
        glue = {"fr.zenity.desbugs.steps"},
        plugin = {
                "pretty",
                "html:target/reports/html/htmlreport",
        }
)
public class TestRunner extends BaseRunner {

}
