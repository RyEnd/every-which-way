package com.javaeeeee.dwstart.resources;

import com.ryanmolnar.DWGettingStarted.resources.HelloResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static junit.framework.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;

/**
 *
 * @author ryan
 */
public class HelloResourceTest {

    @Rule
    public ResourceTestRule resource = ResourceTestRule.builder()
            .addResource(new HelloResource()).build();

    @Test
    public void testGetGreeting() {
        String expected = "Hello world!";
        //Obtain client from @Rule.
        Client client = resource.client();
        //Get WebTarget from client using URI of root resource.
        WebTarget helloTarget = client.target("http://localhost:8080/hello");
        //To invoke response we use Invocation.Builder
        //and specify the media type of representation asked from resource.
        Invocation.Builder builder = helloTarget.request(MediaType.TEXT_PLAIN);
        //Obtain response.
        Response response = builder.get();

        //Do assertions.
        assertEquals(Response.Status.OK, response.getStatusInfo());
        String actual = response.readEntity(String.class);
        assertEquals(expected, actual);
        
        /**
         * OR 
         *
        
        actual = resource.client()
                .target("http://localhost:8080/hello")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertEquals(expected, actual);
        
         * 
         * even covers response status errors because .get returns errors if outside 2XX
         */
    }
    
    @Test
    public void testGetNamedGreeting() {
      String expected = "Hello Ryan";
      
      String actual = resource.client()
                       .target("http://localhost:8080/hello/path_param/Ryan")
                       .request(MediaType.TEXT_PLAIN)
                       .get(String.class);
      
      assertEquals(expected, actual);
    }
    
    @Test
    public void testGetNamedGreetingWithParam() {
      String expected = "Hello Ryan";
      String name = "Ryan";
      
      String actual = resource.client()
                              .target("http://localhost:8080/hello/query_param")
                              .queryParam("name", name)
                              .request(MediaType.TEXT_PLAIN)
                              .get(String.class);
      
      assertEquals(expected, actual);
    }
    
    @Test
    public void testGetJSONGreeting() {
      String expected = "{\"greeting\":\"Hello world!\"}";

      String actual = resource.client()
                                  .target("http://localhost:8080/hello/hello_json")
                                  .request(MediaType.APPLICATION_JSON)
                                  .get(String.class);
      
      assertEquals(expected, actual);
      
    }
}