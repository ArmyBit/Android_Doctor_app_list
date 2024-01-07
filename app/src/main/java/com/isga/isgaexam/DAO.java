package com.isga.isgaexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

public class DAO extends SQLiteOpenHelper {
    public static final int DB_VERSION=1;

    public static final String Code_Medecin="Code_Medecin";
    public static final String Nom_Medecin="Nom_Medecin";
    public static final String Prenom_Medecin="Prenom_Medecin";
    public static final String Specialite_Medecin="Specialite_Medecin";
    public static final String Ville_Medecin="Ville_Medecin";
    public static final String Description_Medecin="Description_Medecin";
    private static final String Table_Name = "Medecin";



    public static final String DB_name="MyDb";
    public DAO(@Nullable Context context) {
        super(context, DB_name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table Medecin("+"Code_Medecin INTEGER PRIMARY KEY AUTOINCREMENT,"+"Nom_Medecin TEXT NOT NULL,"+"Prenom_Medecin TEXT NOT NULL,"+"Specialite_Medecin TEXT NOT NULL,"+"Ville_Medecin TEXT NOT NULL,"+"Description_Medecin TEXT NOT NULL)");
        String Msg= "DB CREATED";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if EXISTS Medecin");
        this.onCreate(db);
    }
    public Medecin getMedecinById(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query(Table_Name,
                new String[]{Code_Medecin, Nom_Medecin, Prenom_Medecin, Specialite_Medecin,Ville_Medecin,Description_Medecin},
                Code_Medecin + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null);

        if (c != null) c.moveToFirst();
        Medecin Medecin = new Medecin();

        Medecin.setCode_Medecin(Integer.parseInt(c.getString(0)));
        Medecin.setNom_Medecin(c.getString(1));
        Medecin.setPrenom_Medecin(c.getString(2));
        Medecin.setSpecialite_Medecin(c.getString(3));
        Medecin.setVille_Medecin(c.getString(4));
        Medecin.setDescription_Medecin(c.getString(53));
        db.close();
        return Medecin;


    }

    public List<Medecin> getAllMedecins(){
        List<Medecin> Medecin_List=new LinkedList<Medecin>();

        String query="SELECT * FROM "+Table_Name;

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(query,null);

        Medecin Medecin=null;
        if(cursor.moveToFirst()){
            do{
                Medecin=new Medecin();
                Medecin.setCode_Medecin(Integer.parseInt(cursor.getString(0)));
                Medecin.setNom_Medecin(cursor.getString(1));
                Medecin.setPrenom_Medecin(cursor.getString(2));
                Medecin.setSpecialite_Medecin(cursor.getString(3));
                Medecin.setVille_Medecin(cursor.getString(4));
                Medecin.setDescription_Medecin(cursor.getString(5));
                Medecin_List.add(Medecin);
            }while (cursor.moveToNext());
        }
        db.close();

        return Medecin_List;

    }
    public void addMedecin(Medecin med) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(Nom_Medecin, med.getNom_Medecin());
        v.put(Prenom_Medecin, med.getPrenom_Medecin());
        v.put(Specialite_Medecin, med.getSpecialite_Medecin());
        v.put(Ville_Medecin, med.getVille_Medecin());
        v.put(Description_Medecin, med.getDescription_Medecin());
        db.insert(Table_Name, null, v);

        db.close();
    }

        public void deleteMedecin(Medecin medecin){
        SQLiteDatabase db= this.getWritableDatabase();

        db.delete(Table_Name, Code_Medecin+"=?",
                new String[]{String.valueOf(medecin.getCode_Medecin())}
        );
        db.close();
    }

    public int updateMedecin(Medecin medecin){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(Nom_Medecin, medecin.getNom_Medecin());
        v.put(Prenom_Medecin, medecin.getPrenom_Medecin());
        v.put(Specialite_Medecin, medecin.getSpecialite_Medecin());
        v.put(Ville_Medecin, medecin.getVille_Medecin());
        v.put(Description_Medecin, medecin.getDescription_Medecin());
        int i= db.update(Table_Name, v,Code_Medecin+"=?",
                new String[]{String.valueOf(medecin.getCode_Medecin())} );
        db.close();
        return i;
    }
}
