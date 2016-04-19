package com.betacom.page;

import org.fluentlenium.core.annotation.PageUrl;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;


@PageUrl("http://172.30.4.161/Saba/Web/Main")
public class LoginPage extends AbstractPage {

    public static final By USERNAME_INPUT = By.name("j_username");
    public static final By PASSWORD_INPUT = By.name("j_password");
    public static final By LOGIN_BUTTON = By.className("sbDummy");


    public boolean isLoged(){
        if (find(USERNAME_INPUT).size() > 0)
            return false;
        else
            return true;
    }


    public void login(String username, String password)
    {
        fill("input").with(username, password);
        find(LOGIN_BUTTON).click();
    }

}
