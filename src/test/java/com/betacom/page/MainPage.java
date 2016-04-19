package com.betacom.page;


import org.fluentlenium.core.annotation.PageUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;


@PageUrl("http://172.30.4.161/Saba/Web_wdk/Main/index/preloginCloud.rdf?linkCxt2=Knowledge_Center")
public class MainPage extends AbstractPage {

    private static final By PAGE_HEADER = By.className("sbDashHeaderText");
    private static final By DOWN_ARROW_IMAGE = By.id("headerDropDownArrowElement");

    @Override
    public void isAt()
    {
        assertThat(find(PAGE_HEADER).getText()).isEqualTo("Moje aktywności world");
    }


}
