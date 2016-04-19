package com.betacom.page;


import org.fluentlenium.core.annotation.PageUrl;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

@PageUrl("http://172.30.4.161/Saba/Web_wdk/Main/tra/findRequestApproverView.rdf?linkCxt=Manager_Approver_Training_Request&linkCxt2=Knowledge_Center")
public class ManagerTrainingRequestAcceptancePage extends AbstractPage {
    private static final By PAGE_HEADER = By.className("sbMainPageHeadingText");
    private static final By TRAINING_REQUEST_ID_INPUT = By.name("Request_query_actual_var_REQUEST_ID$kString$kLike");
    private static final By SEND_CONFIRMATION_BOX = By.id("messageBoxLabel");

    @Override
    public void isAt(){
        assertThat(find(PAGE_HEADER).getText()).isEqualToIgnoringCase("Wnioski szkoleniowe");
    }

    public void populateTrainingRequestIdInput(String id)
    {
        fill(find(TRAINING_REQUEST_ID_INPUT)).with(id);
    }

    public void isEmployeeTrainingRequestDisplay(String id) {
        assertThat(findFirst(By.cssSelector("a[title="+id+"]")).isDisplayed());
    }

    public void isTrainingRequestAccepted(){
        assertThat(find(SEND_CONFIRMATION_BOX).getText()).isEqualToIgnoringCase("Powodzenie");
    }




}
