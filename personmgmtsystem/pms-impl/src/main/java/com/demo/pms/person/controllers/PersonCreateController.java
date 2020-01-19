package com.demo.pms.person.controllers;

import com.demo.pms.dto.PersonDTO;
import com.demo.pms.entities.PersonEntity;
import com.demo.pms.mappings.PersonMappingService;
import com.demo.pms.person.service.PersonCreateService;
import com.demo.pms.pojos.PersonPojo;
import org.springframework.stereotype.Service;

@Service
public class PersonCreateController {
    private final PersonMappingService personMappingService;
    private final PersonCreateService personCreateService;

    public PersonCreateController(PersonMappingService personMappingService, PersonCreateService personCreateService) {
        this.personMappingService = personMappingService;
        this.personCreateService = personCreateService;
    }

    public PersonPojo createPerson(PersonDTO personDto){
        PersonEntity personEntity = personCreateService.execute(personDto);
        return personMappingService.map(personEntity);
    }
}
