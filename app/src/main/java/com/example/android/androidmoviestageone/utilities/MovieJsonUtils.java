package com.example.android.androidmoviestageone.utilities;

import android.content.ContentValues;
import android.content.Context;

import com.example.android.androidmoviestageone.MovieObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rydteguh on 7/10/2017.
 */

public class MovieJsonUtils {

    final String OWM_MESSAGE_CODE = "cod";

    public static List<MovieObject> getPopularMovieStringsFromJson(Context context, String movieJsonStr)
            throws JSONException {

        List<MovieObject> movieResponse = new ArrayList<>();

        JSONObject movieJson = new JSONObject(movieJsonStr);
        JSONArray movieResultArray = movieJson.getJSONArray("results");

        for (int i = 0; i < movieResultArray.length(); i++) {

            JSONObject movieObject = movieResultArray.getJSONObject(i);

            MovieObject responseObject = new MovieObject();

            responseObject.setId(movieObject.getInt("id"));
            responseObject.setName(movieObject.getString("title"));
            responseObject.setPhoto("http://image.tmdb.org/t/p/w185" + movieObject.getString("backdrop_path"));

            movieResponse.add(responseObject);
        }

        return movieResponse;
    }

    public static MovieObject getMovieDetailFromJson(Context context, String movieJsonStr)
            throws JSONException{

        MovieObject movieResponse = new MovieObject();

        JSONObject movieJson = new JSONObject(movieJsonStr);

        movieResponse.setId(movieJson.getInt("id"));
        movieResponse.setName(movieJson.getString("title"));
        movieResponse.setPhoto("http://image.tmdb.org/t/p/w185" + movieJson.getString("backdrop_path"));
        movieResponse.setOverview(movieJson.getString("overview"));
        movieResponse.setRating(movieJson.getString("vote_average"));
        movieResponse.setRelease_date(movieJson.getString("release_date"));

        return movieResponse;
    }


    public static ContentValues[] getFullWeatherDataFromJson(Context context, String forecastJsonStr) {
        /** This will be implemented in a future lesson **/
        return null;
    }

}
