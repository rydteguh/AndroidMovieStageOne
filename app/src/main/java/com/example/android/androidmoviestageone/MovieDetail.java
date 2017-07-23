package com.example.android.androidmoviestageone;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.androidmoviestageone.utilities.MovieJsonUtils;
import com.example.android.androidmoviestageone.utilities.NetworkUtils;
import com.squareup.picasso.Picasso;

import java.net.URL;

/**
 * Created by rydteguh on 7/10/2017.
 */

public class MovieDetail extends AppCompatActivity{

    private GridLayoutManager lLayout;
    private ImageView moviePhotoDetail;
    private TextView movieTitle;
    private TextView movieReleaseDateDetail;
    private TextView movieRatingDetail;
    private TextView movieOverviewDetail;
    private TextView movieDurationDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        setTitle(null);

        Toolbar topToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        topToolBar.setTitle("Popular Movie");
        topToolBar.setTitleTextColor(Color.WHITE);

        moviePhotoDetail= (ImageView) findViewById(R.id.movie_photo_detail);
        movieReleaseDateDetail = (TextView) findViewById(R.id.movie_year_detail);
        movieRatingDetail = (TextView) findViewById(R.id.movie_rating_detail);
        movieOverviewDetail = (TextView) findViewById(R.id.movie_synopsis_detail);
        movieDurationDetail =  (TextView) findViewById(R.id.movie_duration_detail);
        movieTitle = (TextView) findViewById(R.id.movie_title_detail);

        new AsyncTask<String, Void, MovieObject>() {

            @Override
            protected MovieObject doInBackground(String... params) {


                int movie_id = getIntent().getIntExtra("id",1904);
                URL popularMovieUrl = NetworkUtils.buildUrl(NetworkUtils.MOVIE_DETAIL_URL + movie_id);

                try {
                    String jsonPopularMovieResponse = NetworkUtils
                            .getResponseFromHttpUrl(popularMovieUrl);

                    MovieObject simpleJsonPopularMovieData = MovieJsonUtils
                            .getMovieDetailFromJson(MovieDetail.this, jsonPopularMovieResponse);

                    return simpleJsonPopularMovieData;

                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }

            }

            @Override
            protected void onPostExecute(MovieObject movieObjects) {
                Picasso.with(MovieDetail.this).load(movieObjects.getPhoto()).into(moviePhotoDetail);
                movieOverviewDetail.setText(movieObjects.getOverview());
                movieRatingDetail.setText(movieObjects.getRating());
                movieReleaseDateDetail.setText(movieObjects.getRelease_date());
                movieTitle.setText(movieObjects.getName());
                movieDurationDetail.setText(movieObjects.getDuration());
            }
        }.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



}
