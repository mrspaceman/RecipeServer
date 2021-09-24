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
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    /** The name of the ingredient */
    private String name;

    /** A brief description of the ingredient */
    private String description;
}
