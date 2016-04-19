package com.betacom.page;

import org.openqa.selenium.By;
import properties.methods.GetPropertyValue;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

public class NewTrainingRequestFormPage extends AbstractPage {

    private static final By PAGE_HEADER = By.className("sbMainPageHeadingText");
    private static final By PROJECT_CATEGORY_INPUT = By.name("fieldValuetrfir000000000005713bookkeep");
    private static final By IS_REQUEST_WITH_PROJECT_CHECK_BOX = By.name("isRequestWithProject");
    private static final By OFFER_NAME_INPUT = By.name("fieldValuetrfir000000000005710bookkeep");
    private static final By DEVELOPMENT_METHOD_DROPDOWN = By.name("fieldValuetrfir000000000005709");
    private static final By UNIT_COST_INPUT = By.name("fieldValuetrfir000000000005712");
    private static final By CREATE_CONFIRMATION_BOX = By.id("messageBoxLabel");
    private static final By CALENDAR_BUTTON = By.name("develProposalIdCalendar");
    private static final By PROJECT_NAME_INPUT = By.name("fieldValuetrfir000000000005708bookkeep");
    private static final By TRAINING_REQUEST_ID_FIELD = By.className("sbAttributeValue");

    private GetPropertyValue properties = new GetPropertyValue();


    @Override
    public void isAt(){
        assertThat(find(PAGE_HEADER).getText()).isEqualTo("Nowy wniosek");
    }

    public void populateForm() throws IOException {
        find(IS_REQUEST_WITH_PROJECT_CHECK_BOX).click();
        find(CALENDAR_BUTTON).click();
        click("a", withText(properties.getPropValue("trainingRequestForm.properties", "month")));
        serchAndClick(PROJECT_CATEGORY_INPUT, properties.getPropValue("trainingRequestForm.properties", "projectCategoryName"));
        serchAndClick(OFFER_NAME_INPUT, properties.getPropValue("trainingRequestForm.properties", "offerName"));
        serchAndClick(PROJECT_NAME_INPUT, properties.getPropValue("trainingRequestForm.properties", "projectName"));
        findFirst(DEVELOPMENT_METHOD_DROPDOWN).fillSelect().withText(properties.getPropValue("trainingRequestForm.properties", "developmentMethodName"));
        fill(find(UNIT_COST_INPUT)).with(properties.getPropValue("trainingRequestForm.properties", "unitCost"));
    }

    public void isRequestTrainCreated() {
        assertThat(find(PAGE_HEADER).getText()).isEqualTo("Edytuj wniosek");
        assertThat(find(CREATE_CONFIRMATION_BOX).getText()).isEqualTo("Powodzenie");
    }

    public void getTrainingRequestID() throws IOException{
        String ID = find(TRAINING_REQUEST_ID_FIELD, withText().startsWith("trequ")).getText();
        writeToFile("manager_requests_ids", ID);
    }


}
