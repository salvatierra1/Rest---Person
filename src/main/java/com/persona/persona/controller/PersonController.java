package com.persona.persona.controller;

import com.persona.persona.dto.PersonDTO;
import com.persona.persona.model.Menssage;
import com.persona.persona.repository.PersonRepository;
import com.persona.persona.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<PersonDTO> save(@Validated @RequestBody PersonDTO personDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.save(personDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPerson(@Validated @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body( personService.getById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<PersonDTO>> getName(@Validated @PathVariable String name) {

        if (personService.getByName(name).isEmpty()) {
            return new ResponseEntity(new Menssage("The name does not exist."), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.OK).body(personService.getByName(name));
    }
}
