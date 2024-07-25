package com.falabella.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartUI {
    public static Target LBL_NAMEPRODUCT = Target.the("Label of product on cart").locatedBy("(//a[@data-testid='name'])[{0}]");
    public static Target LBL_QUANTITY = Target.the("Label of product on cart").locatedBy("//input[contains(@value, '{0}')]");
}
