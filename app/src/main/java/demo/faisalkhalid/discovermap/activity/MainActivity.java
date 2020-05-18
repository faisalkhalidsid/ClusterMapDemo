package demo.faisalkhalid.discovermap.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import org.json.JSONException;

import cn.pedant.SweetAlert.SweetAlertDialog;
import demo.faisalkhalid.discovermap.R;
import demo.faisalkhalid.discovermap.model.Discover;
import demo.faisalkhalid.discovermap.model.LocationData;
import demo.faisalkhalid.discovermap.network.ApiClient;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private boolean mIsRestore;
    private ClusterManager<LocationData> mClusterManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpMap();




    }

    private void setUpMap() {
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {

        if (mMap != null) {
            return;
        }
        mMap = googleMap;
        loadMapCluster(mIsRestore);


    }


    protected void loadMapCluster(boolean isRestore) {
        if (!isRestore) {
            getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(25.2048, -55.2708), 1));
        }

        mClusterManager = new ClusterManager<>(this, getMap());

        getMap().setOnCameraIdleListener(mClusterManager);
        SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(false);
        pDialog.show();



        ApiClient.getAllDiscoverLocations(this, "501edc9e", "", new ApiClient.ResultHandler<Discover>() {
            @Override
            public void onSuccess(Discover response) {

                pDialog.dismiss();
                if (response.getError() == false){


                    LatLng lnhg = response.getLocationData().get(0).getPosition();
                    Log.d("location",lnhg.toString());
                    mClusterManager.addItems(response.getLocationData());
                    mClusterManager.cluster();


                }

                else {

                    displayError(response.getStatus());

                }

            }

            void displayError(String errorMessage){
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText(errorMessage)
                        .setConfirmText("Retry!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                loadMapCluster(isRestore);
                            }
                        })
                        .show();
            }

            @Override
            public void onFailure(Exception error) {

                pDialog.dismiss();
                displayError(error.getLocalizedMessage());

                Log.d("location", error.getLocalizedMessage());
            }

        });

    }


    protected GoogleMap getMap() {
        return mMap;
    }


}
