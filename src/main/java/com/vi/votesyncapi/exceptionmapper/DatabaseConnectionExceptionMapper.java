package com.vi.votesyncapi.exceptionmapper;

import com.vi.votesyncapi.exception.DatabaseConnectionException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DatabaseConnectionExceptionMapper implements ExceptionMapper<DatabaseConnectionException> {
    @Override
    public Response toResponse(DatabaseConnectionException e) {
        return  Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(e.getMessage())
                .build();
    }
}
