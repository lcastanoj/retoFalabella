package com.falabella.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartUI {
    public static Target LBL_NAMEPRODUCTONE = Target.the("Label of product on cart").locatedBy("(//a[@data-testid='name'])[1]");
    public static Target LBL_NAMEPRODUCTTWO = Target.the("Label of product on cart").locatedBy("(//a[@data-testid='name'])[2]");
}
