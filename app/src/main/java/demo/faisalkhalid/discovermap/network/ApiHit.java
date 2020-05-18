package demo.faisalkhalid.discovermap.network;

import com.fasterxml.jackson.databind.JsonNode;

import demo.faisalkhalid.discovermap.model.Discover;
import demo.faisalkhalid.discovermap.model.form.DiscoverRequestForm;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiHit {




    @FormUrlEncoded

    @POST("msDiscoverPage")
    Call<Discover> getAllDiscoverLocations(@Field("apiKey") String apiKey, @Field("searchText") String searchText);






}


