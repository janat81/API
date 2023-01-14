package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class Get02 {

    /*
   Given
       https://restful-booker.herokuapp.com/booking/1
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "TechProEd"
   And
       Server is "Cowboy"
*/

    @Test
    public void get02(){
  //Set
        String url = " https://reqres.in/api/users/23";

        //Set the expected data

        // Send the request and get the response
        Response response= given().when().get(url);
        response.prettyPrint();


        response.then().
                assertThat().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");


       // assertTrue( response.asString().contains("Not Found"));

   //Response body does not contain "

        assertFalse(response.asString().contains("TechProEd"));

        // Server is "Cowboy"
        //assertEquals(x,y)
        assertEquals("cloudflare",response.getHeader("Server"));
    }

}
