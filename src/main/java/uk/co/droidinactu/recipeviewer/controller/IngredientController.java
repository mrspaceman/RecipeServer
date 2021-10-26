package uk.co.droidinactu.recipeviewer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.droidinactu.recipeviewer.entity.Ingredient;
import uk.co.droidinactu.recipeviewer.service.IngredientService;

import java.util.List;

@Slf4j
@RestController
public class IngredientController {

  private final IngredientService ingredientService;

  @Autowired
  public IngredientController(IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @PostMapping("/ingredients")
  public ResponseEntity<Ingredient> addIngredient(Ingredient ingredient) {
    log.trace("addIngredient({})", ingredient);
    return new ResponseEntity<>(ingredientService.addIngredient(ingredient), HttpStatus.CREATED);
  }

  @GetMapping("/ingredients")
  public ResponseEntity<List<Ingredient>> getIngredients() {
    log.trace("getIngredients()");
    return new ResponseEntity<>(ingredientService.getIngredients(), HttpStatus.OK);
  }

  @GetMapping("/ingredients/{id}")
  public ResponseEntity<Ingredient> getIngredient(@PathVariable("id") Long id) {
    log.trace("getIngredient({})", id);
    return new ResponseEntity<>(ingredientService.getIngredient(id), HttpStatus.OK);
  }
}
