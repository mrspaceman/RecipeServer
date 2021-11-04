package uk.co.droidinactu.recipeviewer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "recipe_ingredient")
@Entity
public class RecipeIngredient {

  @Id @GeneratedValue private Long id;

  @Column(nullable = false)
  private String name;

  private String description;
  private String quantity;
  private String type;
  private String unit;
  private Integer size;
  private String container;

  @JsonProperty("default_type")
  private String defaultType;

  @ElementCollection private List<String> types;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Recipe> recipes;
}
