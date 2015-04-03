package com.bluepegasuscc.allmystuff;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter<String> mlistArray;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            String[] itemData = {
                    "Shirt",
                    "Shoes",
                    "Cloth",
                    "Flour",
                    "Cat litter",
                    "Eggs"
            };
            List<String> stuffList = new ArrayList<String>(Arrays.asList(itemData));

            mlistArray = new ArrayAdapter<String>(
                    getActivity(), //find context to put it in
                    R.layout.list_item, //view to put the data in
                    R.id.list_item_name, //specific bit to put these strings into
                    stuffList); //strings to put in

            View rootView = inflater.inflate(R.layout.fragment_main, container, false); //find the views (tree)

            ListView listView = (ListView) rootView.findViewById(R.id.list_view); //find the listview in the tree
            listView.setAdapter(mlistArray); //connect adapter to view it will be displayed in

            return rootView;
        }
    }
}
