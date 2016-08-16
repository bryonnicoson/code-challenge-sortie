package org.codeforcoffee.sortie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mFamousPetsList = new ArrayList();
    private ArrayAdapter<String> mArrayAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // providing content
        mFamousPetsList.add("Lil' Bub");
        mFamousPetsList.add("Grumpy Cat");
        mFamousPetsList.add("keyboard cat");
        mFamousPetsList.add("wishbone");
        mFamousPetsList.add("shadow");
        mFamousPetsList.add("wonder dog");
        mFamousPetsList.add("catdog");
        mFamousPetsList.add("meowth");
        mFamousPetsList.add("nyancat");
        mFamousPetsList.add("your pet here");
        mFamousPetsList.add("charmander");
        mFamousPetsList.add("bulbasaur");
        mFamousPetsList.add("squirtle");




        mListView = (ListView) findViewById(R.id.list_view);

        // sort the arrayList descendingly

        ArrayList<String> displayData = sortDescending(mFamousPetsList);

        // render the list using the android.R.simple_list_row_1 layout

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, displayData);
        mListView.setAdapter(listAdapter);

    }

    private ArrayList<String> sortDescending(ArrayList<String> list) {

        // sort the arrayList descending alphabetically
        // do not use ArrayList.sort()
        //Collections.sort(list, sortDescending())
        String a, b, c, d;

        for (int i=0; i < list.size(); i++) {
            for(int j=0; j<list.size()-i-1; j++) {

                a = list.get(j).toLowerCase();
                b = list.get(j+1).toLowerCase();
                c = list.get(j);
                d = list.get(j+1);

                if (a.compareTo(b) < 0) {
                    list.set(j+1, c);
                    list.set(j, d);
                }
            }
        }
        return list;

    }
}
