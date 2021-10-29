package uk.co.droidinactu.recipeviewer.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "recipe_step")
@Entity
public class RecipeStep {

  @Id @GeneratedValue private Long id;

  @ManyToOne
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  @Column(nullable = false)
  private String name;

  private String description;
  private int timer;

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }
}
