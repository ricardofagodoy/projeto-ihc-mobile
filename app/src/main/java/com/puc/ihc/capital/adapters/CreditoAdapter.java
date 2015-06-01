package com.puc.ihc.capital.adapters;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.puc.ihc.capital.R;
import com.puc.ihc.capital.model.RegistroContaCorrente;

public class CreditoAdapter extends BaseAdapter {

    private final Activity context;
    private final RegistroContaCorrente[] reg;

    public CreditoAdapter(Activity context, RegistroContaCorrente[] reg) {
        super();
        this.context = context;
        this.reg = reg;
    }

    @Override
    public int getCount() {
        return reg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View rowView= inflater.inflate(R.layout.conta_corrente_item, null, true);

        TextView data = (TextView) rowView.findViewById(R.id.data);
        TextView desc = (TextView) rowView.findViewById(R.id.desc);
        TextView valor = (TextView) rowView.findViewById(R.id.valor);

        data.setText(reg[position].getData());
        desc.setText(reg[position].getDesc());

            valor.setText("-" + reg[position].getValor());
            valor.setTextColor(Color.RED);

        return rowView;
    }
}
