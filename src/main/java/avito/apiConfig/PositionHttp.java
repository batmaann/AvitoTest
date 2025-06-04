package avito.apiConfig;

import avito.BaseHttp;
import avito.baseurl.BaseUrl;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;


public class PositionHttp extends BaseHttp {
    private final String url;

    public PositionHttp(String baseurl) {
        super();
        url = baseurl;
    }
    @Step("Определение позиции")
    public ValidatableResponse definitionPosition(PositionData positionData) {
        return doPostRequest(url  , positionData);

    }

}
