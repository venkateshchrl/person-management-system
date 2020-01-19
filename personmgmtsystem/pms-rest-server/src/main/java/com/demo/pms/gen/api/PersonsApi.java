package com.demo.pms.gen.api;

import com.demo.pms.api.factories.PersonsApiServiceFactory;
import com.demo.pms.gen.model.ErrorResponse;
import com.demo.pms.gen.model.ModelAPIResponse;
import com.demo.pms.gen.model.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.servlet.ServletConfig;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


@Path("/persons")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-01-19T07:43:12.012Z[GMT]")public class PersonsApi  {
   private final PersonsApiService delegate;

   public PersonsApi(@Context ServletConfig servletContext) {
      PersonsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("PersonsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (PersonsApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = PersonsApiServiceFactory.getPersonsApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Adds a person to the list", description = "", tags={ "persons" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Successful", content = @Content(schema = @Schema(implementation = ModelAPIResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Your request cannot be processed", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "405", description = "Method not allowed"),
        
        @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
        
        @ApiResponse(responseCode = "500", description = "An unexpected internal error has occured") })
    public Response addPerson(@Parameter(in = ParameterIn.DEFAULT, description = "" ) Person body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addPerson(body,securityContext);
    }
    @DELETE
    @Path("/{personid}")
    
    @Produces({ "application/json" })
    @Operation(summary = "Deletes the details of one or more persons", description = "", tags={ "persons" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = ModelAPIResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "Entity Not Found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "405", description = "Method not allowed"),
        
        @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
        
        @ApiResponse(responseCode = "500", description = "An unexpected internal error has occured") })
    public Response deletePerson(@Parameter(in = ParameterIn.PATH, description = "Id/Id's of the persons whose details to be deleted",required=true) @PathParam("personid") String personid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deletePerson(personid,securityContext);
    }
    @GET
    @Path("/{personid}")
    
    @Produces({ "application/json" })
    @Operation(summary = "Provides the details of specific person", description = "", tags={ "persons" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = ModelAPIResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Your request cannot be processed", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "Entity Not Found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "405", description = "Method not allowed"),
        
        @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
        
        @ApiResponse(responseCode = "500", description = "An unexpected internal error has occured") })
    public Response getPerson(@Parameter(in = ParameterIn.PATH, description = "Id of the person whose details to be fetched",required=true) @PathParam("personid") String personid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPerson(personid,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @Operation(summary = "Provides the collection of persons", description = "", tags={ "persons" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = ModelAPIResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Your request cannot be processed", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "405", description = "Method not allowed"),
        
        @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
        
        @ApiResponse(responseCode = "500", description = "An unexpected internal error has occured") })
    public Response getPersons(@Parameter(in = ParameterIn.QUERY, description = "Number of the page from which persons to be fetched") @QueryParam("page") Integer page
,@Parameter(in = ParameterIn.QUERY, description = "Number of the person records to be fetched") @QueryParam("size") Integer size
,@Parameter(in = ParameterIn.QUERY, description = "Value to filter the person records by firstName/lastName") @QueryParam("name") String name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPersons(page,size,name,securityContext);
    }
    @PUT
    @Path("/{personid}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Updates the details of specific person", description = "", tags={ "persons" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = ModelAPIResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Your request cannot be processed", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "Entity Not Found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "405", description = "Method not allowed"),
        
        @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
        
        @ApiResponse(responseCode = "500", description = "An unexpected internal error has occured") })
    public Response updatePerson(@Parameter(in = ParameterIn.PATH, description = "Id of the person whose details to be updated",required=true) @PathParam("personid") String personid
,@Parameter(in = ParameterIn.DEFAULT, description = "" ) Person body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updatePerson(personid,body,securityContext);
    }
}
