package responseModels.retrieveUserRes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "text"
})

public class Support {


        @JsonProperty("url")
        private String url;
        @JsonProperty("text")
        private String text;


        @JsonProperty("url")
        public String getUrl() {
            return url;
        }


        @JsonProperty("text")
        public String getText() {
            return text;
        }

    }
