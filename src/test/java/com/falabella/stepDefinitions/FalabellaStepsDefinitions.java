package com.falabella.stepDefinitions;

import com.falabella.questions.ProductNameQuestion;
import com.falabella.questions.QuantityQuestion;
import com.falabella.tasks.OpenUrlTask;
import com.falabella.tasks.SearchProductsTask;
import com.falabella.tasks.SelectProductTask;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.Map;

import static com.falabella.utils.Excel.extractTo;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FalabellaStepsDefinitions {
    ArrayList<Map<String, String>> data = extractTo();

    @Given("the user is on the Falabella website")
    public void theUserIsOnTheFalabellaWebsite() {
        theActorInTheSpotlight().attemptsTo(OpenUrlTask.at());
    }

    @When("the user searches through the search bar")
    public void theUserSearchesThroughTheSearchBar() {
        theActorInTheSpotlight().attemptsTo(SearchProductsTask.onSearchBar());
    }

    @When("randomly selects products")
    public void randomlySelectsProducts() {
        theActorInTheSpotlight().attemptsTo(SelectProductTask.randomly());
    }

    @Then("they will validate that the products in the cart are the selected ones and the chosen quantities")
    public void theyWillValidateThatTheProductsInTheCartAreTheSelectedOnesAndTheChosenQuantities() {
        theActorInTheSpotlight().attemptsTo(ProductNameQuestion.withData(data));
        theActorInTheSpotlight().attemptsTo(QuantityQuestion.withData(data));
    }
}
