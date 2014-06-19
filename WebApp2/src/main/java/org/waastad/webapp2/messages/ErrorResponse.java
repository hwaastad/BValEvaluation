/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.webapp2.messages;

import java.io.Serializable;
import java.util.Date;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@XmlRootElement
public class ErrorResponse implements Serializable {
    private static final long serialVersionUID = 8888101217538645771L;

    private Long id;
    private Response.Status status;
    private String message;

    public ErrorResponse() {
        this.id = new Date().getTime();
    }

    public ErrorResponse(Response.Status status, String message) {
        this.id = new Date().getTime();
        this.status = status;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Response.Status getStatus() {
        return status;
    }

    @XmlAttribute
    public void setStatus(Response.Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    @XmlAttribute
    public void setMessage(String message) {
        this.message = message;
    }

//    @Override
//    public String toString() {
//        return "{" + "id:" + id + ", status:" + status + ", message:" + message + '}';
//    }
    @Override
    public String toString() {
        return "ErrorResponse:" + "id=" + id + ", status=" + status + ", message=" + message;
    }
}
