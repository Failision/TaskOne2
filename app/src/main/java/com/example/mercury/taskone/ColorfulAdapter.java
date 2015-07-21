package com.example.mercury.taskone;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by mercury on 7/6/2015.
 */
public class ColorfulAdapter extends BaseAdapter {

    Context context;
    ArrayList<HomeItems> items;
    LayoutInflater lInflater;

    public ColorfulAdapter(Context context, ArrayList<HomeItems> items) {
        this.context = context;
        this.items = items;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = lInflater.inflate(R.layout.list_item_colorful_adapter, parent, false);
        }
        HomeItems item = (HomeItems) getItem(position);

        int divided = position % 8;
        Log.d(ColorfulAdapter.class.getSimpleName(), position + " " + divided);

        ((TextView) convertView.findViewById(R.id.base_text)).setText(item.b_text);
        ((TextView) convertView.findViewById(R.id.number_text)).setText(item.num_text);
        ((ImageView) convertView.findViewById(R.id.circle_image)).setImageResource(item.id_image);

        if (divided == 7) {
            ((ImageView) convertView.findViewById(R.id.circle_image)).setImageDrawable(null);
        }

        switch (divided) {
            case 0:
                ((ImageView) convertView.findViewById(R.id.circle_image)).setColorFilter(Color.RED);
                break;
            case 1:
                ((ImageView) convertView.findViewById(R.id.circle_image)).setColorFilter(Color.rgb(255, 140, 0));
                break;
            case 2:
                ((ImageView) convertView.findViewById(R.id.circle_image)).setColorFilter(Color.YELLOW);
                break;
            case 3:
                ((ImageView) convertView.findViewById(R.id.circle_image)).setColorFilter(Color.GREEN);
                break;
            case 4:
                ((ImageView) convertView.findViewById(R.id.circle_image)).setColorFilter(Color.CYAN);
                break;
            case 5:
                ((ImageView) convertView.findViewById(R.id.circle_image)).setColorFilter(Color.BLUE);
                break;
            case 6:
                ((ImageView) convertView.findViewById(R.id.circle_image)).setColorFilter(Color.MAGENTA);
                break;
        }
        return convertView;
    }
}

