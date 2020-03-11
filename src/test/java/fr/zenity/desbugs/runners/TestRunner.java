package fr.zenity.desbugs.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"fr.zenity.desbugs.steps","fr/zenity/desbugs/PagesObjects"},
        tags = "",
        plugin = {
                "pretty",
                "html:target/reports/html/htmlreport",
                "json:target/reports/jsonreports/index.json",
                "junit:target/reports/xmlreport.xml",
        }
)
public class TestRunner extends BaseRunner {

}
