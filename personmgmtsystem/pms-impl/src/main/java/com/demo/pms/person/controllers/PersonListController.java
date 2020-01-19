package com.demo.pms.person.controllers;

import com.demo.pms.mappings.PersonMappingService;
import com.demo.pms.person.service.PersonListService;
import com.demo.pms.pojos.PersonPojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PersonListController {
    private final PersonMappingService personMappingService;
    private final PersonListService personListService;

    public PersonListController(PersonMappingService personMappingService, PersonListService personListService) {
        this.personMappingService = personMappingService;
        this.personListService = personListService;
    }

    public Page<PersonPojo> listPersons(Pageable pageable, Map<String, String> filters){
        return personMappingService.map(personListService.execute(pageable, filters));
    }
}
