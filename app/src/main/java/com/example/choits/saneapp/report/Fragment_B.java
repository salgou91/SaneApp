package com.example.choits.saneapp.report;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.model.*;
import com.google.android.gms.common.api.GoogleApiClient;
import android.support.v4.app.FragmentTransaction;
import com.google.android.gms.location.places.Places;

import com.example.choits.saneapp.R;

/**
 * Created by choits on 2015. 11. 13..
 */
public class Fragment_B extends Fragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private SupportMapFragment fragment;
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private Context mContext;

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static final Fragment_B newInstance(String message)
    {
        Fragment_B f = new Fragment_B();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.rep2, container, false);

/*        mGoogleApiClient = new GoogleApiClient.Builder(mContext)
                .enableAutoManage(getActivity(), 0, this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();*/

        return v;
    }

    @Override
    public void onStart(){
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    public void onStop(){
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    private void initilizeMap()
    {
        fragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.signMap);
        if (fragment == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragment = SupportMapFragment.newInstance();
            fragmentTransaction.replace(R.id.signMap, fragment).commit();
            Log.d("TAG", "cccc");
        }
        if (fragment != null)
        {
            Log.d("HHH", "1");
            fragment.getMapAsync(this);
            Log.d("HHH", "2");
            if(mMap==null)
                Log.d("HHH","hhhhhh");
            if (mMap != null) {
                Log.d("HHH", "bbbb");
            }
        }
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        /*googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));*/
        googleMap.setOnMapClickListener(new OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Log.d("WQH","Aa");
                googleMap.addMarker(new MarkerOptions().position(latLng).title("marker"));

            }
        });
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        initilizeMap();

    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    /*
    public void onResume(){
        super.onResume();
        if(mMap==null){
            mMap=fragment.getMap();
        }
    }*/
}
