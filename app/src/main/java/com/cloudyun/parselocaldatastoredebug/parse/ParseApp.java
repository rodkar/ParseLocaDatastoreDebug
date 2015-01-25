package com.cloudyun.parselocaldatastoredebug.parse;

import com.cloudyun.parselocaldatastoredebug.App;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by 2013_13_mbp on 23/1/15.
 */
public class ParseApp extends App {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(TestObject.class);
        Parse.initialize(this, "", "");
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
