package com.betacom.step;

import com.betacom.page.AbstractPage;
import com.betacom.page.LoginPage;
import com.betacom.page.MainPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pl.Zakładając;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.cucumber.adapter.FluentCucumberTest;
import org.fluentlenium.cucumber.adapter.util.SharedDriver;
import org.openqa.selenium.By;


@SharedDriver(type = SharedDriver.SharedType.ONCE)
public class CommonStepDefs extends FluentCucumberTest {

    @Page
    LoginPage loginPage;

    @Page
    MainPage mainPage;

    @Page
    AbstractPage abstractPage;

    @After("@Quit")
    public void closeDriver()
    {
        abstractPage.getDriver().quit();
    }

//    @After("@Wyloguj")
//    public void logOut()
//    {
//        click(find(By.cssSelector("a[onclick='openNodes(event);']")));
//        click(find(By.cssSelector("a[onclick='logOff();return false;']")));
//    }

    @Before("@Anuluj")
    public void cancel() {
        abstractPage.clickOn("Anuluj");
    }

//    @Before("@UżytkownikWnioski")
//    public void loginAsUzytkownikWnioski()
//    {
//        loginPage.go();
//        loginPage.getDriver().manage().window().maximize();
//        loginPage.getDriver().switchTo().frame("SabaMain");
//        loginPage.login("uzytkownikwnioski", "welcome");
//        mainPage.isAt();
//    }

    @Before("@ManagerWnioski")
    public void loginAsManagerWnioski()
    {
        loginPage.go();
        loginPage.getDriver().manage().window().maximize();
        loginPage.getDriver().switchTo().frame("SabaMain");
        loginPage.login("managerwnioski", "welcome");
        mainPage.isAt();
    }

    @Zakładając("^nacisnę przycisk \"([^\"]*)\"$")
    public void nacisnę_przycisk(String button){
        abstractPage.clickOn(button);
    }

    @Before
    public void before(Scenario scenario) {
        super.before(scenario);
    }

    @After
    public void after(Scenario scenario) {
        super.after(scenario);
    }




}
