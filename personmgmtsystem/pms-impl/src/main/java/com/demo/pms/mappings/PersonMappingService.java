package com.demo.pms.mappings;

import com.demo.pms.dto.PersonDTO;
import com.demo.pms.entities.PersonEntity;
import com.demo.pms.pojos.PersonPojo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonMappingService {
    private final ModelMapper personMapper = new ModelMapper();

    public PersonMappingService(){
        this.personMapper.addMappings(personEntityPersonPojoPropertyMap);
        this.personMapper.addMappings(personPojoPersonEntityPropertyMap);
    }

    private PropertyMap<PersonEntity, PersonPojo> personEntityPersonPojoPropertyMap = new PropertyMap<PersonEntity, PersonPojo>() {
        @Override
        protected void configure() {
            using((Converter<byte[], List>) mappingContext -> mappingContext.getSource() != null ? new JSONArray(new String(mappingContext.getSource())).toList() : new ArrayList()).map(source.getHobbies(), destination.getHobbies());
        }
    };

    private PropertyMap<PersonPojo, PersonEntity> personPojoPersonEntityPropertyMap = new PropertyMap<PersonPojo, PersonEntity>() {
        @Override
        protected void configure() {
            using((Converter<List, byte[]>) mappingContext -> mappingContext.getSource() != null ? new JSONArray(mappingContext.getSource()).toString().getBytes() : null).map(source.getHobbies(), destination.getHobbies());
        }
    };

    public PersonPojo map(PersonDTO personDto){
        return this.personMapper.map(personDto, PersonPojo.class);
    }

    public PersonEntity map(PersonPojo personPojo){
        return this.personMapper.map(personPojo, PersonEntity.class);
    }

    public PersonPojo map(PersonEntity personEntity){
        return this.personMapper.map(personEntity, PersonPojo.class);
    }

    public Page<PersonPojo> map(Page<PersonEntity> personEntities){
        return this.personMapper.map(personEntities, Page.class);
    }
}
