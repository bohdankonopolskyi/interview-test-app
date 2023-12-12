package api.player.requests;

import api.BaseRequest;
import api.RequestDto;
import api.player.PlayerEndpoint;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;

@Log4j
public class DeletePlayerRequest extends BaseRequest {

    private String editor;

    public DeletePlayerRequest(String editor) {
        super(PlayerEndpoint.DELETE.getRawValue());
        this.editor = editor;
    }

    @Step("Delete player")
    @Override
    public Response send(RequestDto requestModel) {
        log.info("Delete player");
        return requestConfig()
                .pathParam("editor", editor)
                .body(requestModel)
                .when()
                .log().all()
                .delete();
    }
}
