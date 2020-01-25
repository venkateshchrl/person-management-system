package com.demo.pms.api.impl;


import com.demo.pms.api.mappers.PersonDTOMappingService;
import com.demo.pms.constants.Codes;
import com.demo.pms.dto.PersonDTO;
import com.demo.pms.gen.api.NotFoundException;
import com.demo.pms.gen.api.PersonsApi;
import com.demo.pms.gen.model.APIResponseResult;
import com.demo.pms.gen.model.ModelAPIResponse;
import com.demo.pms.gen.model.Person;
import com.demo.pms.person.controllers.*;
import com.demo.pms.pojos.PersonPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-01-19T07:43:12.012Z[GMT]")public class PersonsApiServiceImpl implements PersonsApi {
    @Autowired
    private PersonCreateController personCreateController;
    @Autowired
    private PersonUpdateController personUpdateController;
    @Autowired
    private PersonListController personListController;
    @Autowired
    private PersonDetailsController personDetailsController;
    @Autowired
    private PersonDeleteController personDeleteController;
    @Autowired
    private PersonDTOMappingService personDTOMappingService;

    public PersonsApiServiceImpl(){
        super();
    }

    @Override
    public Response addPerson(Person body, SecurityContext securityContext) throws NotFoundException {
        PersonDTO personDto = personDTOMappingService.map(body);
        PersonPojo personPojo = personCreateController.createPerson(personDto);
        return Response.ok(new ModelAPIResponse()
                                .code(Codes.PERSON_ADDITION_SUCCESS_CODE)
                                .message(Codes.PERSON_ADDITION_SUCCESS_MSG)
                                .result(new APIResponseResult()
                                                .data(personPojo)))
                        .build();
    }
    @Override
    public Response deletePerson(String personid, SecurityContext securityContext) throws NotFoundException {
        List<String> personIds = personDeleteController.deletePersons(personid);
        return Response.ok(new ModelAPIResponse()
                .code(Codes.PERSON_DETAILS_DELETE_SUCCESS_CODE)
                .message(Codes.PERSON_DETAILS_DELETE_SUCCESS_MSG)
                .result(new APIResponseResult()
                        .data(personIds)))
                .build();
    }
    @Override
    public Response getPerson(String personid, SecurityContext securityContext) throws NotFoundException {
        PersonPojo personPojo = personDetailsController.fetchPersonDetails(personid);
        return Response.ok(new ModelAPIResponse()
                .code(Codes.PERSON_DETAILS_DELETE_SUCCESS_CODE)
                .message(Codes.PERSON_DETAILS_DELETE_SUCCESS_MSG)
                .result(new APIResponseResult()
                        .data(personPojo)))
                .build();
    }
    @Override
    public Response getPersons( Integer page,  Integer size,  String name, SecurityContext securityContext) throws NotFoundException {
        Pageable pageable = null;
        if(page == null || size == null){
            page = 0;
            size = 20;
        }
        pageable = PageRequest.of(page, size);
        Map<String, String> filters = new HashMap<>();
        if(name != null && !name.isEmpty())
            filters.put("name", name);
        Page<PersonPojo> personPojos = personListController.listPersons(pageable, filters);
        return Response.ok(new ModelAPIResponse()
                                .code(Codes.PERSONS_LIST_FETCH_SUCCESS_CODE)
                                .message(Codes.PERSONS_LIST_FETCH_SUCCESS_MSG)
                                .result(new APIResponseResult()
                                            .data(personPojos)))
                        .build();
    }
    @Override
    public Response updatePerson(String personid, Person body, SecurityContext securityContext) throws NotFoundException {
        PersonDTO personDto = personDTOMappingService.map(body);
        PersonPojo personPojo = personUpdateController.updatePerson(personid, personDto);
        return Response.ok(new ModelAPIResponse()
                        .code(Codes.PERSON_DETAILS_UPDATE_SUCCESS_CODE)
                        .message(Codes.PERSON_DETAILS_UPDATE_SUCCESS_MSG)
                        .result(new APIResponseResult()
                                .data(personPojo)))
                        .build();
    }
}
