
package demo.faisalkhalid.discovermap.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "image",
    "id",
    "name",
    "latitude",
    "longitude",
    "addressOne",
    "addressTwo",
    "state",
    "country",
    "userLocation",
    "companyType",
    "category",
    "newJoined"
})
public class LocationData implements Serializable, ClusterItem {

    @JsonProperty("image")
    private String image;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("addressOne")
    private String addressOne;
    @JsonProperty("addressTwo")
    private String addressTwo;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country")
    private String country;
    @JsonProperty("userLocation")
    private String userLocation;
    @JsonProperty("companyType")
    private String companyType;
    @JsonProperty("category")
    private String category;
    @JsonProperty("newJoined")
    private Boolean newJoined;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("addressOne")
    public String getAddressOne() {
        return addressOne;
    }

    @JsonProperty("addressOne")
    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    @JsonProperty("addressTwo")
    public String getAddressTwo() {
        return addressTwo;
    }

    @JsonProperty("addressTwo")
    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("userLocation")
    public String getUserLocation() {
        return userLocation;
    }

    @JsonProperty("userLocation")
    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    @JsonProperty("companyType")
    public String getCompanyType() {
        return companyType;
    }

    @JsonProperty("companyType")
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("newJoined")
    public Boolean getNewJoined() {
        return newJoined;
    }

    @JsonProperty("newJoined")
    public void setNewJoined(Boolean newJoined) {
        this.newJoined = newJoined;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @NonNull
    @Override
    public LatLng getPosition() {

        return new LatLng(Double.parseDouble(getLatitude()),Double.parseDouble(getLongitude()));

    }

    @Nullable
    @Override
    public String getTitle() {
        return getName();
    }

    @Nullable
    @Override
    public String getSnippet() {
        return getAddressOne();
    }
}
