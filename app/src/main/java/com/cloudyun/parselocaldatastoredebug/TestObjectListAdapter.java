package com.cloudyun.parselocaldatastoredebug;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cloudyun.parselocaldatastoredebug.parse.TestObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

/**
 * Created by 2013_13_mbp on 23/1/15.
 */
public class TestObjectListAdapter extends ParseQueryAdapter<TestObject> {

    protected String firstTitle;
    protected String secondTitle;
    protected String thirdTitle;

    public TestObjectListAdapter(final Context context) {
        super(context, new ParseQueryAdapter.QueryFactory<TestObject>(){
            @Override
            public ParseQuery<TestObject> create() {
                ParseQuery<TestObject> query = new ParseQuery("TestObject");
                query.orderByDescending("createdAt");
                query.fromPin("testObjectCached");
                return query;
            }
        });
    }

    @Override
    public View getItemView(TestObject testObject, View v, ViewGroup parent) {
        ViewHolder holder;

        firstTitle = testObject.getFirstTitle();
        secondTitle = testObject.getSecondTitle();
        thirdTitle = testObject.getThirdTitle();

        v = LayoutInflater.from(getContext()).inflate(R.layout.list_item_test_object, parent, false);

        holder = new ViewHolder();
        holder.titlesLayout = (LinearLayout) v.findViewById(R.id.titlesLayout);
        v.setTag(holder);

        if (firstTitle != null) {
            holder.firstTitle = new TextView(getContext());
            holder.firstTitle.setText(firstTitle);
            holder.titlesLayout.addView(holder.firstTitle);
        }

        if (secondTitle != null) {
            holder.secondTitle = new TextView(getContext());
            holder.secondTitle.setText(secondTitle);
            holder.titlesLayout.addView(holder.secondTitle);
        }

        if (thirdTitle != null) {
            holder.thirdTitle = new TextView(getContext());
            holder.thirdTitle.setText(thirdTitle);
            holder.titlesLayout.addView(holder.thirdTitle);
        }

        return v;
    }

    private static class ViewHolder {
        LinearLayout titlesLayout;
        TextView firstTitle;
        TextView secondTitle;
        TextView thirdTitle;
    }
}
