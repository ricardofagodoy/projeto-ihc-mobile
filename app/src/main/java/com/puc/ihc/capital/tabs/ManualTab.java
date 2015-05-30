package com.puc.ihc.capital.tabs;

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
import android.widget.EditText;

import com.puc.ihc.capital.R;

public class ManualTab extends Fragment {

    public ManualTab() {}

    private EditText edit5;
    private View card2;
    private Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_manual_tab, container, false);

        edit5 = (EditText) view.findViewById(R.id.editText5);

        final Button btn4 = (Button) view.findViewById(R.id.button4);

        card2 = view.findViewById(R.id.card2);
        btn = (Button) view.findViewById(R.id.button3);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card2.setVisibility(View.VISIBLE);
                btn.setVisibility(View.VISIBLE);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Sucesso");
                alertDialog.setMessage("Pagamento realizado com sucesso!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

                card2.setVisibility(View.GONE);
                btn.setVisibility(View.GONE);
                edit5.setText("");
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        edit5.setText("");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();

        inflater.inflate(R.menu.menu_manual, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.remove) {
            card2.setVisibility(View.GONE);
            btn.setVisibility(View.GONE);
            edit5.setText("");
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.ajuda) {

            AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
            alertDialog.setTitle("Ajuda");
            alertDialog.setMessage("Digite o código completo do boleto que deseja pagar.");
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
