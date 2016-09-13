package br.com.alb.maromba;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Aristeu da Silva Filho on 13/09/2016.
 */
public class spnAdapterAcademias extends ArrayAdapter<spnAcademias> {

    private Context context;
    private spnAcademias[] Academias;

    public spnAdapterAcademias(Context context, int textViewResourceId, spnAcademias[] academias)
    {
        super(context, textViewResourceId, academias);

        this.context = context;
        this.Academias = academias;
    }

    public int getCount()
    {
        return Academias.length;
    }

    public spnAcademias getItem(int position){
        return Academias[position];
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setTextColor(Color.BLACK);
        label.setText(Academias[position].getDescricao());

        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setTextColor(Color.BLACK);
        label.setText(Academias[position].getDescricao());

        return label;
    }

}
