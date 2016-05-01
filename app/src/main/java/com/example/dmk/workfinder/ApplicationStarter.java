package com.example.dmk.workfinder;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

/**
 * Created by dmk on 30/04/16.
 */
public class ApplicationStarter extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);


        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("seQgs8oZUFApdvRN2bHWUHFISlvBzMAJv00aHe0q")
                .clientKey("3LLNSGsADe3nAjqSHqaXwWUg7zI0V7UtVWeU1utH")
                .server("https://parseapi.back4app.com").build());


        //ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
