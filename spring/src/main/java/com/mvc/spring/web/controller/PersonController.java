package com.mvc.spring.web.controller;

import com.mvc.spring.domain.models.PersonModel;
import com.mvc.spring.domain.service.IPersonService;
import com.mvc.spring.persistence.errors.exception.NotFoundPerson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final IPersonService iPersonService;

    public PersonController(IPersonService iPersonService) {
        this.iPersonService = iPersonService;
    }

    @GetMapping("/personId/{id}")
    public PersonModel getPersonById(@PathVariable("id") Long personId) throws NotFoundPerson {
        return iPersonService.getPersonById(personId);
    }

    @GetMapping("/getAllPerson")
    public List<PersonModel> getAllPerson() {
        return iPersonService.getAllPerson();
    }

    @PostMapping("/savePerson")
    public PersonModel savePerson(@RequestBody PersonModel personModel) {
        return iPersonService.savePerson(personModel);
    }

    @PutMapping("/updatePerson/{id}")
    public PersonModel updatePerson(@RequestBody PersonModel personModel, @PathVariable("id") Long personId) {
        return iPersonService.updatePerson(personModel, personId);
    }

    @DeleteMapping("/deletePersonById/{id}")
    public String deletePersonById(@PathVariable("id") Long personId) {
        return iPersonService.deletePerson(personId);
    }

    @GetMapping("/findByNameIgnoreCase/{name}")
    public PersonModel findByName(@PathVariable("name") String name) {
        return iPersonService.findByName(name);
    }
}
