package com.betacom.page;


import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withText;


public class EmployeeTrainingRequestDetailsPage extends AbstractPage {

    private static final By PAGE_HEADER = By.className("sbMainPageHeadingText");


    public void isAt(String id){
        assertThat(find(PAGE_HEADER).getText()).isEqualToIgnoringCase("Edytuj wniosek");
        assertThat(findFirst(".sbAttributeValue", withText().equalTo(id)).isDisplayed());

    }

}
