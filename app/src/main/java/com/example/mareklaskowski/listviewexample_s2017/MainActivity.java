package com.example.mareklaskowski.listviewexample_s2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    create an OnItemClickListener object and override its onItemClick method
    (very much like the anonymous class example we did with Buttons)
     */
    private AdapterView.OnItemClickListener myListItemClickHandler = new AdapterView.OnItemClickListener(){

        /*
        parent is the ListView, position stores the index of the item that was clicked
         */
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //get data from the view that was clicked...
            String data = parent.getItemAtPosition(position).toString();
            //for now just show a Toast.. but really we could do anything we want with the data...
            Toast.makeText(view.getContext(), "You clicked "+ data+ " YUM!", Toast.LENGTH_SHORT).show();

        }
    };

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
        //connect the listview to use the listener or handler that we created as a private, inner class
        listView.setOnItemClickListener(myListItemClickHandler);
    }
}











