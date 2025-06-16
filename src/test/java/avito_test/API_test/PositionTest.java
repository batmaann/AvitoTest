package avito_test.API_test;

import avito.apiConfig.PositionData;
import avito.apiConfig.PositionHttp;
import avito.baseurl.BaseUrl;
import io.restassured.RestAssured;
import jdk.jfr.Description;
import org.junit.Test;
import io.restassured.response.ValidatableResponse;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class PositionTest {
    // int status = 200;
    private final PositionHttp positionHttp = new PositionHttp(BaseUrl.BASE_URL);

    private final String addressId;
    private final int zoom;
    private final String esid;
    private final String params;
    private final String itemId;
    private final double latitude;
    private final double longitude;
    private final boolean getAddress;
    private final int status;

    public PositionTest(String addressId, int zoom, String esid, String params, String itemId, double latitude, double longitude, boolean getAddress, int status) {
        this.addressId = addressId;
        this.zoom = zoom;
        this.esid = esid;
        this.params = params;
        this.itemId = itemId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.getAddress = getAddress;
        this.status = status;
    }

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][]{
                {"", 16, null, null, null, 59.938784, 30.314997, true, 200},
                {"", 16, null, null, null, 55.755814, 37.617635, true, 200},
                {"", 16, null, null, null, 43.585525, 39.723062, true, 200},
                {"", 16, null, null, null, 56.326887, 44.005986, true, 200},
                {"", 16, null, null, null, 51.768199, 55.096955, true, 200},
                {"", 16, null, null, null, 44.208799, 43.13834, true, 200}
        };
    }

    @Test
    @Description("")
    public void testGeoposition() {
        PositionData request = new PositionData(addressId, zoom, esid, params, itemId, latitude, longitude, getAddress);
        ValidatableResponse response = positionHttp.definitionPosition(request);
        assertThat(response.extract().statusCode(), equalTo(status));
        RestAssured.given().log().all();
    }
}