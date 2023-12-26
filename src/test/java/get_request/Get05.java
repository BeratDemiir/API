package get_request;

import base_url.RestFulBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class Get05 extends RestFulBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "Johhny" and lastname is "Dear"
     */

    @Test
    public void get01(){

        // https://restful-booker.herokuapp.com/booking?firstname=Berat&lastname=Demir
        // 1. Set The Url
       spec.pathParams("first","booking").queryParams("firstname","Berat","lastname","Demir");

        // 2. Set The Excepted Data

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // 4. Do Assertion
        assertEquals(200,response.getStatusCode());
        assertTrue(response.asString().contains("bookingid"));

    }
}
