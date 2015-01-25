package com.cloudyun.parselocaldatastoredebug.parse;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by 2013_13_mbp on 23/1/15.
 */
@ParseClassName("TestObject")

public class TestObject extends ParseObject {
    public TestObject() {

    }

    public static ParseQuery<TestObject> getQuery() {
        return ParseQuery.getQuery(TestObject.class);
    }

    public String getFirstTitle() {
        return getString("firstTitle");
    }

    public String getSecondTitle() {
        return getString("secondTitle");
    }

    public String getThirdTitle() {
        return getString("thirdTitle");
    }
}

