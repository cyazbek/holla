package com.chrisyazbek.holla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ychri on 2/5/2017.
 */

public class HollazListItemAdapter extends BaseAdapter {

    Context context;
    ArrayList<ContactLocation> contacts;
    String [] data;
    private static LayoutInflater inflater = null;

    public HollazListItemAdapter(Context context, String[] data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public HollazListItemAdapter(Context context, ArrayList<ContactLocation> contacts) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.contacts = contacts;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.contact_row, null);
        TextView header = (TextView) vi.findViewById(R.id.header);
        header.setText(contacts.get(position).Phone);
        TextView text = (TextView) vi.findViewById(R.id.text);
        text.setText(contacts.get(position).Location);
        return vi;
    }
}