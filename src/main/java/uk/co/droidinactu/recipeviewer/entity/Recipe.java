package uk.co.droidinactu.recipeviewer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Recipe {

  @Id @GeneratedValue private Long id;

  /** The name of the recipe */
  @Column(nullable = false)
  private String name;

  /** A brief description of the recipe */
  @Column() private String description;

  private String imageURL;
  private String originalURL;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<RecipeIngredient> ingredients;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe")
  private List<RecipeStep> steps;
}
