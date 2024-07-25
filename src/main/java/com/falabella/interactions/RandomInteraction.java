package com.falabella.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.falabella.userInterfaces.ProductDetailsUI.*;
import static com.falabella.userInterfaces.SearchUI.*;
import static com.falabella.utils.Excel.extractTo;
import static com.falabella.utils.Excel.writeToExcel;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RandomInteraction implements Interaction {
    ArrayList<Map<String, String>> data = extractTo();

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < 2; i++) {
            List<WebElementFacade> listProducts = LIST_PRODUCTS.resolveAllFor(actor);
            int index = (new Random()).nextInt(listProducts.size());

            if (i == 0) {
                WebElementFacade product = listProducts.get(index);
                product.click();
                String nameProduct = LBL_NAMEPRODUCT.resolveFor(actor).getText();
                writeToExcel("src/test/resources/data/data.xlsx", nameProduct, 1, 2);

                actor.attemptsTo(
                        Clear.field(INPUT_ADDCANT),
                        Enter.theValue(data.get(0).get("quantity_one")).into(INPUT_ADDCANT),
                        Click.on(BUTTON_ADDTOCART),
                        Click.on(BUTTON_KEEPBUYING),
                        GoBackInteraction.goBack()
                );
            } else {
                WebElementFacade product = listProducts.get(index);
                product.click();
                String nameProduct = LBL_NAMEPRODUCT.resolveFor(actor).getText();
                writeToExcel("src/test/resources/data/data.xlsx", nameProduct, 1, 3);

                actor.attemptsTo(
                        Clear.field(INPUT_ADDCANT),
                        Enter.theValue(data.get(0).get("quantity_two")).into(INPUT_ADDCANT),
                        Click.on(BUTTON_ADDTOCART),
                        Click.on(BUTTON_KEEPBUYING)
                );
            }
        }
    }

    public static Performable select() {
        return instrumented(RandomInteraction.class);
    }
}
