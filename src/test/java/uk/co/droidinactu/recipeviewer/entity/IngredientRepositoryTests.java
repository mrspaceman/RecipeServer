package uk.co.droidinactu.recipeviewer.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IngredientRepositoryTests {

  @Autowired private RecipeIngredientRepository ingredientRepository;

  @BeforeEach
  public void setUp() {}

  @Test
  void sample() throws Exception {
    //
    // this.mockMvc.perform(get("/recipes")).andExpect(status().isOk()).andDo(document("sample"));
  }
}
