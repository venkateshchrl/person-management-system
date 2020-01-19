package com.demo.pms.person.service;

import com.demo.pms.entities.PersonEntity;
import com.demo.pms.repositories.PersonPredicateBuilder;
import com.demo.pms.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class PersonListService {
    private static final Logger logger = LoggerFactory.getLogger(PersonListService.class);
    private final PersonRepository personRepository;

    public PersonListService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Page<PersonEntity> execute(Pageable pageable, Map<String, String> filters){
        logger.debug("Filter provided to fetch person list - {}", filters);
        Page<PersonEntity> personEntities = personRepository.findAll(new PersonPredicateBuilder().withFilter(filters).build(), pageable);
        logger.debug("Retrieved person entities - {}", personEntities);
        return personEntities;
    }
}
