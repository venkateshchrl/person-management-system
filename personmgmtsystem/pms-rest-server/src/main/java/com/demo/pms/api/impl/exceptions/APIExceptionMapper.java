package com.demo.pms.api.impl.exceptions;

import com.demo.pms.exceptions.APIException;
import com.demo.pms.gen.model.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class APIExceptionMapper implements ExceptionMapper<APIException> {
    @Override
    public Response toResponse(APIException exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ErrorResponse()
                                    .code(exception.getCode())
                                    .errorMessage(exception.getMessage())
                                    .link("Link Coming Soon"))
                        .build();
    }
}
