package com.betacom.step;

import com.betacom.page.LoginPage;
import com.betacom.page.MainPage;
import com.betacom.page.NewTrainingRequestFormPage;
import com.betacom.page.NewTrainingRequestPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.cucumber.adapter.FluentCucumberTest;
import org.fluentlenium.cucumber.adapter.util.SharedDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


@SharedDriver(type = SharedDriver.SharedType.ONCE)
public class NewTrainingRequestStepDefs extends FluentCucumberTest {

    @Page
    NewTrainingRequestPage newTrainingRequestPage;

    @Page
    NewTrainingRequestFormPage newTrainingRequestFormPage;

    @Page
    LoginPage loginPage;

    @Page
    MainPage mainPage;

    @Zakładając("^wylogowuje się$")
    public void iLogedOut() {
        click(find(By.cssSelector("a[onclick='openNodes(event);']")));
        click(find(By.cssSelector("a[onclick='logOff();return false;']")));
    }

    @Zakładając("^że jestem zalogowany jako \"([^\"]*)\"$")
    public void iLoged(String login) {
        loginPage.go();
        loginPage.getDriver().manage().window().maximize();
        loginPage.getDriver().switchTo().frame("SabaMain");
        loginPage.login(login, "welcome");
        mainPage.isAt();
    }

    @Zakładając("^uzupełnię formularz wyszukiwania szablonu wniosku szkoleniowego$")
    public void uzupełnię_formularz_wyszukiwania_szablonu_wniosku_szkoleniowego() throws IOException {
         newTrainingRequestPage.populateTemplateFieldName();
    }

    @Wtedy("^wyszukam interesujący mnie szablon$")
    public void wyszukam_interesujący_mnie_szablon() throws IOException{
        newTrainingRequestPage.isSearchResultDisplays();
    }

    @Zakładając("^że jestem na stronie wyszukiwania szablonu wniosku szkoleniowego$")
    public void że_jestem_na_stronie_wyszukiwania_szablonu_wniosku_szkoleniowego(){
        goTo(newTrainingRequestPage);
        newTrainingRequestPage.isAt();
    }

    @Zakładając("^że wyszukałem interesujący mnie szablon$")
    public void że_wyszukałem_interesujący_mnie_szablon() throws IOException{
        newTrainingRequestPage.isAt();
        newTrainingRequestPage.isSearchResultDisplays();
    }

    @Wtedy("^wyświetli mi się formularz nowego wniosku szkoleniowego$")
    public void wyświetli_mi_się_formularz_nowego_wniosku_szkoleniowego(){
        newTrainingRequestFormPage.isAt();
    }

    @Zakładając("^że jestem na stronie z formularzem nowego wniosku szkoleniowego$")
    public void że_jestem_na_stronie_z_formularzem_nowego_wniosku_szkoleniowego() {
        newTrainingRequestFormPage.isAt();
    }

    @Zakładając("^uzupełnię formularz tworzenia nowego wniosku szkoleniowego$")
    public void uzupełnię_formularz_tworzenia_nowego_wniosku_szkoleniowego() throws IOException{
        newTrainingRequestFormPage.populateForm();
    }

    @Wtedy("^powinienem zobaczyć potwierdzenie stworzenia nowego wniosku szkoleniowego$")
    public void powinienem_zobaczyć_potwierdzenie_stworzenia_nowego_wniosku_szkoleniowego() throws IOException{
        newTrainingRequestFormPage.isRequestTrainCreated();
        newTrainingRequestFormPage.getTrainingRequestID();
    }

    @Zakładając("^że jestem na stronie z utworzonym wnioskiem szkoleniowym$")
    public void że_jestem_na_stronie_z_utworzonym_wnioskiem_szkoleniowym() {
        newTrainingRequestFormPage.isRequestTrainCreated();
    }


    @Wtedy("^powinienem zobaczyć potwierdzenie wysłania wniosku szkoleniowego do ackeptacji$")
    public void powinienem_zobaczyć_potwierdzenie_wysłania_wniosku_szkoleniowego_do_ackeptacji() {
        newTrainingRequestPage.isTrainingRequestSend();
    }

    @Before
    public void before(Scenario scenario) {
        super.before(scenario);
    }

    @After
    public void after(Scenario scenario) {
        super.after(scenario);}

}
