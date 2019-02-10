package rrwebsite.com.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] names;
    Double[] calories;
    String[] descriptions;
    Double[] fat;
    Double[] carbs;
    Double[] protein;



    public ItemAdapter(Context c, String[] n,Double[] cal,String[] d,Double[] f,Double[] carb, Double[] pro){
        names = n;
        calories = cal;
        descriptions = d;
        fat = f;
        carbs= carb;
        protein = pro;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];
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

        String name = names[i];
        String ingrd = descriptions[i];
        Double cals = calories[i];
        Double fats = fat[i];
        Double proteins = protein[i];
        Double carb = carbs[i];

        nameTextView.setText(name);
        ingrdTextView.setText(ingrd);
        calsTextView.setText(toString(cals));
        fatsTextView.setText(toString(fats));
        proteinsTextView.setText(toString(proteins));
        carbTextView.setText(toString(carb));



        return v;
    }

    private String toString(Double cals) {
        return cals+"";
    }
}



