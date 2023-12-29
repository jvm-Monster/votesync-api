package com.vi.votesyncapi.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        // Get the origin from the incoming request
        String origin = requestContext.getHeaderString("Origin");

        // Check if the origin is allowed (replace "http://localhost:53520" with your Flutter app's actual origin)
       /* if ("http://localhost:58920".equals(origin)) {
            System.out.println("print success");
            responseContext.getHeaders().add("Access-Control-Allow-Origin", origin);
        } else {
            System.out.println("print failed");
            // If the origin is not allowed, respond with 403 Forbidden
            Response forbiddenResponse = Response.status(Response.Status.FORBIDDEN)
                    .entity("It is for ever forbidden you get FUCK YOU!")
                    .build();
            requestContext.abortWith(forbiddenResponse);
            return;
        }*/

        // Add other CORS headers
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        responseContext.getHeaders().add("Access-Control-Allow-Headers", "Origin, Content-Type, Accept");
        // Set Content-Type to JSON
//        responseContext.getHeaders().add("Content-Type", "application/json");
    }
}
