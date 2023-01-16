package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.notNullValue;

public class GetUserSpecs {
    public static RequestSpecification getUserRequestSpec = with()
            .baseUri("https://reqres.in")
            .basePath("/api/users")
            .log().all();

    public static ResponseSpecification getUserResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("data.first_name", notNullValue())
            .build();
}
