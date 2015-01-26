package com.alcoholimetro.indam.alcolimetrefree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountriesSpinnerAdapter extends ArrayAdapter<Countries>
{
    private Context context;

    List<Countries> datos = null;
    public CountriesSpinnerAdapter(Context context, List<Countries> datos)
    {
        super(context, R.layout.spinner_selected_item, datos);
        this.context = context;
        this.datos = datos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
            convertView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.spinner_selected_item, null);
        ((TextView) convertView.findViewById(R.id.texto)).setText(datos.get(position).getNombre());
        convertView.findViewById(R.id.icono).setBackgroundResource(datos.get(position).getIcono());

        return convertView;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        if (row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.spinner_list_item, parent, false);
        }

        if (row.getTag() == null)
        {
            CountriesHolder countriesHolder = new CountriesHolder();
            countriesHolder.setIcono((ImageView) row.findViewById(R.id.icono));
            countriesHolder.setTextView((TextView) row.findViewById(R.id.texto));
            row.setTag(countriesHolder);
        }

        //rellenamos el layout con los datos de la fila que se está procesando
        Countries countries = datos.get(position);
        ((CountriesHolder) row.getTag()).getIcono().setImageResource(countries.getIcono());
        ((CountriesHolder) row.getTag()).getTextView().setText(countries.getNombre());

        return row;
    }


}
