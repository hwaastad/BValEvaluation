/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.client.WebClient;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@RunWith(Arquillian.class)
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }

    @Deployment(name = "webapp1")
    public static Archive<?> webapp1() {
        return ShrinkWrap.createFromZipFile(WebArchive.class, new File("../WebApp1/target/WebApp1-1.0-SNAPSHOT.war"));
    }

    @Deployment(name = "webapp2")
    public static Archive<?> webapp2() {
        return ShrinkWrap.createFromZipFile(WebArchive.class, new File("../WebApp2/target/WebApp2-1.0-SNAPSHOT.war"));
    }

    @Test
    public void valid1() throws IOException {
        System.out.println("");
        System.out.println("===========================================");
        System.out.println(WebClient.create("http://localhost:8080/WebApp1/test/")
                .type(MediaType.APPLICATION_JSON_TYPE).post("validd").getStatus());
        System.out.println("-------------------------------------------");
        System.out.println(WebClient.create("http://localhost:8080/WebApp2/test/")
                .type(MediaType.APPLICATION_JSON_TYPE).post("valid").getStatus());
        System.out.println("===========================================");
        System.out.println("");
    }
    
}
