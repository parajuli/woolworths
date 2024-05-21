package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData {
    @JsonProperty("SearchCount")
    private SearchCount searchCount;

    // Getters and Setters
    public SearchCount getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(SearchCount searchCount) {
        this.searchCount = searchCount;
    }
}