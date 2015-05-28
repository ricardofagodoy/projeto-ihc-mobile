package com.puc.ihc.capital.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.TextView;

import com.puc.ihc.capital.R;
import com.puc.ihc.capital.interfaces.OnFragmentInteraction;

public class TokenFragment extends Fragment {

    private OnFragmentInteraction mListener;

    TextView counter, token;

    public TokenFragment() {
    }

    public static TokenFragment newInstance() {
        return new TokenFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_token, container, false);

        counter = (TextView) view.findViewById(R.id.textView19);
        token = (TextView) view.findViewById(R.id.textView18);

        initCounter();

        return view;
    }

    private void initCounter() {

        new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                counter.setText(String.format("O token irá expirar em %d segundos.",millisUntilFinished / 1000));
            }

            public void onFinish() {

                if (token.getText().equals("JIB4S"))
                    token.setText("TX89N");
                else
                    token.setText("JIB4S");

                initCounter();
            }
        }.start();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //((PrincipalActivity) activity).onSectionAttached(getArguments().getString("Titulo"));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
