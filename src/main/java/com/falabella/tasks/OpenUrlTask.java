package com.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import java.util.ArrayList;
import java.util.Map;

import static com.falabella.utils.Excel.extractTo;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenUrlTask implements Task {
    ArrayList<Map<String, String>> data = extractTo();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(data.get(0).get("url"))
        );
    }

    public  static OpenUrlTask at(){
        return instrumented(OpenUrlTask.class);
    }
}
