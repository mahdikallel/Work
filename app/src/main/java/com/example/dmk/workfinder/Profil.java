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

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emna-Kallel on 01/05/2016.
 */
public class Profil extends AppCompatActivity implements View.OnClickListener {

    ListView mListView;
    FloatingActionButton fab;
    ArrayList<String> workList = new ArrayList<String>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        workList.clear();
        workList.add("Génie Logiciel");
        fab = (FloatingActionButton)findViewById(R.id.fabcord);
        fab.setOnClickListener(this);
        mListView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Profil.this,
                android.R.layout.simple_list_item_1, workList);
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
