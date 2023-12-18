import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get03 extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
          "completed" is false
      And
          "userId" is 2
     */

    @Test
    public void get01(){

        // Set The URL

        spec.pathParams("first","todos","second",23);

        // Set The Expected  Data (Put, Patch, Post)

        // Send the request and Get Response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
    }
}
