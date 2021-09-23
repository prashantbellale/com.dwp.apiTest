package com.dwp.api.testbase;

import com.dwp.api.utils.EndPoints;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UsersTestBase {

    public static Response getAllUsers() {

        Response userdata = given()
                .when()
                .get(EndPoints.Baseurl + "/users")
                .then()
                .statusCode(200)
                .extract()
                .response();
        return userdata;
    }

    public static Response getLondonUsers(String city) {

        Response userdata = given()
                .when()
                .get(EndPoints.Baseurl + "/city/" + city + "/users")
                .then()
                .statusCode(200)
                .extract()
                .response();
        return userdata;
    }

}
