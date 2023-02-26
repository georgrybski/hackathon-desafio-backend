package com.stefanini.resources;

import com.stefanini.service.BatalhaService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/batalha")
@Consumes(MediaType.APPLICATION_JSON)
public class BatalhaResource {

    @Inject
    private BatalhaService batalhaService;

    @POST
    public Response batalhar() {
        return Response.status(Response.Status.OK).build();
    }
}
