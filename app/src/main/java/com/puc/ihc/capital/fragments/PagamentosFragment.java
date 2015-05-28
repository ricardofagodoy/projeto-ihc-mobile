package com.puc.ihc.capital.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabWidget;
import android.widget.TextView;

import com.puc.ihc.capital.R;
import com.puc.ihc.capital.interfaces.OnFragmentInteraction;
import com.puc.ihc.capital.tabs.BoletoTab;
import com.puc.ihc.capital.tabs.ManualTab;
import com.puc.ihc.capital.tabs.RecargaTab;

public class PagamentosFragment extends Fragment {

    private OnFragmentInteraction mListener;
    private FragmentTabHost mTabHost;

    public PagamentosFragment() {
    }

    public static PagamentosFragment newInstance() {
        return new PagamentosFragment();
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

        //View view = inflater.inflate(R.layout.fragment_pagamentos, container, false);

        mTabHost = new FragmentTabHost(getActivity());
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);

       // mTabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
        //mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);

        TabWidget tw = (TabWidget)mTabHost.findViewById(android.R.id.tabs);

        mTabHost.addTab(mTabHost.newTabSpec("barras").setIndicator("Código de Barras"), BoletoTab.class, null);

        TextView tv = (TextView) tw.getChildTabViewAt(0).findViewById(android.R.id.title);
        tv.setTextSize(11);

        mTabHost.addTab(mTabHost.newTabSpec("manual").setIndicator("Manualmente"), ManualTab.class, null);

        tv = (TextView) tw.getChildTabViewAt(1).findViewById(android.R.id.title);
        tv.setTextSize(11);

        //mTabHost.addTab(mTabHost.newTabSpec("recarga").setIndicator("Recarga"), RecargaTab.class, null);

        //tv = (TextView) tw.getChildTabViewAt(2).findViewById(android.R.id.title);
        //tv.setTextSize(11);

        return mTabHost;
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;
    }

}
