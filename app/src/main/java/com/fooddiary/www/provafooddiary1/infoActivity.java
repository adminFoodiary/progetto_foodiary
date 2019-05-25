package com.fooddiary.www.provafooddiary1;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Objects;


public class infoActivity extends Fragment
        implements NavigationView.OnNavigationItemSelectedListener{

    String[] impostazioni = new String[]{"Visualizza info", "Modifica info"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*String preferenze = "Tommaso";
        if (!preferenze.contains("nome")){
            //aggiungere un nome di default
        }*/

        View view = inflater.inflate(R.layout.activity_info, container, false);

        ListView listaImpostazioni = (ListView) view.findViewById(R.id.listaImpostazioni);

        ArrayAdapter <String> adapter = new ArrayAdapter <String> (
                getActivity(),
                android.R.layout.simple_list_item_1,
                impostazioni);
        listaImpostazioni.setAdapter(adapter);
        listaImpostazioni.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0){
                    cambiaPagina(0);
                }else if (pos == 1){
                    cambiaPagina(1);
                }
            }
        });
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Impostazioni");
    }



    private void cambiaPagina(int pos){
        if (pos == 0){
            Intent nuovapagina = new Intent(getActivity().getApplicationContext(), visualizzaInfo.class);
            startActivity(nuovapagina);
        } else if (pos == 1){
            Intent nuovapagina = new Intent(getActivity().getApplicationContext(), modificaInfo.class);
            startActivity(nuovapagina);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
