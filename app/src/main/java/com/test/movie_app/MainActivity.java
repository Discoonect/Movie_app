package com.test.movie_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.test.movie_app.adapter.RecyclerViewAdapter;
import com.test.movie_app.model.Movie;
import com.test.movie_app.util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText edit_search;
    ImageView img_search;
    ArrayList<Movie> list = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    RequestQueue requestQueue;
    int offset;
    JSONObject jsonObject = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        Log.i("aaa",""+offset);


        JsonObjectRequest request = new JsonObjectRequest(
            Request.Method.GET,
            Util.BASE_URL + "/api/v1/movie?offset="+offset, null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("movie");

                        for(int i=0; i<jsonArray.length(); i++){
                            jsonObject = jsonArray.getJSONObject(i);

                            int id = jsonObject.getInt("id");
                            String title = jsonObject.getString("title");
                            String genre = jsonObject.getString("genre");
                            int attendance = jsonObject.getInt("attendance");
                            String year = jsonObject.getString("year");

                            Movie movies = new Movie(id,title,genre,attendance,year);

                            list.add(movies);
                        }
                        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,list);
                        recyclerView.setAdapter(recyclerViewAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {


                }
            }
        );
        Volley.newRequestQueue(MainActivity.this).add(request);
    }
}