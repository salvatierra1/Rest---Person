package com.persona.persona.service;

import com.persona.persona.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO save(PersonDTO personDTO);
    PersonDTO getById(Long id);
    List<PersonDTO> getByName(String name);
}
