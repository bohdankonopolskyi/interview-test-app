package api.player;

import api.player.pojos.requests.PlayerRequestDto;
import api.player.pojos.responses.PlayerItemResponseDto;
import api.player.pojos.responses.PlayerResponseDto;
import api.player.pojos.responses.PlayerUpdateResponseDto;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.testng.asserts.SoftAssert;

@Log4j
public class PlayerAssertion {

    @Step("Assert player")
    public static void softAssert(PlayerRequestDto expected, PlayerResponseDto actual) {
        log.info("assert Player Response");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actual.getAge(), expected.getAge(), "Age mismatch");
        softAssert.assertEquals(actual.getGender(), expected.getGender(), "Gender mismatch");
        softAssert.assertEquals(actual.getLogin(), expected.getLogin(), "Login mismatch");
        softAssert.assertEquals(actual.getPassword(), expected.getPassword(), "Password mismatch");
        softAssert.assertEquals(actual.getRole(), expected.getRole(), "Role mismatch");
        softAssert.assertEquals(actual.getScreenName(), expected.getScreenName(), "ScreenName mismatch");

        softAssert.assertAll();
    }

    @Step("Assert player")
    public static void softAssert(PlayerRequestDto expected, PlayerItemResponseDto actual) {
        log.info("assert Player Item Response");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actual.getAge(), expected.getAge(), "Age mismatch");
        softAssert.assertEquals(actual.getGender(), expected.getGender(), "Gender mismatch");
        softAssert.assertEquals(actual.getRole(), expected.getRole(), "Role mismatch");
        softAssert.assertEquals(actual.getScreenName(), expected.getScreenName(), "ScreenName mismatch");

        softAssert.assertAll();
    }

    @Step("Assert player")
    public static void softAssert(PlayerRequestDto expected, PlayerUpdateResponseDto actual) {
        log.info("assert Player Update Response");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actual.getAge(), expected.getAge(), "Age mismatch");
        softAssert.assertEquals(actual.getGender(), expected.getGender(), "Gender mismatch");
        softAssert.assertEquals(actual.getLogin(), expected.getLogin(), "Login mismatch");
        softAssert.assertEquals(actual.getRole(), expected.getRole(), "Role mismatch");
        softAssert.assertEquals(actual.getScreenName(), expected.getScreenName(), "ScreenName mismatch");

        softAssert.assertAll();
    }
}
