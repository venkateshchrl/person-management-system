package com.demo.pms.person.controllers;

import com.demo.pms.mappings.PersonMappingService;
import com.demo.pms.person.service.PersonDetailsService;
import com.demo.pms.pojos.PersonPojo;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsController {
    private final PersonMappingService personMappingService;
    private final PersonDetailsService personDetailsService;

    public PersonDetailsController(PersonMappingService personMappingService, PersonDetailsService personDetailsService) {
        this.personMappingService = personMappingService;
        this.personDetailsService = personDetailsService;
    }

    public PersonPojo fetchPersonDetails(String id){
        return personMappingService.map(personDetailsService.execute(id));
    }
}
