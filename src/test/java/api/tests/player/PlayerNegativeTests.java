package api.tests.player;

import api.player.pojos.requests.PlayerGetByIdRequestDto;
import api.player.pojos.requests.PlayerRequestDto;
import api.player.requests.CreatePlayerRequest;
import api.player.requests.GetPlayerByIdRequest;
import io.qameta.allure.Step;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlayerNegativeTests extends BasePlayerTest {
    @Step("Get non existent player")
    @Test
    public void getNonExistentPlayerById() {
        PlayerGetByIdRequestDto playerGetByIdRequestDto = PlayerGetByIdRequestDto.builder().playerId(999999999).build();

        new GetPlayerByIdRequest().send(playerGetByIdRequestDto)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Step("Create with invalid age")
    @Test(dataProvider = "invalidAgeValues")
    public void createPlayerWithInvalidAge(int invalidAge) {
        PlayerRequestDto playerRequestDto = PlayerRequestDto.builder().age(invalidAge).build();
        var supervisor = getSupervisor();
        new CreatePlayerRequest(supervisor.getLogin())
                .send(playerRequestDto)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @DataProvider(name = "invalidAgeValues")
    public Object[][] invalidAgeValues() {
        return new Object[][]{
                {-1},
                {0},
                {15},
                {61}
        };
    }
}
