package com.demo.pms.person.controllers;

import com.demo.pms.dto.PersonDTO;
import com.demo.pms.mappings.PersonMappingService;
import com.demo.pms.person.service.PersonUpdateService;
import com.demo.pms.pojos.PersonPojo;
import org.springframework.stereotype.Service;

@Service
public class PersonUpdateController {
    private final PersonMappingService personMappingService;
    private final PersonUpdateService personUpdateService;

    public PersonUpdateController(PersonMappingService personMappingService, PersonUpdateService personUpdateService) {
        this.personMappingService = personMappingService;
        this.personUpdateService = personUpdateService;
    }

    public PersonPojo updatePerson(String id, PersonDTO personDto){
        return personMappingService.map(personUpdateService.execute(id, personDto));
    }
}
