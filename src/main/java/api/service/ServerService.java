package api.service;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static web.helpers.UserPropertiesReader.API_TOKEN;
import static web.helpers.UserPropertiesReader.BASE_URL_DEPOSIT_API;


public class ServerService {

    private static Integer idOfRelation;

    public void getIdOfRelation(String idCompany, String idDriver) {
        Response response = given()
                .header("Authorization", "Bearer " + API_TOKEN)
                .baseUri(BASE_URL_DEPOSIT_API)
                .when()
                .get("driver-to-company-status-relations?filters[company][id]=" + idCompany + "&filters[driver][id]=" + idDriver + "")
                .then()
                .statusCode(200)
                .extract().response();
        response.prettyPrint();
        String jsonString = response.getBody().asString();
        idOfRelation = JsonPath.from(jsonString).get("data[0].id");
    }

    public void deleteOfRelation() {
        Response response = given()
                .header("Authorization", "Bearer " + API_TOKEN)
                .baseUri(BASE_URL_DEPOSIT_API)
                .when()
                .delete("driver-to-company-status-relations/" + idOfRelation)
                .then()
                .statusCode(200)
                .extract().response();
        response.prettyPrint();
    }
}
