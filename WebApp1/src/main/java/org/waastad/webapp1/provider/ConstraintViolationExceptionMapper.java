/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.webapp1.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.waastad.webapp1.messages.ErrorList;
import org.waastad.webapp1.messages.ErrorResponse;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Context
    private HttpHeaders headers;

    @Override
    public Response toResponse(ConstraintViolationException t) {
        MediaType type = headers.getMediaType();
        Locale locale = headers.getLanguage();

        Object responsObject = getConstraintViolationErrors(t);
        return Response.status(Response.Status.NOT_ACCEPTABLE).type(type).language(locale).entity(responsObject).build();
    }

    private static Object getConstraintViolationErrors(ConstraintViolationException ex) {
        List<ErrorResponse> errors = new ArrayList<>();
        for (ConstraintViolation violation : ex.getConstraintViolations()) {
            ErrorResponse error = new ErrorResponse();
            error.setMessage(violation.getMessage());
            errors.add(error);
        }
        return new ErrorList<>(errors);
    }

}
