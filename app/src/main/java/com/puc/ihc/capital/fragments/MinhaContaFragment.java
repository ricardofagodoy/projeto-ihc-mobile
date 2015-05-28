package com.puc.ihc.capital.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.puc.ihc.capital.PrincipalActivity;
import com.puc.ihc.capital.R;
import com.puc.ihc.capital.interfaces.OnFragmentInteraction;

import java.util.List;

public class MinhaContaFragment extends Fragment {

    private OnFragmentInteraction mListener;

    public MinhaContaFragment() {
    }

    public static MinhaContaFragment newInstance() {
        return new MinhaContaFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }*/

        this.setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_minha_conta, container, false);

        View corrente = view.findViewById(R.id.card1);
        View poupanca = view.findViewById(R.id.card2);
        View cartao = view.findViewById(R.id.card3);

        View.OnClickListener clickCorrente = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PrincipalActivity.setTitle(getString(getResources().getIdentifier(PrincipalActivity.drawerOptions[1], "string", getActivity().getPackageName())));

                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container, new ContaCorrenteFragment()).
                        addToBackStack("1").
                        commit();
            }
        };

        View.OnClickListener clickPoupanca = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PrincipalActivity.setTitle(getString(getResources().getIdentifier(PrincipalActivity.drawerOptions[2], "string", getActivity().getPackageName())));

                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container, new PoupancaFragment()).
                        addToBackStack("2").
                        commit();
            }
        };

        View.OnClickListener clickCartao = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PrincipalActivity.setTitle(getString(getResources().getIdentifier(PrincipalActivity.drawerOptions[3], "string", getActivity().getPackageName())));

                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container, new CreditoFragment()).
                        addToBackStack("3").
                        commit();
            }
        };

        corrente.setOnClickListener(clickCorrente);
        poupanca.setOnClickListener(clickPoupanca);
        cartao.setOnClickListener(clickCartao);

        ListView listCorrente = (ListView) view.findViewById(R.id.listCorrente);
        ListView listPoupanca = (ListView) view.findViewById(R.id.listPoupanca);
        ListView listCartao = (ListView) view.findViewById(R.id.listCartao);

        AdapterView.OnItemClickListener clickCorrenteLista = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av,View v, int i, long l) {

                PrincipalActivity.setTitle(getString(getResources().getIdentifier(PrincipalActivity.drawerOptions[1], "string", getActivity().getPackageName())));

                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container, new ContaCorrenteFragment()).
                        addToBackStack("1").
                        commit();
            }
        };;

        AdapterView.OnItemClickListener clickPoupancaLista = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av,View v, int i, long l) {

                PrincipalActivity.setTitle(getString(getResources().getIdentifier(PrincipalActivity.drawerOptions[2], "string", getActivity().getPackageName())));

                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container, new PoupancaFragment()).
                        addToBackStack("2").
                        commit();
            }
        };;


        AdapterView.OnItemClickListener clickCartaoLista = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av,View v, int i, long l) {

                PrincipalActivity.setTitle(getString(getResources().getIdentifier(PrincipalActivity.drawerOptions[3], "string", getActivity().getPackageName())));

                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container, new CreditoFragment()).
                        addToBackStack("3").
                        commit();
            }
        };;

        listCorrente.setOnItemClickListener(clickCorrenteLista);
        listPoupanca.setOnItemClickListener(clickPoupancaLista);
        listCartao.setOnItemClickListener(clickCartaoLista);



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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();

        inflater.inflate(R.menu.menu_minhaconta, menu);
    }

}
