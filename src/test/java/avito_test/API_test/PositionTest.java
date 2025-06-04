package avito_test.API_test;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.baseurl.BaseUrl;
import org.example.orders.IngredientData;
import org.example.orders.OrdersHttp;
import org.example.user.UserData;
import org.example.user.UserHttp;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class PositionTest {
    private final OrdersHttp ordersHttp = new OrdersHttp(BaseUrl.BASE_URL);
    private final UserHttp userHttp = new UserHttp(BaseUrl.BASE_URL);

    String email = "email@" + RandomStringUtils.randomAlphabetic(6) + ".ru";
    String password = "password";
    String name = "name";

    @Test
    @Description("Получение заказа с авторизацией")
    public void testOrderhUser() {
        UserData request = new UserData(email, password, name);
        ValidatableResponse responseCreate = userHttp.createUser(request);
        ValidatableResponse responseAuth = userHttp.authUser(request);
        String responseBody = responseAuth.extract().body().asString(); // Получаем тело ответа в виде строки
        String token = JsonPath.from(responseBody).get("accessToken");
        token = token.replace("Bearer", "").trim();
        ValidatableResponse responseOrder = ordersHttp.getOrders(email, password, name, token);
        responseOrder.assertThat()
                .body("success", equalTo(true))
                .body("totalToday", not(empty()))
                .body("total", not(empty()));
    }

}
