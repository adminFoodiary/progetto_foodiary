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

            ArrayList<String> priminomi = new ArrayList<String>(); //"nome"
            ArrayList<tipoAllergeni> primiallergeni = new ArrayList<tipoAllergeni>(); //"tipi"
            ArrayList<String> primicalorie = new ArrayList<>(); //"calorie"
            ArrayList<String> primiporzioni = new ArrayList<>(); //"porzioni"
            ArrayList<String> primiqtaporzione = new ArrayList<>(); //"porzione"
            ArrayList<HashMap<String, String>> primiIngredienti = new ArrayList<HashMap<String, String>>(); //"ingredienti" ["descrizione", "quantita"]
            ArrayList<String> primipreparazione = new ArrayList<>(); //"preparazione"

            /*int i = 0;
            while (i < primi.length()){
                priminomi.add(primi.getString(i));
                i++;
                primiallergeni.add((tipoAllergeni) primi.get(i));
                i++;
                primicalorie.add(primi.getString(i));
                i++;
                primiporzioni.add(primi.getString(i));
                i++;
                primiqtaporzione.add(primi.getString(i));
                i++;
                HashMap<String, String> prova = new HashMap<String, String>;
                JSONArray ingredienti = primi.getJSONArray(i);
                int f = 0;
                while (f < ingredienti.length()){
                    prova.put()
                }
            }*/
            if (primi.length()!=0){
                for (int i=0; i<primi.length(); i++){
                    JSONObject obj2 = primi.getJSONObject(i);
                    String nome = obj2.getString("nome");
                    JSONObject obj3 = obj2.getJSONObject("tipi");
                    boolean glutenfree = obj3.getBoolean("isGlutenFree");
                    boolean vegetariano = obj3.getBoolean("isVegetariano");
                    boolean vegano = obj3.getBoolean("isVegano");
                    boolean nichelfree = obj3.getBoolean("isNichelFree");
                    tipoAllergeni tipi = new tipoAllergeni(glutenfree, vegetariano, vegano, nichelfree);
                    String calorie = obj2.getString("calorie");
                    String porzioni = obj2.getString("porzione");
                    String porzione = obj2.getString("porzione");

                }
            }


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
            InputStream is = getActivity().getAssets().open("ricette.js");
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
