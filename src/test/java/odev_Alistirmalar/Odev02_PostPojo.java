package odev_Alistirmalar;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqresPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Odev02_PostPojo extends ReqresBaseUrl {

    //2:  Map ve Pojo Class ile ayrı ayrı yapınız.
           /*
                   Given
                       1) https://reqres.in/api/users
                       2) {
                           "name": "morpheus",
                           "job": "leader"
                           }
                   When
                       I send POST Request to the Url
                   Then
                       Status code is 201
                       And response body should be like
                                         {
                                           "name": "morpheus",
                                           "job": "leader",
                                           "id": "496",
                                           "createdAt": "2022-10-04T15:18:56.372Z"
                                         }
           */

    //set the Url
    //Set the Expected Data
    //send tehe request and Get the Response
    //Do assert

    @Test
    public void test01() {

        //set the Url
        spec.pathParams("first", "users");

        //Set the Expected Data
        ReqresPojo expectedData =new ReqresPojo("morpheus","leader");
        System.out.println("expectedData = " + expectedData);

        //send tehe request and Get the Response
       Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
       response.prettyPrint();

        //Do assert
        ReqresPojo actualData = response.as(ReqresPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getJob(),actualData.getJob());

    }
}