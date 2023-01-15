package get_requests;



import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utils.JsonUtils;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

    public class Get15ObjectMapperMap extends JsonPlaceHolderBaseUrl {
        /*
          Given
             https://jsonplaceholder.typicode.com/todos/198
          When
           I send GET Request to the URL
        Then
           Status code is 200
           And response body is like {
                                 "userId": 10,
                                          "id":198,
                                 "title": "quis eius est sint explicabo",
                                 "completed": true
                               }
       */
        @Test
        public void get15(){
            //Set the url
            spec.pathParams("first","todos","second",198);


            //Set the expected data
    /*
         String expectedDataInString ="{\n" +
                                    "    \"userId\": 10,\n" +
                                    "    \"title\": \"quis eius est sint explicabo\",\n" + ==> Not Recommended
                                    "    \"completed\": true\n" +
                                    "  }";
                                    */

            String expectedDataInString = new JsonPlaceHolderTestData().expectedDataInString(10,"quis eius est sint explicabo",true);
            Map<String,Object> expectedData = JsonUtils.convertJsonToJavaObject(expectedDataInString, HashMap.class);
            System.out.println("expectedData = " + expectedData);

            //Send the request and get the response
            Response response = given().spec(spec).when().get("/{first}/{second}");
            response.prettyPrint();

            //Do assertion
            Map<String,Object> actualData = JsonUtils.convertJsonToJavaObject(response.asString(), HashMap.class);
            System.out.println("actualData = " + actualData);

            assertEquals(200,response.statusCode());
            assertEquals(expectedData.get("userId"),actualData.get("userId"));
            assertEquals(expectedData.get("title"),actualData.get("title"));
            assertEquals(expectedData.get("completed"),actualData.get("completed"));

        }
    }


