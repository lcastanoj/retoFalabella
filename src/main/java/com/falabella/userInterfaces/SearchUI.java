package com.falabella.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchUI {
    public static Target LIST_PRODUCTS = Target.the("List of the products").locatedBy("//div[@class='jsx-1068418086 search-results-4-grid grid-pod']/a/div[contains(@class, 'pod-details')]");
}
