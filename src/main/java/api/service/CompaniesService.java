package api.service;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static web.helpers.UserPropertiesReader.BASE_URL_DEPOSIT_API;

public class CompaniesService {

    public String getTokenOfCompany(String emailCompany, String passwordCompany) {
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
        return JsonPath.from(jsonString).get("token");
    }

    public String checkOneFilters(String emailCompany, String passwordCompany, String filters1, String valueFilters1, String responseValue) {
        Response response = given()
                .baseUri(BASE_URL_DEPOSIT_API)
                .header("Authorization", "Bearer " + getTokenOfCompany(emailCompany, passwordCompany))
                .contentType(ContentType.JSON)
                .queryParam(filters1, valueFilters1)
                .when()
                .get("company/filter-drivers")
                .then()
                .statusCode(200)
                .extract().response();
        response.prettyPrint();
        String jsonString = response.getBody().asString();
        return (JsonPath.from(jsonString).get(responseValue)).toString();
    }

    public String checkThreeFilters(String emailCompany, String passwordCompany, String filters1, String valueFilters1, String filters2, String valueFilters2, String filters3, String valueFilters3, String responseValue) {
        Response response = given()
                .log().all()
                .baseUri(BASE_URL_DEPOSIT_API)
                .header("Authorization", "Bearer " + getTokenOfCompany(emailCompany, passwordCompany))
                .contentType(ContentType.JSON)
                .queryParam(filters1, valueFilters1)
                .queryParam(filters2, valueFilters2)
                .queryParam(filters3, valueFilters3)
                .when()
                .get("company/filter-drivers")
                .then()
                .statusCode(200)
                .extract().response();
        response.prettyPrint();
        String jsonString = response.getBody().asString();
        return (JsonPath.from(jsonString).get(responseValue)).toString();
    }

}
