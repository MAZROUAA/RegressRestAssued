package responseModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "job",
        "updatedAt"
})

public class UpdateUserResponse {

        @JsonProperty("name")
        private String name;
        @JsonProperty("job")
        private String job;
        @JsonProperty("updatedAt")
        private String updatedAt;


        @JsonProperty("name")
        public String getName() {
            return name;
        }


        @JsonProperty("job")
        public String getJob() {
            return job;
        }


        @JsonProperty("updatedAt")
        public String getUpdatedAt() {
            return updatedAt;
        }



}
