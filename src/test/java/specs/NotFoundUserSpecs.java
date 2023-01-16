package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class NotFoundUserSpecs {
    public static RequestSpecification notFoundUserRequestSpec = with()
            .baseUri("https://reqres.in")
            .basePath("/api/users")
            .log().all();

    public static ResponseSpecification notFoundUserResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(404) // Not Found
            .build();
}
