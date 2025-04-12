package requests;

import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import helpers.Helpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import requestModels.CreateUserRequestModel;
import requestModels.UpdateUserRequestModel;

import java.io.IOException;

public class Requests  {








    public static Response createUser(String name, String job) throws IOException {
        Helpers HelperObj = new Helpers("src/main/resources/config.json");

        CreateUserRequestModel createUserReqModel=new CreateUserRequestModel();
        createUserReqModel.setName(name);
        createUserReqModel.setJob(job);



        Response createUserRes = RestAssured.given().log().all().contentType("application/json")
                .body(createUserReqModel).post(HelperObj.getValue("baseUrl")+HelperObj.getValue("crateUserEndPoint"));


        System.out.println(HelperObj.getValue("baseUrl")+HelperObj.getValue("crateUserEndPoint"));

        return createUserRes;

    }

    public static Response retrieveUser(String id) throws IOException {

        Helpers HelperObj = new Helpers("src/main/resources/config.json");


        Response retrieveUserRes = RestAssured.given().log().all().contentType("application/json")
                .get(HelperObj.getValue("baseUrl")+HelperObj.getValue("retrieveUserEndPoint").replace("id",id));

        System.out.println(HelperObj.getValue("baseUrl")+HelperObj.getValue("retrieveUserEndPoint").replace("id",id));

        return retrieveUserRes;

    }

    public static Response updateUser(String id,String name, String job) throws IOException {
        Helpers HelperObj = new Helpers("src/main/resources/config.json");

        UpdateUserRequestModel updateUserRequestModel= new UpdateUserRequestModel();
        updateUserRequestModel.setName(name);
        updateUserRequestModel.setJob(job);

        Response updateUserRes = RestAssured.given().log().all().contentType("application/json").body(updateUserRequestModel)
                .put(HelperObj.getValue("baseUrl")+HelperObj.getValue("updateUserEndPoint").replace("id",id));

        return updateUserRes;

    }



}
