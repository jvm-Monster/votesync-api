package com.vi.votesyncapi.exceptionmapper;

import com.vi.votesyncapi.exception.DuplicateDataException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DuplicateDataExceptionMapper implements ExceptionMapper<DuplicateDataException> {
    @Override
    public Response toResponse(DuplicateDataException e) {
        return Response.status(Response.Status.CONFLICT)
                .entity(e.getMessage())
                .build();
    }
}
