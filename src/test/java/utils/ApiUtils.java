package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class ApiUtils {

    public static Response getRequest(String uri, String path) {
        return RestAssured.get(uri + path);
    }

    public static String getRequest(String uri, String path, Map<String, String> header) {
        Response response = RestAssured.given().headers(header).get(uri + path);
        return response.asString();
    }

    public static String getRequestWithAllResponse(String uri, String path, Map<String, String> options) {
        Response response = RestAssured.given().headers(options).get(uri + path);
        return response.asString();
    }

    public static String getRequestWithQuery(String uri, String path, String query, Map<String, String> header) {
        Response response = RestAssured.given().headers(header).queryParam(query).get(uri + path);
        return response.asString();
    }

    public static String postRequest(String uri, String path, String body, Map<String, String> options) {
        Response response = RestAssured.given().headers(options).body(body).post(uri + path);
        return response.asString();
    }
}

