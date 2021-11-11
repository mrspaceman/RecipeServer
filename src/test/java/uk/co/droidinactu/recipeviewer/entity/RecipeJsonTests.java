package uk.co.droidinactu.recipeviewer.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.util.IOUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RecipeJsonTests {

  @Test
  public void shouldDeserializeSimpleObject() throws JsonProcessingException {
    ClassLoader classLoader = this.getClass().getClassLoader();
    String json = IOUtils.toString(classLoader.getResourceAsStream("recipes-simple.json"), UTF_8);

    ObjectMapper objectMapper = new ObjectMapper();
    List<Recipe> obj = objectMapper.readValue(json, new TypeReference<List<Recipe>>() {});
  }

  @Test
  public void shouldDeserializeComplexObject() throws JsonProcessingException {
    ClassLoader classLoader = this.getClass().getClassLoader();
    String json = IOUtils.toString(classLoader.getResourceAsStream("recipes-complex.json"), UTF_8);

    ObjectMapper objectMapper = new ObjectMapper();
    List<Recipe> obj = objectMapper.readValue(json, new TypeReference<List<Recipe>>() {});
  }

  @Test
  public void shouldDeserializeAllObjectsInLargeFile() throws JsonProcessingException {
    ClassLoader classLoader = this.getClass().getClassLoader();
    String json = IOUtils.toString(classLoader.getResourceAsStream("recipes-all.json"), UTF_8);

    ObjectMapper objectMapper = new ObjectMapper();
    List<Recipe> obj = objectMapper.readValue(json, new TypeReference<List<Recipe>>() {});
  }
}