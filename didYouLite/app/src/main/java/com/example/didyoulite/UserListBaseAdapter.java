package com.example.didyoulite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class UserListBaseAdapter extends BaseAdapter {

    String names [];
    String profilePic[];
    String role[];

    //getting view abd binding data with xml components
    LayoutInflater inflater;

    public UserListBaseAdapter (Context appcontext, String names[], String profilePic[], String roles[]){

        this.names = names;
        this.profilePic = profilePic;
        this.role = roles;

        inflater = LayoutInflater.from(appcontext);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.activity_dashboard, null);

        TextView name = view.findViewById(R.id.txtName);
        TextView pic = view.findViewById(R.id.imgProfile);
        TextView userRole = view.findViewById(R.id.spnRole);

        name.setText(names[i]);
        pic.setText(profilePic[i]);
        userRole.setText(role[i]);

        return view;
    }
}

