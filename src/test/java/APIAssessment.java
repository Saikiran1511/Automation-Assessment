import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class APIAssessment {

    @Test
    public void verifySkinColor(){
        RestAssured.baseURI = "https://swapi.dev/api/people";
        RequestSpecification request = RestAssured.given();
        Response response = request.request(Method.GET);

        if (response.getStatusCode() == 200) {
            JsonPath path = response.jsonPath();
            String skinColor = path.getString("results.find{n -> n.name == 'R2-D2'}.skin_color");
            Assert.assertEquals(skinColor, "white, blue");

        }
    }
}
