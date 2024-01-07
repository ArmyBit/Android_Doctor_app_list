package com.isga.isgaexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvMed;
    Medecin_adapter medad;
    List<HashMap<String,Object>> MdList;
    HashMap<String,Object> Medelement;
    DAO d;
    List<Medecin> med_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMed= findViewById(R.id.List1);
        Log.d("s","ok");
        d= new DAO(this);
        Log.d("DAO","ok");
        med_list= d.getAllMedecins();
        Log.d("DAO","no");
        MdList= new ArrayList<HashMap<String,Object>>();

        for(Medecin medecin:med_list){

            Medelement= new HashMap<String,Object>();
            Medelement.put("Code_Med","Code du Médecin");
            Medelement.put("valCode",medecin.getCode_Medecin());
            Medelement.put("lbl_nom_medecin", "Nom : Dr");
            Medelement.put("valNomMed", medecin.getNom_Medecin());
            Medelement.put("lbl_pre_medecin", "Prénom :");
            Medelement.put("valpreMed", medecin.getPrenom_Medecin());
            Medelement.put("lbl_spc_medecin", "Spécialité :  ");
            Medelement.put("valspecMed", medecin.getSpecialite_Medecin());
            Medelement.put("lbl_ville_medecin", "Ville : ");
            Medelement.put("valvilleMed", medecin.getVille_Medecin());
            Medelement.put("lbl_desc_medecin", "Description : ");
            Medelement.put("valdescMed", medecin.getDescription_Medecin());
            MdList.add(Medelement);

        }
        medad= new Medecin_adapter(MdList,this);

        lvMed.setAdapter(medad);
        lvMed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, Object> selectedMedecin = MdList.get(position);

                Intent editIntent = new Intent(MainActivity.this, medecin_controller.class);

                editIntent.putExtra("selectedMedecinDetails", selectedMedecin);
                startActivity(editIntent);
            }
        });
 }
}

