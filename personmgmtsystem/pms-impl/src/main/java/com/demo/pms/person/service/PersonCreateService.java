package com.demo.pms.person.service;

import com.demo.pms.constants.Codes;
import com.demo.pms.dto.PersonDTO;
import com.demo.pms.entities.PersonEntity;
import com.demo.pms.exceptions.DuplicateRecordException;
import com.demo.pms.mappings.PersonMappingService;
import com.demo.pms.repositories.PersonPredicateBuilder;
import com.demo.pms.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonCreateService {
    private static final Logger logger = LoggerFactory.getLogger(PersonCreateService.class);
    private final PersonMappingService personMappingService;
    private final PersonRepository personRepository;

    public PersonCreateService(PersonMappingService personMappingService, PersonRepository personRepository) {
        this.personMappingService = personMappingService;
        this.personRepository = personRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public PersonEntity execute(PersonDTO personDto){
        logger.debug("Creating Person from personDto - {}", personDto);
        Map<String, String> filter = new HashMap<>();
        filter.put("firstName", personDto.getFirstName());
        filter.put("lastName", personDto.getLastName());
        logger.debug("Filter prepared is - {}", filter);
        logger.debug("Querying if person with similar details already exits");
        Optional<PersonEntity> personEntityOptional = personRepository.findOne(new PersonPredicateBuilder().withFilter(filter).build());
        if(personEntityOptional.isPresent()){
            logger.warn("Person with same firstName({}) and lastName({}) already exists. Please try different name.", personDto.getFirstName(), personDto.getLastName());
            throw new DuplicateRecordException(Codes.PERSON_CREATION_UPDATION_FAILED_DUPLICATE_RECORD_CODE, Codes.PERSON_CREATION_UPDATION_FAILED_DUPLICATE_RECORD_MSG);
        }
        PersonEntity personEntity = personMappingService.map(personMappingService.map(personDto));
        personEntity = personRepository.save(personEntity);
        logger.debug("Person({}) addition successful", personEntity);
        return personEntity;
    }
}
