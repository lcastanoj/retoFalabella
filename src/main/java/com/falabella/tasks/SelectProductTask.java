package com.falabella.tasks;

import com.falabella.interactions.RandomInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.falabella.userInterfaces.ProductDetailsUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectProductTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                RandomInteraction.select()
        );
        actor.attemptsTo(
                      Click.on(BUTTON_CART)
        );
    }

    public static SelectProductTask randomly(){
        return instrumented(SelectProductTask.class);
    }
}
