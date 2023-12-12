package api.utils;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class Mapper {
    @Step("Mapping")
    public static <T> T mapToClass(Response response, Class<T> targetClass) {
        log.info("mapping to class " + targetClass.getName());
        return response.as(targetClass);
    }

    @Step("Mapping list")
    public static <T> List<T> mapToList(Response response, String path, Class<T> targetClass) {
        log.info("mapping list  " + targetClass.getName());
        return response.jsonPath().getList(path, targetClass);
    }
}
