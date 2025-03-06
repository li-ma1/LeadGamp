package api.service;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static web.helpers.UserPropertiesReader.BASE_URL_DEPOSIT_API;


public class CompaniesService {

    public void getTokenOfCompany(String emailCompany, String passwordCompany) {
        Response response = given()
                .baseUri(BASE_URL_DEPOSIT_API)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"email\": \"" + emailCompany + "\",\n" +
                        "  \"password\": \"" + passwordCompany + "\"\n" +
                        "}")
                .when()
                .post("companies/login")
                .then()
                .statusCode(200)
                .extract().response();
        response.prettyPrint();
        String jsonString = response.getBody().asString();
        String tokenCompany = JsonPath.from(jsonString).get("token");
        System.out.println(tokenCompany);
    }


}
