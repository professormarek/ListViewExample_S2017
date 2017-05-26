package com.example.mareklaskowski.listviewexample_s2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //let's create some data in a regular Java array. Note: this could instead come from a file, database, the web, etc.
        String[] data = new String[] {"Coffee", "Sandwich", "Creme Brule"};
        /*
        create an ArrayAdapter for Strings
        the constructor for ArrayAdapter requires a "sample list item" layout.
        make sure that we have one in /res/layout
        constructor arguments are: a Context, sample_layout_id, data (array)
        The ArrayAdapter is like the "controller" in "Model-View-Controller" architecture
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, data);

        //we need to link the ArrayAdpater with our ListView
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}











