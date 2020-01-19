package com.demo.pms.api.mappers;

import com.demo.pms.dto.PersonDTO;
import com.demo.pms.gen.model.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonDTOMappingService {
    private final ModelMapper personMapper = new ModelMapper();

    public PersonDTO map(Person person){
        return this.personMapper.map(person, PersonDTO.class);
    }
}
