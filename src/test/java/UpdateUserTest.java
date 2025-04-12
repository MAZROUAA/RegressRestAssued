import helpers.Helpers;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import requests.Requests;
import responseModels.CreateUserResponse;
import responseModels.UpdateUserResponse;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class UpdateUserTest {

    public static Helpers HelperObj;





    @Test(priority = 1)
    public void userUpdateTest() throws IOException {


        SoftAssert softAssert = new SoftAssert();

        try {
            //Precondition
            HelperObj = new Helpers("src/main/resources/TestsData.json");
            Response createUserResponse = Requests.createUser(HelperObj.getValue("name"), HelperObj.getValue("job"));
            CreateUserResponse createUserResponseObj = createUserResponse.as(CreateUserResponse.class);
            String userIDToUpdate=createUserResponseObj.getId();
            System.out.println(userIDToUpdate);

            //Main test
            Response updateUserResponse = Requests.updateUser(userIDToUpdate, HelperObj.getValue("nameUpdate"), HelperObj.getValue("jobUpdate"));
            System.out.println(updateUserResponse.statusCode());

            UpdateUserResponse updateUserResponseObj = updateUserResponse.as(UpdateUserResponse.class);

            System.out.println("user updated: " +
                    "Name: " + updateUserResponseObj.getName() + ", " +
                    "Job: " + updateUserResponseObj.getJob() + ", " +
                    "Updated At: " + updateUserResponseObj.getUpdatedAt());


            //Assertions
            assertEquals(updateUserResponse.statusCode(), 200, "invalid status code");
            softAssert.assertEquals(updateUserResponseObj.getName(), HelperObj.getValue("nameUpdate"));
            softAssert.assertEquals(updateUserResponseObj.getJob(), HelperObj.getValue("jobUpdate"));
            softAssert.assertNotNull(updateUserResponseObj.getUpdatedAt());
            softAssert.assertAll();
        } catch (Exception e) {
            System.out.println("Failed: " + e.getMessage());
        }
    }

}