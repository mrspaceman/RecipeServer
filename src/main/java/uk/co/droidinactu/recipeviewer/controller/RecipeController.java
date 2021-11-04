package uk.co.droidinactu.recipeviewer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.droidinactu.recipeviewer.entity.Recipe;
import uk.co.droidinactu.recipeviewer.service.RecipeService;

import java.util.List;

@Slf4j
@RestController("/recipes")
public class RecipeController {

  private final RecipeService recipeService;

  @Autowired
  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @PostMapping()
  public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
    log.trace(this.getClass().getName() + ":addRecipe({})", recipe);
    return new ResponseEntity<>(recipeService.addRecipe(recipe), HttpStatus.CREATED);
  }

  @GetMapping()
  public ResponseEntity<List<Recipe>> getRecipes() {
    log.trace(this.getClass().getName() + ":getRecipes()");
    return new ResponseEntity<>(recipeService.getRecipes(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Recipe> getRecipe(@PathVariable("id") Long id) {
    log.trace(this.getClass().getName() + ":getRecipe({})", id);
    return new ResponseEntity<>(recipeService.getRecipe(id), HttpStatus.OK);
  }
}
