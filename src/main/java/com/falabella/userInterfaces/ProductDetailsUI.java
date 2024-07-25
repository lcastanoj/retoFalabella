package com.falabella.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductDetailsUI {
    public static Target LBL_NAMEPRODUCT = Target.the("Label of product on details").locatedBy("//h1[contains(@class, 'product-name fa')]");
    public static Target INPUT_ADDCANT = Target.the("Button add quantity").located(By.id("quantity-selector-increment-input"));
    public static Target BUTTON_ADDTOCART = Target.the("Button add to cart").located(By.id("add-to-cart-button"));
    public static Target BUTTON_KEEPBUYING = Target.the("Button keep buying").locatedBy("//i[@class='jsx-2454879041 csicon-danger']");
    public static Target BUTTON_CART = Target.the("Button go to cart").located(By.id("testId-UserAction-basket"));
}
