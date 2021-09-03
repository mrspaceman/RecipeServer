package uk.co.droidinactu.recipeviewer.data;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Slf4j
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Recipe {

  @Id @GeneratedValue private Long id;

  /** The name of the recipe */
  private String name;

  /** A brief description of the recipe */
  private String description;

  // private List<Ingredient> ingredients;

}
