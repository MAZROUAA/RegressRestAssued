import helpers.Helpers;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import requests.Requests;
import responseModels.CreateUserResponse;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class CreateUserTest {
    public static Helpers HelperObj;


    @Test(priority = 1)
    public void userCreationTest() throws IOException {
        SoftAssert softAssert = new SoftAssert();

        try {
            //Main test
            HelperObj = new Helpers("src/main/resources/TestsData.json");

            Response createUserResponse = Requests.createUser(HelperObj.getValue("name"), HelperObj.getValue("job"));
            System.out.println(createUserResponse.statusCode());

            CreateUserResponse createUserResponseObj = createUserResponse.as(CreateUserResponse.class);

            System.out.println("user created: " +
                    "Id: " + createUserResponseObj.getId() + ", " +
                    "Name: " + createUserResponseObj.getName() + ", " +
                    "Job: " + createUserResponseObj.getJob() + ", " +
                    "Created At: " + createUserResponseObj.getCreatedAt());



            //Assertions
            assertEquals(createUserResponse.statusCode(), 201, "invalid status code");
            softAssert.assertEquals(createUserResponseObj.getName(), HelperObj.getValue("name"));
            softAssert.assertEquals(createUserResponseObj.getJob(), HelperObj.getValue("job"));
            softAssert.assertNotNull(createUserResponseObj.getId());
            softAssert.assertNotNull(createUserResponseObj.getCreatedAt());
            softAssert.assertAll();
        }catch(Exception e){
            System.out.println("Failed: " + e.getMessage());
        }


    }

}
