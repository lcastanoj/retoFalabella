package com.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.falabella.userInterfaces.SearchUI.BUTTON_CART;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToCartTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_CART)
        );
    }

    public static GoToCartTask module(){
        return  instrumented(GoToCartTask.class);
    }
}
