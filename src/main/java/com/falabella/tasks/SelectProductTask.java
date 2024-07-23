package com.falabella.tasks;

import com.falabella.interactions.RandomInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectProductTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                RandomInteraction.select()
        );
    }

    public static SelectProductTask randomly(){
        return instrumented(SelectProductTask.class);
    }
}
