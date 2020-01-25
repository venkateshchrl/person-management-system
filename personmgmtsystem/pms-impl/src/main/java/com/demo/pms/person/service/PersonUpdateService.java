package com.demo.pms.person.service;

import com.demo.pms.constants.Codes;
import com.demo.pms.dto.PersonDTO;
import com.demo.pms.entities.PersonEntity;
import com.demo.pms.exceptions.DuplicateRecordException;
import com.demo.pms.exceptions.RecordNotFoundException;
import com.demo.pms.mappings.PersonMappingService;
import com.demo.pms.repositories.PersonPredicateBuilder;
import com.demo.pms.repositories.PersonRepository;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonUpdateService {
    private static final Logger logger = LoggerFactory.getLogger(PersonCreateService.class);
    private final PersonMappingService personMappingService;
    private final PersonRepository personRepository;

    public PersonUpdateService(PersonMappingService personMappingService, PersonRepository personRepository) {
        this.personMappingService = personMappingService;
        this.personRepository = personRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public PersonEntity execute(String id, PersonDTO personDto){
        logger.debug("Updating the person details with id({}) as {}", id, personDto);
        Map<String, String> filters = new HashMap<>();
        filters.put("firstName", personDto.getFirstName());
        filters.put("lastName", personDto.getLastName());
        logger.debug("Querying if person with similar details already exits");
        Optional<PersonEntity> personEntityOptional = personRepository.findOne(new PersonPredicateBuilder().withFilter(filters).build());
        if(personEntityOptional.isPresent()){
            logger.warn("Update failed as person with similar firstName({})/lastName({}) already exists", personDto.getFirstName(), personDto.getLastName());
            throw new DuplicateRecordException(Codes.PERSON_CREATION_UPDATION_FAILED_DUPLICATE_RECORD_CODE, Codes.PERSON_CREATION_UPDATION_FAILED_DUPLICATE_RECORD_MSG);
        }
        logger.debug("Querying the person details with the provided id({})", id);
        personEntityOptional = personRepository.findById(id);
        if(personEntityOptional.isPresent()){
            PersonEntity personEntity = personEntityOptional.get();
            logger.debug("Fetched person details are {}", personEntity);
            personEntity = getUpdatedEntity(personDto, personEntity);
            logger.debug("Modified person details are {}", personEntity);
            personEntity = personRepository.save(personEntity);
            logger.debug("Updated person details are {}", personEntity);
            return personEntity;
        } else {
            logger.error("No person available with specified id({})", id);
            throw new RecordNotFoundException(Codes.PERSON_NOT_FOUND_CODE, Codes.PERSON_NOT_FOUND_MSG);
        }
    }

    private PersonEntity getUpdatedEntity(PersonDTO personDto, PersonEntity personEntity){
        if(personDto.getFirstName() != null && !personDto.getFirstName().isEmpty() && !personEntity.getFirstName().equals(personDto.getFirstName())){
            personEntity.setFirstName(personDto.getFirstName());
        }
        if(personDto.getLastName() != null && !personDto.getLastName().isEmpty() && !personEntity.getLastName().equals(personDto.getLastName())){
            personEntity.setLastName(personDto.getLastName());
        }
        if(personDto.getAge() != personEntity.getAge()){
            personEntity.setAge(personDto.getAge());
        }
        if(personDto.getGender() != null && !personDto.getGender().isEmpty() && !personEntity.getGender().equals(personDto.getGender())){
            personEntity.setGender(personDto.getGender());
        }
        if(personDto.getFavouriteColor() != null && !personDto.getFavouriteColor().isEmpty() && !personEntity.getFavouriteColor().equals(personDto.getFavouriteColor())){
            personEntity.setFavouriteColor(personDto.getFavouriteColor());
        }
        if(personDto.getHobbies() != null && !personDto.getHobbies().isEmpty()){
            personEntity.setHobbies(new JSONArray(personDto.getHobbies()).toString().getBytes());
        }
        return personEntity;
    }
}
