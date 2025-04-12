package responseModels.retrieveUserRes;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "email",
        "first_name",
        "last_name",
        "avatar"
})

public class Data {


        @JsonProperty("id")
        private Integer id;
        @JsonProperty("email")
        private String email;
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("last_name")
        private String lastName;
        @JsonProperty("avatar")
        private String avatar;


        @JsonProperty("id")
        public Integer getId() {
            return id;
        }


        @JsonProperty("email")
        public String getEmail() {
            return email;
        }


        @JsonProperty("first_name")
        public String getFirstName() {
            return firstName;
        }


        @JsonProperty("last_name")
        public String getLastName() {
            return lastName;
        }

        @JsonProperty("avatar")
        public String getAvatar() {
            return avatar;
        }


    }
