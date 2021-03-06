package com.example.dmk.workfinder;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fragment.InfoFragmentWork;

/**
 * Created by Emna-Kallel on 01/05/2016.
 */
public class Profil extends AppCompatActivity implements View.OnClickListener {

    ListView mListView;
    FloatingActionButton fab;



    public ArrayList<String> getWorkListByUser(ParseUser p ){

     ParseQuery<ParseObject> query = ParseQuery.getQuery("Work").whereMatches("domain",p.get("domain")+"");
     query.findInBackground(new FindCallback<ParseObject>() {
         public void done(List<ParseObject> objects, ParseException e) {
             if (e == null) {


                 for (ParseObject workObject : objects) {
                    // Log.v(workObject.get("domain")+"","---******---");
                     workList.add(workObject.get("domain")+"");
                     Log.v(workList.get(0)+"","---**00****---");
                 }

             } else {

             }
         }
     });   return  workList;}


    public static ArrayList<String> workList = new ArrayList<String>();

    public static int pos_domain = 0;


    public int getPos_domain() {
        return pos_domain;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.profil);


        //workList.clear();
       // workList.add("Génie Logiciel");
      //  workList.clear();
        fab = (FloatingActionButton)findViewById(R.id.fabcord);

        workList.clear();
        workList.add("Génie Logiciel");
        workList.add("Réseaux Informatique");
        workList.add("Réseaux Mobile");
        workList.add("System Embarqué");
        workList.add("Informatique Industrielle ");
        workList.add("Electrique");
        workList.add("Electromécanique");
        workList.add("Mecanique");
        workList.add("Economie");


        fab = (FloatingActionButton) findViewById(R.id.fabcord);

        fab.setOnClickListener(this);
        mListView = (ListView) findViewById(R.id.listView);
        Log.v(workList.size()+"","---*8*---");

        workList=getWorkListByUser(ParseUser.getCurrentUser());
       // Log.v(workList.get(0)+"","---*8*---");



        mListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //  Toast.makeText(getApplicationContext(), "df" + id, Toast.LENGTH_SHORT).show();

                pos_domain = position;

                getFragmentManager().beginTransaction().add(R.id.contentprofile, new InfoFragmentWork()).commit();

            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Profil.this,
                android.R.layout.simple_list_item_1, workList);

        mListView.setAdapter(adapter);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fabcord)
            Snackbar.make(v, "Job Refresh", Snackbar.LENGTH_LONG).show();
    }


    public Profil() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
