package rrwebsite.com.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView myListView;
    //String[] items;
    //String[] calories;
   // String[] descriptions;

    List<Food> foodList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final ItemAdapter itemAdapter = new ItemAdapter(this,foodList);
        String url = "http://hackdavis.cswhite2000.net/nutrition/";

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        foodList = new ArrayList<>();

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);

                                Food food = new Food();

                                food.name = jsonObject.getString("Name");
                                food.description = jsonObject.getString("Description");
                                food.calories = jsonObject.getDouble("Calories");
                                food.carbs = jsonObject.getDouble("Carbohydrates");
                                food.fat = jsonObject.getDouble("Fat");
                                food.protein =jsonObject.getDouble("Protein");

                                foodList.add(food);

                                Log.w("food", food.toString());

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }  itemAdapter.updateFoodList(foodList);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        // TODO: Handle error
                        Log.w("Failure", error.toString());

                    }
                });

        queue.add(jsonArrayRequest);

        setContentView(R.layout.activity_main);

        //Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        //items = res.getStringArray(R.array.items);
        //calories = res.getStringArray(R.array.calories);
        //descriptions = res.getStringArray(R.array.descriptions);


        myListView.setAdapter(itemAdapter);

       // myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           // @Override
        //    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //        Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
               // showDetailActivity.putExtra("rrwebsite.com.listapp.ITEM_INDEX", i);
        //        startActivity(showDetailActivity);
        //    }
       // });




    }
}
