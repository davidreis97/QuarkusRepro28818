package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:4444")
public interface GreetingService {
    @POST
    @Path("/hello")
    @Consumes("image/gif") //Provoke 415 Unsupported Media Type
    @Produces(MediaType.TEXT_PLAIN)
    String hello(byte[] imageFile);
}
