package uk.co.droidinactu.recipeviewer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Ingredient {

  @Id @GeneratedValue private Long id;

  /** The name of the ingredient */
  @Column(nullable = false)
  private String name;

  /** A brief description of the ingredient */
  @Column() private String description;

  @ManyToMany @Column() private List<Recipe> inRecipes;

  private String unit;
  private Integer size;
  private String container;

  @JsonProperty("default_type")
  private String defaultType;

  @ElementCollection private List<String> types;
}
