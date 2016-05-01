package com.example.dmk.workfinder;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Emna-Kallel on 01/05/2016.
 */
public class Profil extends AppCompatActivity implements View.OnClickListener {

    ListView mListView;
    FloatingActionButton fab;
    String[] prenoms = new String[]{
            "Génie Logiciel ", "Réseaux Informatique", "Réseaux Mobile", "System Embarqué", "Informatique Industrielle ", "Mécanique",
            "Electrique", "Electromécanique", "Mathématique", "Histoire", "Lettre", "Economie",
            "Gestion", "Santé", "Médecine", "Dentaire", "Biologique", "Romain",
            "Consulting", "Management", "Hotellerie", "Free Lance", "Production", "Statisqtique",
            "Administration", "Architecture"
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);

        fab = (FloatingActionButton)findViewById(R.id.fabcord);
        fab.setOnClickListener(this);
        mListView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Profil.this,
                android.R.layout.simple_list_item_1, prenoms);
        mListView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.fabcord)
            Snackbar.make(v, "Hello Snackbar", Snackbar.LENGTH_LONG).show();
    }

    public Profil() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
