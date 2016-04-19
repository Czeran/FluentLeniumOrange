package com.betacom.page;


import org.fluentlenium.core.annotation.PageUrl;
import org.openqa.selenium.By;
import properties.methods.GetPropertyValue;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@PageUrl("http://172.30.4.161/Saba/Web_wdk/Main/tra/findTemplateEmployee.rdf?linkCxt=Emp_Training_Request_Tab&linkCxt2=Knowledge_Center")
public class NewTrainingRequestPage extends AbstractPage {

    private static final By PAGE_TITLE = By.className("sbMainPageHeadingText");
    private static final By TRAINING_REQUEST_TEMPLATE_NAME_INPUT = By.name("Template_query_var_NAME$kString$kLike");
    private static final By SEARCHING_RESULT = By.cssSelector("span[class='sbListText']");
    private static final By SEND_CONFIRMATION_BOX = By.id("messageBoxLabel");


    GetPropertyValue property = new GetPropertyValue();

    @Override
    public void isAt() {
        assertThat(find(PAGE_TITLE).getText()).isEqualTo("Szablony wniosków szkoleniowych");
    }

    public NewTrainingRequestPage populateTemplateFieldName() throws IOException {
        fill(find(TRAINING_REQUEST_TEMPLATE_NAME_INPUT)).with(property.getPropValue("trainingRequest.properties", "template_name"));
        return this;
    }

    public void isSearchResultDisplays() throws IOException
    {
        isAt();
        assertThat(find(SEARCHING_RESULT, 0).getText()).isEqualTo(property.getPropValue("trainingRequest.properties", "template_name"));
    }

    public void isTrainingRequestSend(){
        isAt();
        assertThat(find(SEND_CONFIRMATION_BOX).getText()).isEqualTo("Powodzenie");
    }


}
