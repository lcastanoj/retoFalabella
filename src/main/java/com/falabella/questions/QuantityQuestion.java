package com.falabella.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Map;

import static com.falabella.userInterfaces.CartUI.LBL_QUANTITY;
import static com.falabella.utils.Excel.extractTo;

public class QuantityQuestion implements Task {
    ArrayList<Map<String, String>> data = extractTo();

    @Override
    public <T extends Actor> void performAs(T actor) {
        quantityQuestion(actor, LBL_QUANTITY.of("2"), data.get(0).get("quantity_one"));
        quantityQuestion(actor, LBL_QUANTITY.of("3"), data.get(0).get("quantity_two"));
    }

    private void quantityQuestion(Actor actor, Target quantityTarget, String expectedQuantity) {
        String actualQuantity = quantityTarget.resolveFor(actor).getAttribute("value");
        Assert.assertTrue("The added quantity does not match the requested quantity: " + expectedQuantity,
                actualQuantity.matches(expectedQuantity));
    }

    public static QuantityQuestion withData(ArrayList<Map<String, String>> data) {
        return Tasks.instrumented(QuantityQuestion.class, data);
    }
}
