package com.demo.pms.person.controllers;

import com.demo.pms.person.service.PersonDeleteService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonDeleteController {
    private final PersonDeleteService personDeleteService;

    public PersonDeleteController(PersonDeleteService personDeleteService) {
        this.personDeleteService = personDeleteService;
    }

    public List<String> deletePersons(String ids){
        List<String> idsList = Arrays.asList(ids.split(","));
        personDeleteService.execute(idsList);
        return idsList;
    }
}
