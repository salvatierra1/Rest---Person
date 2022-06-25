package com.persona.persona.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty(message = "the name cannot be empty or null")
    private String name;

    @NotEmpty(message = "the lastname cannot be empty or null")
    private String lastname;

}
