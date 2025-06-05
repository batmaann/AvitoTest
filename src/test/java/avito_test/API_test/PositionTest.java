package avito_test.API_test;

import avito.apiConfig.PositionData;
import avito.apiConfig.PositionHttp;
import avito.baseurl.BaseUrl;
import io.restassured.RestAssured;
import jdk.jfr.Description;
import org.junit.Test;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PositionTest {
    int status = 400;
    private final PositionHttp positionHttp = new PositionHttp(BaseUrl.BASE_URL);

    @Test
    @Description("")
    public void testGeoposition() {
        PositionData request = new PositionData("", 4.5, 5.0);
        ValidatableResponse response = positionHttp.definitionPosition(request);
        assertThat(response.extract().statusCode(), equalTo(status));
        RestAssured.given().log().all();
    }
}