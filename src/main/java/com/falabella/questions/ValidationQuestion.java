package com.falabella.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

import static com.falabella.userInterfaces.CartUI.*;
import static com.falabella.utils.Excel.extractTo;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidationQuestion implements Task {
    ArrayList<Map<String, String>> data = extractTo();

    @Override
    public <T extends Actor> void performAs(T actor) {
        String actualTextProductOne = LBL_NAMEPRODUCT.of("2").resolveFor(actor).getText();
        String expectedTextProductOne = data.get(0).get("product_one");
        String[] regexProductOne = expectedTextProductOne.split("");
        for (String word : regexProductOne) {
            Assert.assertTrue("The current text does not contain the expected word for the first product: " + word, actualTextProductOne.contains(word));
        }

        String actualTextProductTwo = LBL_NAMEPRODUCT.of("1").resolveFor(actor).getText();
        String expectedTextProductTwo = data.get(0).get("product_two");
        String[] regexProductTwo = expectedTextProductTwo.split("");
        for (String word : regexProductTwo) {
            Assert.assertTrue("The current text does not contain the expected word for the second product: " + word, actualTextProductTwo.contains(word));
        }

        String actualQuantityOne = LBL_QUANTITY.of("1").resolveFor(actor).getText();
        String expectedQuantityOne = data.get(0).get("quantity_one");
        Assert.assertTrue("The added quantity does not match the requested quantity for the first product.", actualQuantityOne.matches(expectedQuantityOne));

        String actualQuantityTwo = LBL_QUANTITY.of("2").resolveFor(actor).getText();
        String expectedQuantityTwo = data.get(0).get("quantity_two");
        Assert.assertTrue("The added quantity does not match the requested quantity for the second product.", actualQuantityTwo.matches(expectedQuantityTwo));
    }

    public static ValidationQuestion module() {
        return instrumented(ValidationQuestion.class);
    }
}
