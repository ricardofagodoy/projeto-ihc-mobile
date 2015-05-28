package com.puc.ihc.capital.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.puc.ihc.capital.PrincipalActivity;
import com.puc.ihc.capital.R;
import com.puc.ihc.capital.adapters.ContaCorrenteAdapter;
import com.puc.ihc.capital.adapters.TransferenciasAdapter;
import com.puc.ihc.capital.interfaces.OnFragmentInteraction;
import com.puc.ihc.capital.model.RegistroContaCorrente;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransferenciasFragment extends Fragment {

    private OnFragmentInteraction mListener;
    private int lastExpandedPosition = -1;
    private TextView confirmacao;

    public TransferenciasFragment() {
    }

    public static TransferenciasFragment newInstance() {
        return new TransferenciasFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }*/
    }

    public static void slide_down(Context ctx, View v){
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
        if(a != null){
            a.reset();
            if(v != null){
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    public static void slide_up(Context ctx, View v){
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_up);
        if(a != null){
            a.reset();
            if(v != null){
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transferencias, container, false);


        View cardToShow = view.findViewById(R.id.card2);

       final ExpandableListView lista = (ExpandableListView) view.findViewById(R.id.listTransferencias);

        TextView ajuda = (TextView) view.findViewById(R.id.ajudaBeneficiados);

        ajuda.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Beneficiados");
                alertDialog.setMessage("Só é possível realizar transferências pelo celular para beneficiados previamente cadastrados," +
                                        " e o cadastro só pode ser feito pelo site.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        List<String> listDataHeader = new ArrayList<String>();
        HashMap<String, List<String>> listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Antonio freitas");
        listDataHeader.add("Gustavo Ribachaves");
        listDataHeader.add("Chaponildo Caveira");

        // Adding child data
        List<String> valor = new ArrayList<String>();
        valor.add("Valor: ");

        listDataChild.put(listDataHeader.get(0), valor); // Header, Child data
        listDataChild.put(listDataHeader.get(1), valor);
        listDataChild.put(listDataHeader.get(2), valor);

        TransferenciasAdapter adapter = new TransferenciasAdapter(getActivity(), listDataHeader, listDataChild, cardToShow);
        lista.setAdapter(adapter);

        lista.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    lista.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });



        return view;
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
