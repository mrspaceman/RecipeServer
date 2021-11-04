package uk.co.droidinactu.recipeviewer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.droidinactu.recipeviewer.entity.RecipeIngredient;
import uk.co.droidinactu.recipeviewer.service.RecipeIngredientService;

import java.util.List;

@Slf4j
@RestController
public class RecipeIngredientController {

  private final RecipeIngredientService ingredientService;

  @Autowired
  public RecipeIngredientController(RecipeIngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @PostMapping("/ingredients")
  public ResponseEntity<RecipeIngredient> addIngredient(@RequestBody RecipeIngredient ingredient) {
    log.trace(this.getClass().getName() + ": addIngredient({})", ingredient);
    return new ResponseEntity<>(ingredientService.addIngredient(ingredient), HttpStatus.CREATED);
  }

  @GetMapping("/ingredients")
  public ResponseEntity<List<RecipeIngredient>> getIngredients() {
    log.trace(this.getClass().getName() + ": getIngredients()");
    return new ResponseEntity<>(ingredientService.getIngredients(), HttpStatus.OK);
  }

  @GetMapping("/ingredients/{id}")
  public ResponseEntity<RecipeIngredient> getIngredient(@PathVariable("id") Long id) {
    log.trace(this.getClass().getName() + ": getIngredient({})", id);
    return new ResponseEntity<>(ingredientService.getIngredient(id), HttpStatus.OK);
  }
}
