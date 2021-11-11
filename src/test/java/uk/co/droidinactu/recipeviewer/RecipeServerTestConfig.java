package uk.co.droidinactu.recipeviewer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("uk.co.droidinactu.recipeviewer")
public class RecipeServerTestConfig {

  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
