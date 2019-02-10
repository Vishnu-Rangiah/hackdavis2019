package rrwebsite.com.listapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    //  String[] names;
    // Double[] calories;
    // String[] descriptions;
    // Double[] fat;
    //Double[] carbs;
    //Double[] protein;
    List<Food> foodList;


    public ItemAdapter(Context c, List<Food> f) {
        foodList = f;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        if(foodList==null){
            return 0;

        }
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView ingrdTextView = (TextView) v.findViewById(R.id.ingrdTextView);
        TextView calsTextView = (TextView) v.findViewById(R.id.calsTextView);
        TextView fatsTextView = (TextView) v.findViewById(R.id.fattextView2);
        TextView proteinsTextView = (TextView) v.findViewById(R.id.proteinTextView);
        TextView carbTextView = (TextView) v.findViewById(R.id.carbsTextView);

        String name = foodList.get(i).name;
        String ingrd = foodList.get(i).description;
        Double cals = foodList.get(i).calories;
        Double fats = foodList.get(i).fat;
        Double proteins = foodList.get(i).protein;
        Double carb = foodList.get(i).carbs;

        nameTextView.setText(name);
        ingrdTextView.setText(ingrd + "\n");
        calsTextView.setText("calories: "+toString(cals) +"g");
        fatsTextView.setText("fats: "+toString(fats)+"g");
        proteinsTextView.setText("protein: "+toString(proteins)+"g");
        carbTextView.setText("carbs: "+toString(carb)+"g");
        //calsTextView.setText(toString(cals));
        //fatsTextView.setText(toString(fats));
        //proteinsTextView.setText(toString(proteins));
        //carbTextView.setText(toString(carb));


        return v;
    }

    private String toString(Double element) {
        return element + "";
    }

    public void updateFoodList(List<Food> foods){

        foodList = foods;



        notifyDataSetChanged();


    }


}