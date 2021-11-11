package uk.co.droidinactu.recipeviewer.integration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IngredientStepDefs extends SpringIntegrationTest {

  @When("^the client calls /ingredients$")
  public void the_client_issues_GET_version() throws Throwable {
    executeGet("http://localhost:8080/recipeserver/v1/ingredients");
  }

  @And("^the client receives a list of ingredients (.+)$")
  public void the_client_receives_server_version_body(String version) throws Throwable {
    assertThat(latestResponse.getBody(), is(version));
  }
}
