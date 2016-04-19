package com.betacom.step;

import com.betacom.page.EmployeeTrainingRequestDetailsPage;
import com.betacom.page.ManagerTrainingRequestAcceptancePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pl.Kiedy;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.cucumber.adapter.FluentCucumberTest;
import org.fluentlenium.cucumber.adapter.util.SharedDriver;

import java.io.IOException;

@SharedDriver(type = SharedDriver.SharedType.PER_SCENARIO)
public class ManagerAcceptanceTrainingRequestStepDefs extends FluentCucumberTest {

    @Page
    ManagerTrainingRequestAcceptancePage managerTrainingRequestAcceptancePage;

    @Page
    EmployeeTrainingRequestDetailsPage employeeTrainingRequestDetailsPage;

    String id = "";

    @Zakładając("^że posiadam przynajmniej jeden wniosek do akceptacji$")
    public void że_posiadam_przynajmniej_jeden_wniosek_do_akceptacji() throws IOException{
        id = managerTrainingRequestAcceptancePage.getTrainingRequestId("manager_requests_ids");
    }

    @Zakładając("^znajduje się na stronie akceptacji wniosków przez przełożonego$")
    public void znajduje_się_na_stronie_akceptacji_wniosków_przez_przełożonego()  {
        managerTrainingRequestAcceptancePage.go();
        managerTrainingRequestAcceptancePage.isAt();
    }

    @Kiedy("^uzupełnie formularz wyszukiwania wniosku do akceptacji jako przełożony$")
    public void uzupełnie_formularz_wyszukiwania_wniosku_do_akceptacji_jako_przełożony()  {
        managerTrainingRequestAcceptancePage.populateTrainingRequestIdInput(id);
    }

    @Wtedy("^powinienem wyszukać formularz podwładnego do akceptacji$")
    public void powinienem_wyszukać_formularz_podwładnego_do_akceptacji()  {
        managerTrainingRequestAcceptancePage.isEmployeeTrainingRequestDisplay(id);
    }

    @Zakładając("^że wyszukałem interesujący mnie szablon do akceptacji$")
    public void że_wyszukałem_interesujący_mnie_szablon_do_akceptacji() throws IOException  {
        id = managerTrainingRequestAcceptancePage.getTrainingRequestId("manager_requests_ids");
        managerTrainingRequestAcceptancePage.isEmployeeTrainingRequestDisplay(id);
    }

    @Wtedy("^powinienem zobaczyć szczegóły wniosku szkoleniowego swojego podwładnego do akceptacji$")
    public void powinienem_zobaczyć_szczegóły_wniosku_szkoleniowego_swojego_podwładnego_do_akceptacji() {
        employeeTrainingRequestDetailsPage.isAt(id);
    }

    @Wtedy("^powinienem zobaczyć potwierdzenie wysłania wniosku szkoleniowego podwładnego do dalszej akceptacji$")
    public void powinienem_zobaczyć_potwierdzenie_wysłania_wniosku_szkoleniowego_podwładnego_do_dalszej_akceptacji() throws IOException {
        managerTrainingRequestAcceptancePage.isTrainingRequestAccepted();
        managerTrainingRequestAcceptancePage.removeLastLine("manager_requests_ids");
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
