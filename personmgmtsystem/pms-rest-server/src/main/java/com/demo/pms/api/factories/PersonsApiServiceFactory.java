package com.demo.pms.api.factories;

import com.demo.pms.api.impl.PersonsApiServiceImpl;
import com.demo.pms.gen.api.PersonsApiService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-01-19T07:43:12.012Z[GMT]")public class PersonsApiServiceFactory {
    private final static PersonsApiService service = new PersonsApiServiceImpl();

    public static PersonsApiService getPersonsApi() {
        return service;
    }
}
