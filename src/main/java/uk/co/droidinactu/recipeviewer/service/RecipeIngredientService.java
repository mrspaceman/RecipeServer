package uk.co.droidinactu.recipeviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.droidinactu.recipeviewer.entity.RecipeIngredient;
import uk.co.droidinactu.recipeviewer.entity.RecipeIngredientRepository;
import uk.co.droidinactu.recipeviewer.entity.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeIngredientService {

  private final RecipeRepository recipeRepository;
  private final RecipeIngredientRepository ingredientRepository;

  @Autowired
  public RecipeIngredientService(
      RecipeIngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
    this.ingredientRepository = ingredientRepository;
    this.recipeRepository = recipeRepository;
  }

  public List<RecipeIngredient> getIngredients() {
    return ingredientRepository.findAll();
  }

  public RecipeIngredient addIngredient(RecipeIngredient ingredient) {
    return ingredientRepository.save(ingredient);
  }

  public RecipeIngredient getIngredient(Long id) {
    Optional<RecipeIngredient> ingredient = ingredientRepository.findById(id);
    return ingredient.orElse(null);
  }
}
