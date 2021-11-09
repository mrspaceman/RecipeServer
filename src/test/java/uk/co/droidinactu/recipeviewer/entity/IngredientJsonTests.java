package uk.co.droidinactu.recipeviewer.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.util.IOUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class IngredientJsonTests {

  @Test
  public void shouldDeserializeSimpleObject() throws JsonProcessingException {
    ClassLoader classLoader = this.getClass().getClassLoader();
    String json =
        IOUtils.toString(classLoader.getResourceAsStream("ingredients-simple.json"), UTF_8);

    ObjectMapper objectMapper = new ObjectMapper();
    List<RecipeIngredient> obj =
        objectMapper.readValue(json, new TypeReference<List<RecipeIngredient>>() {});
  }

  @Test
  public void shouldDeserializeComplexObject() throws JsonProcessingException {
    ClassLoader classLoader = this.getClass().getClassLoader();
    String json =
        IOUtils.toString(classLoader.getResourceAsStream("ingredients-complex.json"), UTF_8);

    ObjectMapper objectMapper = new ObjectMapper();
    List<RecipeIngredient> obj =
        objectMapper.readValue(json, new TypeReference<List<RecipeIngredient>>() {});
  }

  @Test
  public void shouldDeserializeAllObjectsInLargeFile() throws JsonProcessingException {
    ClassLoader classLoader = this.getClass().getClassLoader();
    String json = IOUtils.toString(classLoader.getResourceAsStream("ingredients-all.json"), UTF_8);

    ObjectMapper objectMapper = new ObjectMapper();
    List<RecipeIngredient> obj =
        objectMapper.readValue(json, new TypeReference<List<RecipeIngredient>>() {});
  }
}
