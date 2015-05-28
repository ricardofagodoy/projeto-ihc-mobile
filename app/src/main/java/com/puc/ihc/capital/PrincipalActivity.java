package com.puc.ihc.capital;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.puc.ihc.capital.fragments.NavigationDrawerFragment;
import com.puc.ihc.capital.interfaces.OnFragmentInteraction;

public class PrincipalActivity extends ActionBarActivity
    implements NavigationDrawerFragment.NavigationDrawerCallbacks, OnFragmentInteraction {

    public static final String[] drawerOptions = new String[]{
            "MinhaContaFragment",
            "ContaCorrenteFragment",
            "PoupancaFragment",
            "CreditoFragment",
            "TransferenciasFragment",
            "PagamentosFragment",
            "TokenFragment",
            "RecargaFragment",
            "ViagensFragment",
            "AgenciasFragment"
    };

    public static final Integer[] drawerOptionsIcons = new Integer[]{
            R.drawable.myaccount,       // Minha Conta
            R.drawable.wallet,       // Conta Corrente
            R.drawable.cifrao,                    // Poupança
            R.drawable.credit_card,                    // Cartão de Crédito
            R.drawable.transferencia,                       // Transferências
            R.drawable.money_bag,                    // Pagamentos
            R.drawable.key,                     // Token Eletronico
            R.drawable.phone,                     // Recarga celular
            R.drawable.viagens,                     // Viagens
            R.drawable.bussola,                 // Agencias
            R.drawable.exit                        // Sair
    };


    private NavigationDrawerFragment mNavigationDrawerFragment;
    static private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        try {
            String titulo =  PrincipalActivity.drawerOptions[position];

            Class clazz = Class.forName(String.format("com.puc.ihc.capital.fragments.%s", titulo));
            Fragment fragment = (Fragment) clazz.newInstance();

            mTitle = getString(getResources().getIdentifier(titulo, "string", getPackageName()));

            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.container, fragment).
                    addToBackStack(String.valueOf(position)).
                    commit();

        } catch(Exception e) {
            //Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            this.finish();
    }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSectionAttached(String titulo) {
    }

    public static void setTitle(String title) {
        mTitle = title;
    }

    public void onFragmentInteraction(Uri uri){
    }

    @Override
    public void onBackPressed() {

        Integer count = this.getSupportFragmentManager().getBackStackEntryCount();
        if (count > 1) {

            super.onBackPressed();

            Integer position = Integer.parseInt(getSupportFragmentManager().getBackStackEntryAt(count-2).getName());
            getSupportFragmentManager().popBackStack();
            mTitle = getString(getResources().getIdentifier(PrincipalActivity.drawerOptions[position], "string", getPackageName()));
            restoreActionBar();
            mNavigationDrawerFragment.selectItem(position);
        }
    }
}
