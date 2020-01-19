package com.demo.pms.api.impl.exceptions;

import com.demo.pms.exceptions.RecordNotFoundException;
import com.demo.pms.gen.model.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RecordNotFoundExceptionMapper implements ExceptionMapper<RecordNotFoundException> {
    @Override
    public Response toResponse(RecordNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ErrorResponse()
                                    .code(exception.getCode())
                                    .errorMessage(exception.getMessage())
                                    .link("Link Comming Soon"))
                        .build();
    }
}
