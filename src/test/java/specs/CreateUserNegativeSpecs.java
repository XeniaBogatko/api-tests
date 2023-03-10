package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class CreateUserNegativeSpecs {
    public static RequestSpecification createUserNegativeRequestSpec = with()
            .baseUri("https://reqres.in")
            .basePath("/api/users")
            .log().all();

    public static ResponseSpecification createUserNegativeResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(415) // Unsupported Media Type
            .build();
}
