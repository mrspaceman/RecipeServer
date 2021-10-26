package uk.co.droidinactu.recipeviewer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import uk.co.droidinactu.recipeviewer.entity.Ingredient;
import uk.co.droidinactu.recipeviewer.entity.IngredientRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
@SpringBootTest
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@AutoConfigureRestDocs
public class IngredientRestDocsTests {

  @Autowired private IngredientRepository ingredientRepository;

  @Autowired private WebApplicationContext context;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp(RestDocumentationContextProvider restDocumentation) {
    this.mockMvc =
        MockMvcBuilders.webAppContextSetup(context)
            .apply(documentationConfiguration(restDocumentation))
            .alwaysDo(
                document(
                    "{method-name}/{step}/",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())))
            .build();
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Disabled("Until I get spring-rest-docs working")
  @Test
  void addIngredients() throws Exception {
    Ingredient r = new Ingredient();
    r.setName("Test Recipe");
    r.setDescription("A sample ingredient for testing");
    this.mockMvc
        .perform(
            post("/ingredients")
                .content(asJsonString(r))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andDo(
            document(
                "add-ingredient",
                requestFields(
                    fieldWithPath("id").description("The id of the recipe"),
                    fieldWithPath("name").description("The name of the recipe"),
                    fieldWithPath("description")
                        .description("A brief description of the recipe"))));
  }

  @Disabled("Until I get spring-rest-docs working")
  @Test
  void listIngredients() throws Exception {
    this.mockMvc
        .perform(get("/ingredients").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(document("list-ingredients"));
  }

  @Disabled("Until I get spring-rest-docs working")
  @Test
  void getIngredients() throws Exception {
    Long rId = 5L;
    Ingredient r = new Ingredient();
    r.setId(rId);
    r.setName("Test Recipe");
    r.setDescription("A sample ingredient for testing");
    ingredientRepository.save(r);

    List<Ingredient> recipes = ingredientRepository.findAll();
    Optional<Ingredient> recipe = ingredientRepository.findById(5L);

    this.mockMvc
        .perform(get("/recipes/{id}", 5L))
        .andExpect(status().isOk())
        .andDo(
            document(
                "get-ingredient-by-id",
                pathParameters(
                    parameterWithName("id").description("The id of the recipe to retrieve"))));
  }
}
