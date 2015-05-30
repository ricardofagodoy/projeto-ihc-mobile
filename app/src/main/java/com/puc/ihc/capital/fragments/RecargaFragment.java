package com.puc.ihc.capital.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.puc.ihc.capital.R;
import com.puc.ihc.capital.interfaces.OnFragmentInteraction;

public class RecargaFragment extends Fragment {

    private OnFragmentInteraction mListener;

    public RecargaFragment() {
    }

    public static RecargaFragment newInstance() {
        return new RecargaFragment();
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

        View view = inflater.inflate(R.layout.fragment_recarga, container, false);


        final RadioGroup rg1 = (RadioGroup) view.findViewById(R.id.radioGroup1);
        final RadioButton rb1 = (RadioButton) view.findViewById(R.id.rb1);
        final RadioButton rb2 = (RadioButton) view.findViewById(R.id.rb2);
        final RadioButton rb3 = (RadioButton) view.findViewById(R.id.rb3);
        final RadioButton rb4 = (RadioButton) view.findViewById(R.id.rb4);
        final RadioButton rb5 = (RadioButton) view.findViewById(R.id.rb5);
        final RadioButton rb6 = (RadioButton) view.findViewById(R.id.rb6);
        final RadioButton rb7 = (RadioButton) view.findViewById(R.id.rb7);
        final RadioButton rb8 = (RadioButton) view.findViewById(R.id.rb8);

        Button btn = (Button) view.findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Sucesso");
                alertDialog.setMessage("Recarga realizada com sucesso!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

                rg1.clearCheck();
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
                rb5.setChecked(false);
                rb6.setChecked(false);
                rb7.setChecked(false);
                rb8.setChecked(false);

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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();

        inflater.inflate(R.menu.menu_recarga, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {

            AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
            alertDialog.setTitle("Ajuda");
            alertDialog.setMessage("Só é possível realizar recargas para celulares previamente cadastrados, " +
                    "para remover ou cadastrar um novo celular acesse o site.");
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
