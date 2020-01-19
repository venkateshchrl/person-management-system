package com.demo.pms.api.impl.exceptions;

import com.demo.pms.exceptions.DuplicateRecordException;
import com.demo.pms.gen.model.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DuplicateRecordExceptionMapper implements ExceptionMapper<DuplicateRecordException> {
    @Override
    public Response toResponse(DuplicateRecordException exception) {
        return Response.status(Response.Status.CONFLICT)
                        .entity(new ErrorResponse()
                                        .code(exception.getCode())
                                        .errorMessage(exception.getMessage())
                                        .link("Link Coming Soon"))
                        .build();
    }
}
