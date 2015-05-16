package com.example.fepis.capital.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.fepis.capital.R;
import com.example.fepis.capital.interfaces.OnFragmentInteraction;

public class ExtratosFragment extends Fragment {

    private OnFragmentInteraction mListener;

    public ExtratosFragment() {
    }

    public static ExtratosFragment newInstance() {
        return new ExtratosFragment();
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

        View view = inflater.inflate(R.layout.fragment_extratos, container, false);

        ListView myList = (ListView) view.findViewById(R.id.listView);

        ArrayAdapter<String> codeLearnArrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, new String[]{"Teste", "Blabla"});
        myList.setAdapter(codeLearnArrayAdapter);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //((MainActivity) activity).onSectionAttached(getArguments().getString("Titulo"));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
