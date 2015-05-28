package com.puc.ihc.capital.tabs;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.puc.ihc.capital.R;

public class BoletoTab extends Fragment {

    public BoletoTab() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_boleto_tab, container, false);

        final View card1 = view.findViewById(R.id.card1);

        final View card2 = view.findViewById(R.id.card2);
        final Button btn = (Button) view.findViewById(R.id.button3);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card2.setVisibility(View.VISIBLE);
                btn.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }
}
