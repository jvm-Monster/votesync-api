package com.vi.votesyncapi.exceptionmapper;

import com.vi.votesyncapi.exception.DatabaseConnectionException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.ServerErrorException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class InternalServerExceptionMapper implements ExceptionMapper<ServerErrorException> {
    @Override
    public Response toResponse(ServerErrorException e) {
        String errorMessage = "An Internal Server Error occurred.";
        String details = "Please check to be sure you are requesting the right resource, or the issue might be on our end.";

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(formatErrorResponse(errorMessage, details))
                .build();
    }

    private String formatErrorResponse(String errorMessage, String details) {
        return String.format("{\"error\": \"%s\", \"details\": \"%s\"}", errorMessage, details);
    }
}
