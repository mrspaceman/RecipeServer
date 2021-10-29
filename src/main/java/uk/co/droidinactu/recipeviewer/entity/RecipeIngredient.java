package uk.co.droidinactu.recipeviewer.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "recipe_ingredient")
@Entity
public class RecipeIngredient {

  @Id @GeneratedValue private Long id;

  private String quantity;
  private String name;
  private String type;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Recipe> recipes;
}
