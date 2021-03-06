/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.webapp1.service;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.waastad.webapp1.ejb.BusinessBean;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Path("test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class WebApp1Service {

    @POST
    public Response getInfo(@Pattern(regexp = "valid") String input) {
        return Response.ok().build();
    }

}
