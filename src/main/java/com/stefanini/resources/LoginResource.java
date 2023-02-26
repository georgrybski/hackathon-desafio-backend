package com.stefanini.resources;

import com.stefanini.dto.RequisicaoDeLogin;
import com.stefanini.service.LoginService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

    @Inject
    LoginService loginService;

    @POST
    public Response validarLogin(@Valid RequisicaoDeLogin requisicaoDeLogin) {
        return Response.status(Response.Status.OK).entity(loginService.validarLogin(requisicaoDeLogin)).build();
    }
}
