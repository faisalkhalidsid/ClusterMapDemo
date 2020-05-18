package demo.faisalkhalid.discovermap.network;


import android.content.Context;
import android.util.Log;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import demo.faisalkhalid.discovermap.R;

import demo.faisalkhalid.discovermap.model.Discover;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class ApiClient {

    private static Retrofit retrofit = null;

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static synchronized Retrofit getClient(final Context context) {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()

                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(context.getString(R.string.baseApiUrl))
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    public static class NoConnectivityException extends IOException {
        @Override
        public String getLocalizedMessage() {
            return super.getLocalizedMessage();
        }

        @Override
        public String getMessage() {
            return "No Internet Connection";
        }
    }


    public static void getAllDiscoverLocations(Context context, String apiKey, String searchText, ResultHandler<Discover> handler) {
        ApiHit service = getClient(context).create(ApiHit.class);
        Call<Discover> call = service.getAllDiscoverLocations(apiKey,searchText);
        call.enqueue(new Callback<Discover>() {
            @Override
            public void onResponse(Call<Discover> call, retrofit2.Response<Discover> response) {
                if (response.isSuccessful()) {
                    try {
                        handler.onSuccess(response.body());

                    } catch (Exception e) {

                        handler.onFailure(e);

                    }

                }


            }

            @Override
            public void onFailure(Call<Discover> call, Throwable t) {

                Exception ex = new Exception(t);
                handler.onFailure(ex);

            }
        });

    }



    public interface ResultHandler<T> {
        void onSuccess(T response);

        void onFailure(Exception error);
    }

}


