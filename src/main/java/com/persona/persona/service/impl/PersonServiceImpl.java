package com.persona.persona.service.impl;

import com.persona.persona.dto.PersonDTO;
import com.persona.persona.mapper.PersonMapper;
import com.persona.persona.repository.PersonRepository;
import com.persona.persona.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        return personMapper.entityToDto(personRepository.save(personMapper.dtoToEntity(personDTO)));
    }

    @Override
    public PersonDTO getById(Long id) {
        try {
            return personMapper.entityToDto(personRepository.findById(id).get());
        } catch (Exception e) {
            throw new IllegalArgumentException("The id does not exist");
        }
    }
    @Override
    public List<PersonDTO> getByName(String name) {
        return personMapper.entityListToDto(personRepository.findByName(name));
    }
}
