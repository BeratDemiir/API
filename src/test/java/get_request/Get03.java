package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class Get03 extends JsonplaceholderBaseUrl {

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
    public void get01() {

        //i) Set the URL
        spec.pathParams("first", "todos", "second", 23);

        //ii)set the  expected Data post put patch
        //Bizden Post ,Put ,Patch istenmdigi icin bu case de kullanmayacagiz

        //iii) send the request and Get Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        //1.YOL (Hard Assert)
        response.then().assertThat().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo(false)).
                body("userId", equalTo(2));

        /*
         Soft assert testi gerçekleştirir ve assert başarısız olursa hata fırlatma gerçekleştirmez.
         Hard assert anında hata fırlatır, sonrasında test işlemine devam eder
        */

        //2.YOL (Soft Assert) sadece badi icerisinde gecerli
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false),
                        "userId", equalTo(2));
    }
}