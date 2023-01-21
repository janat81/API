package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
1) Postman is used for manual API testing.
2) We use Rest-Assured Library for API Automation Testing.
3) To type automation script follow the given steps:
    a) Understand the requirement
    b) Type test cases
        To type test cases We use 'Gherkin Language'
        The keywords are    x) Given: It is for pre-conditions
                            y) When: It is for actions
                            z) Then: It is for outputs
                            t) And: It is for multiple given, when and then.
    c) Start to type Automation Script
        i) Set the URL
        ii) Set the expected Data(Post-Put-Patch)
        iii) Type code to send the Request
        iv) Do Assertion
 */

     /*
   Given
       https://restful-booker.herokuapp.com/booking/10
   When
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be JSON
   And
       Status Line should be HTTP/1.1 200 OK
*/

    @Test
    public void get01(){
      //Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/10";

      //Set the expected data

     //Send the request and get the response
        Response response= given().when().get(url);
        response.prettyPrint();

        //Do Assertion

       // HTTP Status Code should be 200
       // Content Type should be JSON
       // Status Line should be HTTP/1.1 200 OK
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // How to print Status Code on the console
        System.out.println("Status code: "+response.statusCode());

        //How to print "Content Type" on the console

        System.out.println("Content Type:"+response.contentType());

        //How to print statusLine on the console
        System.out.println("Status Line: "+response.statusLine());

        //How to print "Header"
        System.out.println(response.getHeader("Server"));

        //How to print
        System.out.println(response.getHeaders());

        //How to print time
        System.out.println(response.getTime());


    }
}
