package com.falabella.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Tasks;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Map;

import static com.falabella.userInterfaces.CartUI.LBL_NAMEPRODUCT;
import static com.falabella.utils.Excel.extractTo;

public class ProductNameQuestion implements Task {
    ArrayList<Map<String, String>> data = extractTo();

    @Override
    public <T extends Actor> void performAs(T actor) {
        validateProductText(actor, LBL_NAMEPRODUCT.of("2"), data.get(0).get("product_one"));
        validateProductText(actor, LBL_NAMEPRODUCT.of("1"), data.get(0).get("product_two"));
    }

    private void validateProductText(Actor actor, Target productTarget, String expectedText) {
        String actualText = productTarget.resolveFor(actor).getText();
        String[] expectedWords = expectedText.split("\\s+");
        for (String word : expectedWords) {
            Assert.assertTrue("The current text does not contain the expected word: " + word,
                    actualText.contains(word));
        }
    }

    public static ProductNameQuestion withData(ArrayList<Map<String, String>> data) {
        return Tasks.instrumented(ProductNameQuestion.class, data);
    }
}
