package org.fluentlenium.cucumber.adapter;


import cucumber.api.Scenario;
import org.fluentlenium.adapter.FluentTestRunnerAdapter;
import org.fluentlenium.adapter.util.DefaultCookieStrategyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FluentCucumberTest extends FluentTestRunnerAdapter {

    static String seleniumHost = "docker1.betacom.com.pl";
    static String seleniumPort = "4444";

    public FluentCucumberTest() {
        super(new CucumberSharedDriverStrategyReader(), new DefaultCookieStrategyReader());
    }

    // It's not allowed by Cucumber JVM to add @Before in the base class.
    public void before(Scenario scenario) {
        starting(scenario.getName());
    }

    // It's not allowed by Cucumber JVM to add @After in the base class.
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            failed(scenario.getName());
        }

        finished(scenario.getName());
    }

    @Override
    public WebDriver getDefaultDriver()
    {
        try{
            URL url = new URL("http://"+seleniumHost+":"+seleniumPort+"/wd/hub");
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            return new RemoteWebDriver(url, cap);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    // FluentTestRunnerAdapter#releaseSharedDriver is not called. I don't know when to call it, sadly ...
}
