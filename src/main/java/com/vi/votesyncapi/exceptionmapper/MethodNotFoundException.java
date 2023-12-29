package com.vi.votesyncapi.exceptionmapper;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MethodNotFoundException implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {
        return Response.status(exception.getResponse().getStatus())
                .entity("The requested resource is not found. Please check the resource URI and try again. \nIf the issue persists, the resource may become available in the future. \nSubsequent requests are permissible.")
                .build();
    }
}
