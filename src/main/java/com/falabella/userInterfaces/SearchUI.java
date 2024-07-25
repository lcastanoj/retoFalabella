package com.falabella.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchUI {
    public static Target LIST_PRODUCTS = Target.the("List of the products").locatedBy("//div[@class='jsx-1068418086 search-results-4-grid grid-pod']/a/div[contains(@class, 'pod-details')]");
    public static Target INPUT_ADDCANT = Target.the("Button add quantity").located(By.id("quantity-selector-increment-input"));
    public static Target BUTTON_ADDTOCART = Target.the("Button add to cart").located(By.id("add-to-cart-button"));
    public static Target BUTTON_KEEPBUYING = Target.the("Button keep buying").locatedBy("//i[@class='jsx-2454879041 csicon-danger']");
    public static Target BUTTON_CART = Target.the("Button go to cart").located(By.id("testId-UserAction-basket"));
}
