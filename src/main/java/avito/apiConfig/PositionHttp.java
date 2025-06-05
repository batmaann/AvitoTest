package avito.apiConfig;

import avito.BaseHttp;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static avito.baseurl.BaseUrl.*;

public class PositionHttp extends BaseHttp {
    private final String url;

    public PositionHttp(String baseurl) {
        super();
        url = baseurl;
    }

    @Step("Определение позиции POST")
    public ValidatableResponse definitionPosition(PositionData positionData) {
        return doPostRequest(url + POSITION_URL, positionData);

    }

}
