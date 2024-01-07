package com.isga.isgaexam;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class Medecin_adapter extends BaseAdapter {
    List<HashMap<String, Object>> List_Medecin;
    Context context;
    LayoutInflater personal_inflater;

    public Medecin_adapter(List<HashMap<String, Object>> list_Medecin, Context context) {
        this.List_Medecin = list_Medecin;
        this.context = context;
        personal_inflater = LayoutInflater.from(context);;
    }

    @Override
    public int getCount() {
        return this.List_Medecin.size();
    }

    @Override
    public Object getItem(int position) {
        return this.List_Medecin.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public static class ViewHolder{
        TextView lblnom,valnom,lblpre,valpre,lblspec,valspec,lblville,valville,lbldesc,valdesc;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = personal_inflater.inflate(R.layout.list_for_adapter, null);
            holder.lblnom = convertView.findViewById(R.id.lbl_nom_medecin);
            holder.valnom = convertView.findViewById(R.id.valNomMed);
            holder.lblpre = convertView.findViewById(R.id.lbl_pre_medecin);
            holder.valpre = convertView.findViewById(R.id.valpreMed);
            holder.lblspec = convertView.findViewById(R.id.lbl_spc_medecin);
            holder.valspec = convertView.findViewById(R.id.valspecMed);
            holder.lblville = convertView.findViewById(R.id.lbl_ville_medecin);
            holder.valville = convertView.findViewById(R.id.valvilleMed);
            holder.lbldesc = convertView.findViewById(R.id.lbl_desc_medecin);
            holder.valdesc = convertView.findViewById(R.id.valdescMed);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        try{

            holder.lblnom.setText(List_Medecin.get(position).get("lbl_nom_medecin").toString());
            holder.valnom.setText(List_Medecin.get(position).get("valNomMed").toString());
            holder.lblpre.setText(List_Medecin.get(position).get("lbl_pre_medecin").toString());
            holder.valpre.setText(List_Medecin.get(position).get("valpreMed").toString());
            holder.lblspec.setText(List_Medecin.get(position).get("lbl_spc_medecin").toString());
            holder.valspec.setText(List_Medecin.get(position).get("valspecMed").toString());
            holder.lblville.setText(List_Medecin.get(position).get("lbl_ville_medecin").toString());
            holder.valville.setText(List_Medecin.get(position).get("valvilleMed").toString());
            holder.lbldesc.setText(List_Medecin.get(position).get("lbl_desc_medecin").toString());
            holder.valdesc.setText(List_Medecin.get(position).get("valdescMed").toString());

            return convertView;
        }
        catch (NullPointerException e)
        {
            Log.e("AdapterError", "NullPointerException at position: " + position);
            e.printStackTrace();
        }
        return convertView;
    }
}
