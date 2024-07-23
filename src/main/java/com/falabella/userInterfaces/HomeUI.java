package com.falabella.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUI {
    public static Target INPUT_SEARCHBAR = Target.the("Search bar").located(By.id("testId-SearchBar-Input"));
}
