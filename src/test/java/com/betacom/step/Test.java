package com.betacom.step;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.*;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, format = { "pretty", "html:target/cucumber", "json:target/cucumber.json"},monochrome = true, features = "src/test/resources")
public class Test {

}
