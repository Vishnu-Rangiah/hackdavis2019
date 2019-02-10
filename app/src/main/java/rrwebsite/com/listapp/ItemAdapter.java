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
    String[] items;
    String[] calories;
    String[] descriptions;

    public ItemAdapter(Context c, String[] i,String[] cal,String[] d){
        items = i;
        calories = cal;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
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

        String name = items[i];
        String ingrd = descriptions[i];
        String cals = calories[i];

        nameTextView.setText(name);
        ingrdTextView.setText(ingrd);
        calsTextView.setText(cals);


        return v;
    }
}



