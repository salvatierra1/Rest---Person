package com.persona.persona.mapper;

import com.persona.persona.dto.PersonDTO;
import com.persona.persona.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {
    public Person dtoToEntity(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setLastname(personDTO.getLastname());
        return person;
    }

    public PersonDTO entityToDto(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setLastname(person.getLastname());
        return dto;
    }
    public List<PersonDTO> entityListToDto(List<Person> personaLis) {
        return personaLis.stream().map(p-> entityToDto(p)).collect(Collectors.toList());
    }
}
