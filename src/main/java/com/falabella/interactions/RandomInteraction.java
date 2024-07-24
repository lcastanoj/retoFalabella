package com.falabella.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Random;

import static com.falabella.userInterfaces.SearchUI.*;
import static com.falabella.utils.Excel.writeToExcel;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RandomInteraction implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < 2; i++) {
            List<WebElementFacade> listProducts = LIST_PRODUCTS.resolveAllFor(actor);
            int index = (new Random()).nextInt(listProducts.size());

            if (i == 0) {
                WebElementFacade product = listProducts.get(index);
                writeToExcel("src/test/resources/data/data.xlsx", product.getText(), 1, 2);
                product.click();

                for (int j = 0; j < 1; j++) {
                    actor.attemptsTo(
                            Click.on(BUTTON_ADDCANT),
                            Click.on(BUTTON_ADDTOCART),
                            Click.on(BUTTON_KEEPBUYING),
                            GoBackInteraction.goBack()
                    );
                }
            } else {
                WebElementFacade product = listProducts.get(index);
                writeToExcel("src/test/resources/data/data.xlsx", product.getText(), 1, 3);
                product.click();

                for (int j = 0; j < 2; j++) {
                    actor.attemptsTo(
                            Click.on(BUTTON_ADDCANT)
                    );
                }
                actor.attemptsTo(
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
