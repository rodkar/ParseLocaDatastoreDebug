package com.cloudyun.parselocaldatastoredebug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cloudyun.parselocaldatastoredebug.parse.TestObject;
import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.SaveCallback;

import java.util.List;

/**
 * Created by 2013_13_mbp on 23/1/15.
 */
public class TestObjectListFragment extends ListFragment {

    private TestObjectListAdapter testObjectListAdapter;
    private ProgressBar bar;

    public TestObjectListFragment() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        testObjectListAdapter = new TestObjectListAdapter(getActivity());
        testObjectListAdapter.setPaginationEnabled(false);

        testObjectListAdapter.addOnQueryLoadListener(new ParseQueryAdapter.OnQueryLoadListener<TestObject>() {
            @Override
            public void onLoading() {
                startLoading();
            }

            @Override
            public void onLoaded(List<TestObject> testObjects, Exception e) {
                stopLoading();

            }
        });
        setListAdapter(testObjectListAdapter);
        refreshData();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_test_object_list_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                refreshData();
                return false;
            default:
                break;
        }

        return false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_test_object_list, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDividerHeight(0);
        getListView().setDivider(null);
    }

    @Override
    public void onResume() {
        super.onResume();
        getListView().clearFocus();
    }

    protected void startLoading() {
        bar = (ProgressBar) getActivity().findViewById(R.id.progressBar);
        bar.setVisibility(View.VISIBLE);
    }

    protected void stopLoading() {
        bar.setVisibility(View.GONE);
    }

    protected void refreshData(){
        ParseQuery<TestObject> testObjectParseQuery = TestObject.getQuery();
        testObjectParseQuery.orderByAscending("createdAt");
        testObjectParseQuery.findInBackground(new FindCallback<TestObject>() {
            @Override
            public void done(final List<TestObject> testObjects, ParseException e) {
                TestObject.unpinAllInBackground("testObjectCached", new DeleteCallback() {
                    @Override
                    public void done(ParseException e) {
                        TestObject.pinAllInBackground("testObjectCached", testObjects, new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                testObjectListAdapter.loadObjects();
                            }
                        });
                    }
                });
            }
        });
    }
}