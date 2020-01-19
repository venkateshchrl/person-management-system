package com.demo.pms.person.service;

import com.demo.pms.constants.Codes;
import com.demo.pms.entities.PersonEntity;
import com.demo.pms.exceptions.RecordNotFoundException;
import com.demo.pms.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(PersonDetailsService.class);
    private final PersonRepository personRepository;

    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public PersonEntity execute(String id){
        logger.debug("Querying the person details with the provided id({})", id);
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);
        if(personEntityOptional.isPresent()){
            PersonEntity personEntity = personEntityOptional.get();
            logger.debug("Fetched person details are {}", personEntity);
            return personEntity;
        } else {
            logger.error("No person available with specified id({})", id);
            throw new RecordNotFoundException(Codes.PERSON_NOT_FOUND_CODE, Codes.PERSON_NOT_FOUND_MSG);
        }
    }
}
