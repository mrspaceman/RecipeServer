package uk.co.droidinactu.recipeviewer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.droidinactu.recipeviewer.data.Recipe;

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
    public ResponseEntity<Recipe> addRecipe(Recipe recipe) {
        log.trace("addRecipe({})", recipe);
        return new ResponseEntity<>(recipeService.addRecipe(recipe), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Recipe>> getRecipes() {
        log.trace("getRecipes()");
        return new ResponseEntity<>(recipeService.getRecipes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable("id") Long id) {
        log.trace("getRecipe({})", id);
        return new ResponseEntity<>(recipeService.getRecipe(id), HttpStatus.OK);
    }
}
