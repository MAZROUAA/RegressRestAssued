import helpers.Helpers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import requests.Requests;
import responseModels.CreateUserResponse;
import responseModels.retrieveUserRes.RetrieveUserResponse;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class RetrieveUserTest {

    public static Helpers HelperObj;


    @Test(priority = 1)
    public void userRetrievalTest() throws IOException {
        SoftAssert softAssert = new SoftAssert();

        try {
            //preconditon
            HelperObj = new Helpers("src/main/resources/TestsData.json");
            Response createUserResponse = Requests.createUser(HelperObj.getValue("name"), HelperObj.getValue("job"));
            CreateUserResponse createUserResponseObj = createUserResponse.as(CreateUserResponse.class);
            String userIDToRetrieve=createUserResponseObj.getId();
            System.out.println(createUserResponse.statusCode());
            System.out.println(userIDToRetrieve);


            //Main test
            Response retrieveUserResponse = Requests.retrieveUser(userIDToRetrieve);
            System.out.println(retrieveUserResponse.statusCode());

            RetrieveUserResponse retrieveUserResponseObj = retrieveUserResponse.as(RetrieveUserResponse.class);




            //Assertions
            assertEquals(retrieveUserResponse.statusCode(), 200, "Invalid status code : User Not retrieved");
            softAssert.assertEquals(retrieveUserResponseObj.getData().getId(),userIDToRetrieve);
            softAssert.assertEquals(retrieveUserResponseObj.getData().getFirstName(),HelperObj.getValue("name"));
            softAssert.assertNotNull(retrieveUserResponseObj.getData().getLastName());
            softAssert.assertNotNull(retrieveUserResponseObj.getData().getEmail());
            softAssert.assertNotNull(retrieveUserResponseObj.getData().getAvatar());
            softAssert.assertNotNull(retrieveUserResponseObj.getSupport().getText());
            softAssert.assertNotNull(retrieveUserResponseObj.getSupport().getUrl());

            softAssert.assertAll();


            System.out.println(
                    "user requested: " +
                            "Id: " + retrieveUserResponseObj.getData().getId() + ", " +
                            "Email: " + retrieveUserResponseObj.getData().getEmail() + ", " +
                            "First Name: " + retrieveUserResponseObj.getData().getFirstName() + ", " +
                            "Last Name: " + retrieveUserResponseObj.getData().getLastName() + ", " +
                            "Avatar: " + retrieveUserResponseObj.getData().getAvatar() + ", " +
                            "Support URL: " + retrieveUserResponseObj.getSupport().getUrl() + ", " +
                            "Support Text: " + retrieveUserResponseObj.getSupport().getText()
            );
        }catch(Exception e){
            System.out.println("Failed: " + e.getMessage());
        }


    }

}
