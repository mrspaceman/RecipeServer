package uk.co.droidinactu.recipeviewer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@ComponentScan("uk.co.droidinactu.recipeviewer")
public class RecipeServerConfig {
}
