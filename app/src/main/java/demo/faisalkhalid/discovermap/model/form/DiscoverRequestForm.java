package demo.faisalkhalid.discovermap.model.form;

import java.io.Serializable;

public class DiscoverRequestForm implements Serializable {

    private String apiKey;
    private String searchText;

    public DiscoverRequestForm(String apiKey, String searchText) {
        this.apiKey = apiKey;
        this.searchText = searchText;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
