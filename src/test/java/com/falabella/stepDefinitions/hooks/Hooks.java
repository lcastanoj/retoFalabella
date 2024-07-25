package com.falabella.stepDefinitions.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.junit.After;

import static com.falabella.utils.DriverFactory.getDriver;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Hooks {
    @Managed
    WebDriver driver;

    @Before
    public void setUp() {
        driver = getDriver();
        setTheStage(new OnlineCast());
        theActorCalled("user").whoCan(BrowseTheWeb.with(driver));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
