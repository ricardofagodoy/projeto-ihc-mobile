package com.puc.ihc.capital.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.puc.ihc.capital.R;

public class ManualTab extends Fragment {

    public ManualTab() {}

    private EditText edit5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_manual_tab, container, false);

        edit5 = (EditText) view.findViewById(R.id.editText5);

        final Button btn4 = (Button) view.findViewById(R.id.button4);

        final View card2 = view.findViewById(R.id.card2);
        final Button btn = (Button) view.findViewById(R.id.button3);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card2.setVisibility(View.VISIBLE);
                btn.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        edit5.setText("");
    }
}
