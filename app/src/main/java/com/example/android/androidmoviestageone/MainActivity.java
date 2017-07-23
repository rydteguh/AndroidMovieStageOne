package com.example.android.androidmoviestageone;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.androidmoviestageone.utilities.MovieJsonUtils;
import com.example.android.androidmoviestageone.utilities.NetworkUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private GridLayoutManager lLayout;
    final List<MovieObject> rowListItem = new ArrayList<>();
    final RecycleViewAdapter rcAdapter = new RecycleViewAdapter(MainActivity.this, rowListItem);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(null);

        Toolbar topToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        topToolBar.setTitle("Popular Movie");
        topToolBar.setTitleTextColor(Color.WHITE);
        //topToolBar.setTitleTextColor(getResources().getColor().);

        lLayout = new GridLayoutManager(MainActivity.this, 2);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);


        rView.setAdapter(rcAdapter);

        new AsyncTask<String, Void, List<MovieObject>>() {

            @Override
            protected List<MovieObject> doInBackground(String... params) {


                URL popularMovieUrl = NetworkUtils.buildUrl(NetworkUtils.POPULAR_MOVIE_URL);

                try {
                    String jsonPopularMovieResponse = NetworkUtils
                            .getResponseFromHttpUrl(popularMovieUrl);

                    List<MovieObject> simpleJsonPopularMovieData = MovieJsonUtils
                            .getPopularMovieStringsFromJson(MainActivity.this, jsonPopularMovieResponse);

                    return simpleJsonPopularMovieData;

                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }

            }

            @Override
            protected void onPostExecute(List<MovieObject> movieObjects) {
                rowListItem.clear();
                rowListItem.addAll(movieObjects);
                rcAdapter.notifyDataSetChanged();
            }
        }.execute();
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
        if (id == R.id.sort_popular) {
            new AsyncTask<String, Void, List<MovieObject>>() {

                @Override
                protected List<MovieObject> doInBackground(String... params) {


                    URL popularMovieUrl = NetworkUtils.buildUrl(NetworkUtils.POPULAR_MOVIE_URL);

                    try {
                        String jsonPopularMovieResponse = NetworkUtils
                                .getResponseFromHttpUrl(popularMovieUrl);

                        List<MovieObject> simpleJsonPopularMovieData = MovieJsonUtils
                                .getPopularMovieStringsFromJson(MainActivity.this, jsonPopularMovieResponse);

                        return simpleJsonPopularMovieData;

                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }

                }

                @Override
                protected void onPostExecute(List<MovieObject> movieObjects) {
                    rowListItem.clear();
                    rowListItem.addAll(movieObjects);
                    rcAdapter.notifyDataSetChanged();
                }
            }.execute();
            return true;
        }

        if (id == R.id.sort_top_rated) {
            new AsyncTask<String, Void, List<MovieObject>>() {

                @Override
                protected List<MovieObject> doInBackground(String... params) {


                    URL popularMovieUrl = NetworkUtils.buildUrl(NetworkUtils.TOP_RATED_URL);

                    try {
                        String jsonPopularMovieResponse = NetworkUtils
                                .getResponseFromHttpUrl(popularMovieUrl);

                        List<MovieObject> simpleJsonPopularMovieData = MovieJsonUtils
                                .getPopularMovieStringsFromJson(MainActivity.this, jsonPopularMovieResponse);

                        return simpleJsonPopularMovieData;

                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }

                }

                @Override
                protected void onPostExecute(List<MovieObject> movieObjects) {
                    rowListItem.clear();

                    if(movieObjects != null) {
                        rowListItem.addAll(movieObjects);
                        rcAdapter.notifyDataSetChanged();
                    }
                }
            }.execute();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}