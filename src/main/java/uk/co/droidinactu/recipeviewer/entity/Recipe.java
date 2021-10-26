package uk.co.droidinactu.recipeviewer.entity;

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
public class Recipe {

  @Id @GeneratedValue private Long id;

  /** The name of the recipe */
  @Column(nullable = false)
  private String name;

  /** A brief description of the recipe */
  @Column() private String description;

  @ManyToMany @Column() private List<Ingredient> ingredients;
}
