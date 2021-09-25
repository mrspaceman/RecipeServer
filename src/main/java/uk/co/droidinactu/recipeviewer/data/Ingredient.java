package uk.co.droidinactu.recipeviewer.data;

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

    @Id
    @GeneratedValue
    private Long id;

    /** The name of the ingredient */
    @Column(nullable = false)
    private String name;

    /** A brief description of the ingredient */
    @Column()
    private String description;

    @ManyToMany
    @Column()
    private List<Recipe> inRecipes;
}
