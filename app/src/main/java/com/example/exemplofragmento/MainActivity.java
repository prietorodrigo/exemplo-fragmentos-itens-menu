package com.example.exemplofragmento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        ActionBar actionbar = getSupportActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionbar.newTab().setText("Frag1");
        tab1.setTabListener(new MyTabListener(this,new fragmento1()));
        actionbar.addTab(tab1);

        ActionBar.Tab tab2 = actionbar.newTab().setText("Frag2");
        tab2.setTabListener(new MyTabListener(this,new fragmento2()));
        actionbar.addTab(tab2);

         */

        if(savedInstanceState==null){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.layoutFrag,new fragmento1());
            ft.commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(item.getItemId()==R.id.frag1){
            ft.replace(R.id.layoutFrag,new fragmento1());
            ft.commit();
        }
        else if(item.getItemId()==R.id.frag2){
            ft.replace(R.id.layoutFrag,new fragmento2());
            ft.commit();
        }
        return super.onOptionsItemSelected(item);
    }
}