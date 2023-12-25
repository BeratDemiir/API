package get_request;

import base_url.RestFulBaseUrl;
import org.testng.annotations.Test;

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

        // 1. Set The Url
       spec.pathParams("first","booking");

        // 2. Set The Excepted Data

        // 3. Send The Request And Get The Response



    }
}
