package uk.co.droidinactu.recipeviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.droidinactu.recipeviewer.entity.Recipe;
import uk.co.droidinactu.recipeviewer.entity.RecipeIngredientRepository;
import uk.co.droidinactu.recipeviewer.entity.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

  private final RecipeRepository recipeRepository;
  private final RecipeIngredientRepository ingredientRepository;

  @Autowired
  public RecipeService(
      RecipeIngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
    this.ingredientRepository = ingredientRepository;
    this.recipeRepository = recipeRepository;
  }

  public List<Recipe> getRecipes() {
    return recipeRepository.findAll();
  }

  public Recipe addRecipe(Recipe recipe) {
    return recipeRepository.save(recipe);
  }

  public Recipe getRecipe(Long id) {
    Optional<Recipe> recipe = recipeRepository.findById(id);
    return recipe.orElse(null);
  }
}
