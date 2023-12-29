package com.vi.votesyncapi.exceptionmapper;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {
    @Override
    public Response toResponse(BadRequestException e) {
        Response.ResponseBuilder responseBuilder = Response.status(Response.Status.BAD_REQUEST);

        // You can customize the response entity, headers, etc.
        responseBuilder.entity("Bad Request: " + e.getMessage());

        // Add any additional headers if needed
        // responseBuilder.header("custom-header", "header-value");

        return responseBuilder.build();
    }
}
