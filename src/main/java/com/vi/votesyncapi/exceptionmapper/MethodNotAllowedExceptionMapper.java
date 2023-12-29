package com.vi.votesyncapi.exceptionmapper;

import com.vi.votesyncapi.util.ResponseErrorConstructor;

import jakarta.ws.rs.NotAllowedException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.ArrayList;

@Provider
public class MethodNotAllowedExceptionMapper implements ExceptionMapper<NotAllowedException> {

    @Override
    public Response toResponse(NotAllowedException e) {


        return Response.status(Response.Status.METHOD_NOT_ALLOWED)
                .entity("A resource was made using a request method not supported by that resource;\n" +
                        "for example using GET on a request that requires data to be represented" +
                        " via POST,\nor using PUT read-only on a read-only resource ")
                .type("application/json")  // Set the response type to JSON
                .build();
    }
}
