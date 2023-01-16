package tests;

import models.UserCreationModel;
import models.UserCreationResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.is;
import static specs.CreateUserNegativeSpecs.createUserNegativeRequestSpec;
import static specs.CreateUserNegativeSpecs.createUserNegativeResponseSpec;
import static specs.CreateUserSpecs.createUserRequestSpec;
import static specs.CreateUserSpecs.createUserResponseSpec;
import static specs.DeleteUserSpecs.deleteUserRequestSpec;
import static specs.DeleteUserSpecs.deleteUserResponseSpec;
import static specs.GetUserSpecs.getUserRequestSpec;
import static specs.GetUserSpecs.getUserResponseSpec;
import static specs.NotFoundUserSpecs.notFoundUserRequestSpec;
import static specs.NotFoundUserSpecs.notFoundUserResponseSpec;

public class RestTests {
    @Test
    @DisplayName("Get an user by id number")
    void getSingleUser() {
        given()
                .spec(getUserRequestSpec)
                .when()
                .get("/2")
                .then()
                .spec(getUserResponseSpec)
                .body("data.first_name", is("Janet"))
                .body("data.last_name", is("Weaver"));
    }

    @Test
    @DisplayName("User not found by not existed id number")
    void notFoundUser() {
        given()
                .spec(notFoundUserRequestSpec)
                .when()
                .get("/278127")
                .then()
                .spec(notFoundUserResponseSpec);
    }

    @Test
    @DisplayName("Check that user is created with correct data")
    void createUser() {
        UserCreationModel userModel = new UserCreationModel();
        userModel.setJob("leader");
        userModel.setName("morpheus");

        UserCreationResponseModel responseModel = given()
                .spec(createUserRequestSpec)
                .body(userModel)
                .when()
                .post()
                .then()
                .spec(createUserResponseSpec)
                .extract().as(UserCreationResponseModel.class);

        assertThat(responseModel.getJob()).isEqualTo("leader");
        assertThat(responseModel.getName()).isEqualTo("morpheus");
    }

    @Test
    @DisplayName("Check unsuccessful user creation")
    void createUserNegative() {
        given()
                .spec(createUserNegativeRequestSpec)
                .when()
                .post()
                .then()
                .spec(createUserNegativeResponseSpec);
    }

    @Test
    @DisplayName("Delete an user by id number")
    void deleteUser() {
        given()
                .spec(deleteUserRequestSpec)
                .when()
                .delete("/2")
                .then()
                .spec(deleteUserResponseSpec);
    }
}
