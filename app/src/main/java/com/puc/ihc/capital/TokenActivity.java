package com.puc.ihc.capital;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TokenActivity extends ActionBarActivity {

    private TextView counter;

    boolean rodando = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);

        counter = (TextView) this.findViewById(R.id.token);

        Button button = (Button) this.findViewById(R.id.button);



        final View card = this.findViewById(R.id.card2);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!rodando) {
                    initCounter();
                    rodando = true;
                }

                card.setVisibility(View.VISIBLE);
            }
        });


    }

    private void initCounter() {

        new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                counter.setText(String.format("O token irá expirar em %d segundos.",millisUntilFinished / 1000));
            }

            public void onFinish() {
                counter.setText("O Token expirou, gere um novo Token.");
                rodando = false;
            }
        }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_token, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_help) {

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Ajuda");
            alertDialog.setMessage("O token é usado para realizar a maioria das funcionalidades do site, provendo maior segurança para sua conta.");
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
