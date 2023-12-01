package org.example.webapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.time.LocalDate;

@Path("/")
public class AppEndpoint {

    @GET
    @Path("/ping")
    @Produces("text/plain")
    public String pong() {
        return String.format("PONG: %s\n", LocalDate.now().toString());
    }
}