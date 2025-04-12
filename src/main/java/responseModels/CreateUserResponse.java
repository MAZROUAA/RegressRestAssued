package responseModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserResponse {

    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
    @JsonProperty("id")
    private String id;
    @JsonProperty("createdAt")
    private String createdAt;


    @JsonProperty("name")
    public String getName() {
        return name;
    }


    @JsonProperty("job")
    public String getJob() {
        return job;
    }


    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }
}
