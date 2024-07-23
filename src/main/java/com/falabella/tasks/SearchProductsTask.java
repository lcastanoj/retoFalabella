package com.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.ArrayList;
import java.util.Map;

import static com.falabella.userInterfaces.HomeUI.*;
import static com.falabella.utils.Excel.extractTo;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class SearchProductsTask implements Task {
    ArrayList<Map<String, String>> data = extractTo();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(INPUT_SEARCHBAR),
                Enter.theValue(data.get(0).get("product")).into(INPUT_SEARCHBAR).thenHit(ENTER)
        );
    }

    public static SearchProductsTask onSearchBar(){
        return  instrumented(SearchProductsTask.class);
    }
}
