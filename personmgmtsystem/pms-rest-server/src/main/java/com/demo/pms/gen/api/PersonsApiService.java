package com.demo.pms.gen.api;

import com.demo.pms.gen.model.Person;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-01-19T07:43:12.012Z[GMT]")public abstract class PersonsApiService {
    public abstract Response addPerson(Person body, SecurityContext securityContext) throws NotFoundException;
    public abstract Response deletePerson(String personid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPerson(String personid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPersons( Integer page, Integer size, String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updatePerson(String personid,Person body,SecurityContext securityContext) throws NotFoundException;
}
