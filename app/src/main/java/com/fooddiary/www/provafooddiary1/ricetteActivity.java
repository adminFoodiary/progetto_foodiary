package com.fooddiary.www.provafooddiary1;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ricetteActivity extends Fragment
        implements NavigationView.OnNavigationItemSelectedListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_info, container, false);
        try {
            JSONObject jobject = new JSONObject(loadJSONFromAsset());
            JSONArray primi = jobject.getJSONArray("primi");
            ArrayList<String> priminomi = new ArrayList<String>();
            ArrayList<tipoAllergeni> primiallergeni = new ArrayList<tipoAllergeni>();
            ArrayList<String> primicalorie;
            ArrayList<String> primiporzioni;
            ArrayList<String> primiqtaporzione;
            ArrayList<ArrayList<HashMap<String, String>>> primiIngredienti;
            ArrayList<String> primidescrizione;


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("yourfilename.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
