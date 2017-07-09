package com.example.android.androidmoviestageone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private GridLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(null);

        Toolbar topToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        topToolBar.setLogo(R.mipmap.ic_launcher);
        topToolBar.setLogoDescription(getResources().getString(R.string.logo_desc));

        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(MainActivity.this, 4);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecycleViewAdapter rcAdapter = new RecycleViewAdapter(MainActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        if (id == R.id.action_refresh) {
            Toast.makeText(MainActivity.this, "Refresh App", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.action_new) {
            Toast.makeText(MainActivity.this, "Create Text", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private List<ItemObject> getAllItemList() {

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("United States", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("Canada", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("United Kingdom", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("Germany", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("Sweden", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("United Kingdom", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("Germany", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("Sweden", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("United States", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("Canada", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("United Kingdom", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("Germany", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("Sweden", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("United Kingdom", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("Germany", R.mipmap.ic_launcher));
        allItems.add(new ItemObject("Sweden", R.mipmap.ic_launcher));

        return allItems;
    }
}