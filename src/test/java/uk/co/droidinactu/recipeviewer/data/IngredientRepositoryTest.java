package uk.co.droidinactu.recipeviewer.data;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private WebApplicationContext context;

    private Faker faker;

    private int nbrIngredients = 14;

    @BeforeEach
    public void setUp() {
        faker = new Faker();

        for (int x = 0; x < nbrIngredients; x++) {
            Ingredient i = getIngredient();
            ingredientRepository.save(i);
        }
    }

    private Ingredient getIngredient() {
        Ingredient i = new Ingredient();
        i.setName(faker.food().ingredient());
        return i;
    }

    @Test
    public void findAll_returnsAllIngredients() {
        assertEquals(nbrIngredients, ingredientRepository.findAll().size());
    }
}
