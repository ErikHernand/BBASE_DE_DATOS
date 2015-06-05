package com.example.usuario.bbase_de_datos;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adaptadorbitacora extends RecyclerView.Adapter<Adaptadorbitacora.bitacoraViewHolder>{

    private List<modelobitacora> items;

    public static class bitacoraViewHolder extends RecyclerView.ViewHolder {

        public TextView matricula;
        public TextView nombre;
        public TextView apellidop;
        public TextView apellidom;
        public TextView email;
        public TextView carrera;
        public TextView semestre;
        public TextView grupo;
        public TextView maquina;

        public bitacoraViewHolder(View v) {
            super(v);
            matricula = (TextView) v.findViewById(R.id.mat2);
            nombre = (TextView) v.findViewById(R.id.nom2);
            apellidop = (TextView) v.findViewById(R.id.app2);
            apellidom = (TextView) v.findViewById(R.id.apm2);
            email = (TextView) v.findViewById(R.id.em2);
            carrera = (TextView) v.findViewById(R.id.car2);
            semestre = (TextView) v.findViewById(R.id.sem2);
            grupo = (TextView) v.findViewById(R.id.gr2);
            maquina = (TextView) v.findViewById(R.id.maq2);
        }
    }

    public Adaptadorbitacora(List<modelobitacora> items) {
        this.items = items;
    }

    @Override
    public bitacoraViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardbitacora, viewGroup, false);
        return new bitacoraViewHolder(v);
    }

    @Override
    public void onBindViewHolder(bitacoraViewHolder viewHolder, int i) {
        //el String.valuOf
        viewHolder.matricula.setText(items.get(i).getMatricula());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.apellidop.setText(items.get(i).getApellidop());
        viewHolder.apellidom.setText(items.get(i).getApellidom());
        viewHolder.email.setText(items.get(i).getEmail());
        viewHolder.carrera.setText(items.get(i).getCarrera());
        viewHolder.semestre.setText(items.get(i).getSemestre());
        viewHolder.grupo.setText(items.get(i).getGrupo());
        viewHolder.maquina.setText(items.get(i).getMaquina());
    }

    @Override
    public int getItemCount() {
        return  items.size();
    }
}

