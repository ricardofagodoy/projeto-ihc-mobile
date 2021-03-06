package com.puc.ihc.capital.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.puc.ihc.capital.R;
import com.puc.ihc.capital.adapters.ContaCorrenteAdapter;
import com.puc.ihc.capital.interfaces.OnFragmentInteraction;
import com.puc.ihc.capital.model.RegistroContaCorrente;

import java.util.Calendar;

public class PoupancaFragment extends Fragment {

    private OnFragmentInteraction mListener;

    public PoupancaFragment() {
    }

    public static PoupancaFragment newInstance() {
        return new PoupancaFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setHasOptionsMenu(true);

        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_poupanca, container, false);

        ListView lista = (ListView) view.findViewById(R.id.listCorrente);

        ContaCorrenteAdapter adapter = new ContaCorrenteAdapter(getActivity(),
                new RegistroContaCorrente[] {
                        new RegistroContaCorrente("12/10/2015 -","Deposito","R$ 800.00"),
                        new RegistroContaCorrente("14/09/2015 -","Saque","R$ 300.00"),
                        new RegistroContaCorrente("15/08/2015 -","Deposito","R$ 800.00"),
                        new RegistroContaCorrente("21/07/2015 -","Saque","R$ 300.00"),
                        new RegistroContaCorrente("12/07/2015 -","Deposito","R$ 800.00")
                }
        );

        lista.setAdapter(adapter);

        View header = inflater.inflate(R.layout.header, null);
        TextView exitText = (TextView) header.findViewById(R.id.header);

        exitText.setText("Lançamentos");

        lista.addHeaderView(header);

        EditText dataDe = (EditText) view.findViewById(R.id.dataDe);
        EditText dataAte = (EditText) view.findViewById(R.id.dataAte);

        ImageView dataDeImage = (ImageView) view.findViewById(R.id.imageDe);
        dataDeImage.setTag(dataDe);

        ImageView dataAteImage = (ImageView) view.findViewById(R.id.imageAte);
        dataAteImage.setTag(dataAte);

        View.OnClickListener onDateFieldClick = new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                final Calendar c = Calendar.getInstance();

                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                EditText dateField;

                                if(v instanceof EditText) {
                                    dateField = (EditText) v;
                                } else {
                                    dateField = (EditText) v.getTag();
                                }

                                dateField.setText(String.format("%d/%d/%d", dayOfMonth, monthOfYear + 1, year));

                            }
                        }, mYear, mMonth, mDay);
                dpd.show();
            }
        };

        dataDeImage.setOnClickListener(onDateFieldClick);
        dataAteImage.setOnClickListener(onDateFieldClick);

        dataAte.setOnClickListener(onDateFieldClick);
        dataDe.setOnClickListener(onDateFieldClick);

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

        inflater.inflate(R.menu.menu_extratos, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.ajuda) {

            AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
            alertDialog.setTitle("Ajuda");
            alertDialog.setMessage("Para pesquisar determinado extrato da sua Poupança em determinada data, selecione as datas no intervalo desejado.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();

        }

        return super.onOptionsItemSelected(item);
    }

}
