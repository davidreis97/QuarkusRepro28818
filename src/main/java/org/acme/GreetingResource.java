package org.acme;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.rest.client.GreetingService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/")
public class GreetingResource {
    @RestClient
    GreetingService greetingService;

    @POST
    @Consumes({"image/jpeg", "image/png"})
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(byte[] imageFile) {
        throw new NotAuthorizedException("");
    }

    @GET
    @Path("/sendRequest")
    @Produces(MediaType.TEXT_PLAIN)
    public String sendRequest(){
        int size = 1024 * 1024 * 5;

        byte[] buffer = new byte[size];

        //Should provoke 415 Unsupported Media Type
        greetingService.hello(buffer);
        return "OK";
    }
}