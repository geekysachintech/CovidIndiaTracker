package com.example.kovidindiatracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import okhttp3.Callback;

public class CustomAdapter extends ArrayAdapter<DataModel> {

    private ArrayList<DataModel> dataset;
    Context mContext;

    int resource;


    TextView textView1, textView2, textView3, textView4, textView5;


    public CustomAdapter(Context context, int resource, ArrayList<DataModel> data){
        super( context, resource, data);
        this.dataset = data;
        this.resource = resource;
        this.mContext = context;
    }

    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DataModel dataModel = getItem(position);
        //ViewHolder viewHolder;
        //final View result;
        //viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_list, parent, false);
            View header =  inflater.inflate(R.layout.list_header, parent, false);

            textView1 = convertView.findViewById(R.id.stateTv);
            textView2 = convertView.findViewById(R.id.confirmedTv);
            textView3 = convertView.findViewById(R.id.activeTv);
            textView4 = convertView.findViewById(R.id.recoveredTv);
            textView5 = convertView.findViewById(R.id.deceasedTv);
            //result = convertView;
//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? )
        //assert dataModel != null;
        textView1.setText(dataModel.getState());
        textView2.setText(dataModel.getConfirmed());
        textView3.setText(dataModel.getActive());
        textView4.setText(dataModel.getRecovered());
        textView5.setText(dataModel.getDecesaed());

        return convertView;
    }
}
